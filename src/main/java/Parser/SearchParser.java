package Parser;

import Search.Connectors;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Search.Parenthesis;
import Search.Operators;
import Generator.GeneratePredicate;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchParser {

    CriteriaBuilder builder;
    Predicate predicate;
    Root<?> root;

    public SearchParser(CriteriaBuilder builder, Predicate predicate, Root<?> root) {
        this.builder = builder;
        this.predicate = predicate;
        this.root = root;
    }

    Stack<String> OperandsStack = new Stack<>();
    Stack<Predicate> PredicatesStack = new Stack<>();
    Stack<Connectors> ConnectorsStack = new Stack<>();

    public Predicate Parse(String search) {

        // '([\w_]+)'|([\w_. ]+)|([&|])|([()])|([+:*_=])
        String keyRegex = "([\\w_]+)";
        String valueRegex = "([\\w_. ]+)";
        String connectorRegex = "([&|])";
        String parenthesisRegex = "([()])";
        String operatorsRegex = "([+:*_=><!])";
        Pattern pattern= Pattern.compile(keyRegex+"|"+valueRegex+"|"+connectorRegex+"|"+parenthesisRegex+"|"+operatorsRegex);
        Matcher matcher = pattern.matcher(search);

        while(matcher.find()) {

            String match = matcher.group();
            if(Parenthesis.get(match) == Parenthesis.RIGHT) {
                BuildPredicate("(");
                ConnectPredicate();
            } else if(Connectors.get(match) != null) {
                ConnectorsStack.push(Connectors.get(match));
            }else {
                OperandsStack.push(match);
            }
        }

        while(!OperandsStack.empty())
            BuildPredicate(null);

        ConnectPredicate();

        return PredicatesStack.pop();
    }

    private void ConnectPredicate() {

        while(!ConnectorsStack.empty()) {

            PredicatesStack.push(GeneratePredicate.Generate(ConnectorsStack.pop(), root, builder, PredicatesStack.pop(), PredicatesStack.pop()));
        }
    }

     private void BuildPredicate(String end) {

         boolean con = true;
         while (con) {
             String value = OperandsStack.pop();
             String operator = OperandsStack.pop();
             String key = OperandsStack.pop();

             try {
                 PredicatesStack.push(GeneratePredicate.Generate(key, operator, value, root, builder));
             } catch (Exception e ) {
                 System.out.println(e.getMessage());
             }

             if(OperandsStack.peek().equals(end) || OperandsStack.empty()) {
                 con = false;
                 if(!OperandsStack.empty())
                     OperandsStack.pop();
             }
         }
     }
}
