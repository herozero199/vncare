package predicate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;

public class DieuKien {

    CriteriaBuilder builder;
    Predicate predicate;

    public DieuKien() {}

    public DieuKien(CriteriaBuilder builder, Predicate predicate) {
        this.builder = builder;
        this.predicate = predicate;
    }
}
