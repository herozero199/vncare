package GenericParser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Search.Parenthesis;
import Search.Operators;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericParser {

    CriteriaBuilder builder;
    Predicate predicate;
    Root<?> root;

    public GenericParser(CriteriaBuilder builder, Predicate predicate, Root<?> root) {
        this.builder = builder;
        this.predicate = predicate;
        this.root = root;
    }

    Stack<String> OperandsStack = new Stack<>();
    Stack<String> OperatorsStack = new Stack<>();

    public Predicate Parse(String search) {

        // '([\w_]+)'|([\w_. ]+)|([&|])|([()])|([+:*_=])
        String keyRegex = "([\\w_]+)";
        String valueRegex = "([\\w_. ]+)";
        String connectorRegex = "([&|])";
        String parenthesisRegex = "([()])";
        String operatorsRegex = "([+:*_=><])";
        Pattern pattern= Pattern.compile(keyRegex+"|"+valueRegex+"|"+connectorRegex+"|"+parenthesisRegex+"|"+operatorsRegex);
        Matcher matcher = pattern.matcher(search);

        while(matcher.find()) {

            String match = matcher.group();
            if(Parenthesis.get(match) == Parenthesis.RIGHT) {
                BuildPredicateEndWithParenthesis();
            } else {
                if(Operators.get(match) != null)
                    OperatorsStack.push(match);
                else
                    OperandsStack.push(match);
            }
        }

        while(!OperandsStack.empty())
            BuildPredicate();

        return predicate;
    }

     private void BuildPredicateEndWithParenthesis() {

        while(true) {
            String value = OperandsStack.pop();
            String operator = OperatorsStack.pop();
            String key = OperandsStack.pop();

            predicate = builder.and(GeneratePredicate.Generate(key, operator, value, root, builder), predicate);

            String connector = OperandsStack.pop();
            if(Parenthesis.get(connector) == Parenthesis.LEFT)
                return;

            predicate = builder.and(GeneratePredicate.Generate(connector, root, builder), predicate);
        }
     }

     private void BuildPredicate() {

         while (true) {
             String value = OperandsStack.pop();

             String operator = OperatorsStack.pop();
             String key = OperandsStack.pop();

             predicate = builder.and(GeneratePredicate.Generate(key, operator, value, root, builder), predicate);

             if(OperandsStack.empty())
                 return;
             String connector = OperandsStack.pop();

             predicate = builder.and(GeneratePredicate.Generate(connector, root, builder), predicate);
         }
     }
}
