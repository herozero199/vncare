package Parser;

import Generator.GenerateOrder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderParser {

    Root<?> root;
    Predicate predicate;
    CriteriaBuilder builder;

    public OrderParser(CriteriaBuilder builder, Predicate predicate, Root<?> root) {
        this.builder = builder;
        this.predicate = predicate;
        this.root = root;
    }

    public List<Order> Parse(String order) {

        String keyRegex = "([\\w_ ]+)";
        String ascRegex = "(>)";
        String descRegex = "(<)";

        Pattern pattern = Pattern.compile(keyRegex+"|"+ascRegex+"|"+descRegex+",");
        Matcher matcher = pattern.matcher(order+",");

        List<Order> result = new ArrayList<>();
        while(matcher.find()) {

            String key = matcher.group(1);
            String asc = matcher.group(2);
            String desc = matcher.group(3);

            result.add(GenerateOrder.Generate(key, asc, desc, root, builder));
        }

        return result;
     }
}
