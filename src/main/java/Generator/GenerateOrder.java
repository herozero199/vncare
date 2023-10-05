package Generator;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class GenerateOrder {

    public static Order Generate(String key, String asc, String desc, Root<?> root, CriteriaBuilder builder) {

        if(asc != null)
            return builder.asc(root.get(key));
        if(desc != null)
            return builder.desc(root.get(key));
        return null;
    }
}
