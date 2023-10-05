package GenericParser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Search.Connectors;
import Search.Operators;

public class GeneratePredicate {

    public static<T> Predicate Generate(String key, String operator, String value, Root<T> root, CriteriaBuilder builder) {

        Operators op = Operators.get(operator);

        if(op == Operators.EQUALITY) {
            if(root.get(key).getJavaType() == String.class)
                return builder.like(root.get(key), "%"+value+"%");
            else if(root.get(key).getJavaType() == Integer.class)
                return builder.equal(root.get(key), Integer.parseInt(value));
            else if(root.get(key).getJavaType() == Double.class)
                return builder.equal(root.get(key), Double.parseDouble(value));
            else if(root.get(key).getJavaType() == Long.class)
                return builder.equal(root.get(key), Double.parseDouble(value));
        }
        else if(op == Operators.GREATER_THAN) {
            if(root.get(key).getJavaType() == Integer.class)
                return builder.greaterThan(root.get(key), Integer.parseInt(value));
            else if(root.get(key).getJavaType() == Long.class)
                return builder.greaterThan(root.get(key), Long.parseLong(value));
            else if(root.get(key).getJavaType() == Double.class)
                return builder.greaterThan(root.get(key), Double.parseDouble(value));
        }
        else if(op == Operators.LESS_THAN) {
            if(root.get(key).getJavaType() == Integer.class)
                return builder.lessThan(root.get(key), Integer.parseInt(value));
            else if(root.get(key).getJavaType() == Long.class)
                return builder.lessThan(root.get(key), Long.parseLong(value));
            else if(root.get(key).getJavaType() == Double.class)
                return builder.lessThan(root.get(key), Double.parseDouble(value));
        }
        else if(op == Operators.NEGATION) {
            if(root.get(key).getJavaType() == String.class)
                return builder.notLike(root.get(key), "%"+value+"%");
            if(root.get(key).getJavaType() == Integer.class)
                return builder.notEqual(root.get(key), Integer.parseInt(value));
            else if(root.get(key).getJavaType() == Long.class)
                return builder.notEqual(root.get(key), Long.parseLong(value));
            else if(root.get(key).getJavaType() == Double.class)
                return builder.notEqual(root.get(key), Double.parseDouble(value));
        }
        return null;
    }

    static<T> Predicate Generate(String connector, Root<T> root, CriteriaBuilder builder) {

        Connectors co = Connectors.get(connector);
        if(co == Connectors.AND)
            return builder.and();
        else if(co == Connectors.OR)
            return builder.or();
        return null;
    }

}
