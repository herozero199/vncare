package predicate;

import DAO.org_organization;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import search.SearchCriteria;

public class CapNhat extends DieuKien{

    public CapNhat(CriteriaBuilder builder, Predicate predicate) {
        super(builder, predicate);
    }

    public Predicate getPredicate(Root<org_organization> org, SearchCriteria org_id) {
        this.predicate = super.builder.equal(org.get("org_id"), org_id.value);
        return this.predicate;
    }
}
