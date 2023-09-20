package predicate;

import DAO.org_officer;
import DAO.org_organization;
import jakarta.persistence.criteria.*;
import search.SearchCriteria;

public class ChiTiet extends  DieuKien{

    public ChiTiet(CriteriaBuilder builder, Predicate predicate) {
        super(builder, predicate);
    }

    public Predicate getPredicateKhoa_Phong(Root<org_organization> root, SearchCriteria org_id, String org_level) {
        this.predicate = builder.and(builder.equal(root.get("org_level"), org_level),
                                     builder.equal(root.get("org_id"), org_id.value));

        return this.predicate;
    }

    public Predicate getPredicateNhanVien(Root<org_officer> root, SearchCriteria officer_id) {
        this.predicate = builder.equal(root.get("officer_id"), officer_id.value);

        return predicate;
    }
}
