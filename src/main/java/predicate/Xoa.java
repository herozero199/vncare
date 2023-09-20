package predicate;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import search.SearchCriteria;

public class Xoa extends DieuKien{

    public Xoa(CriteriaBuilder builder, Predicate predicate) {
        super(builder, predicate);
    }

    public Predicate getPredicate(Root<dmc_thongtinkhoaphong> root, SearchCriteria org_id) {
        this.predicate = builder.and(builder.equal(root.get("khoaid"), org_id.value),
                                     builder.equal(root.get("phongid"), 0));
        return this.predicate;
    }
}
