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
import DAO.DAO;

public class OrderParser <T>{

    Root<T> root;
    Predicate predicate;
    CriteriaBuilder builder;

    public OrderParser(CriteriaBuilder builder, Predicate predicate, Root<T> root) {
        this.builder = builder;
        this.predicate = predicate;
        this.root = root;
    }

    public List<Order> Parse(String order) {

        String keyRegex = "([\\w_ ]+)";
        String valueRegex = "([><])";

        Pattern pattern = Pattern.compile(keyRegex+valueRegex);
        Matcher matcher = pattern.matcher(order);

        List<Order> result = new ArrayList<>();
        while(matcher.find()) {

            String key = matcher.group(1);
            String value = matcher.group(2);

            try {
                result.add(GenerateOrder.Generate(key, value, root, builder));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
     }
}
