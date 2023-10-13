package Generator;


import DAO.DAO;
import Search.Operators;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class GenerateOrder {

    public static<T> Order Generate(String key, String value, Root<T> root, CriteriaBuilder builder) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Method m = root.getJavaType().getMethod("get", String.class);
        String name = (String) m.invoke(root.getJavaType().getDeclaredConstructors()[0].newInstance(), key);

        if(Operators.get(value) == Operators.LESS_THAN) {
            return builder.asc(root.get(name));
        }
        if(Operators.get(value) == Operators.GREATER_THAN) {
            return builder.desc(root.get(name));
        }
        return null;
    }
}
