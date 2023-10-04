package repository;

import DAO.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Timeout;
import predicate.CapNhat;
import predicate.Xoa;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import search.SearchCriteria;
import predicate.ChiTiet;
import predicate.DanhSach;
import java.util.List;

@ApplicationScoped
public class KhoaRepository extends  Repo{

    public List<KhoaDanhSach> getDanhSachKhoa (List<SearchCriteria> searchCriteriaList) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<KhoaDanhSach> query = builder.createQuery(KhoaDanhSach.class);
        Root<org_organization> root = query.from(org_organization.class);

        query.multiselect(root.get("org_id"), root.get("org_code"), root.get("org_name"), root.get("status"));
        query.where(DanhSach.get(List.of(new org_organization()), builder, List.of(root), searchCriteriaList, "danhsachkhoa"));
        query.orderBy(builder.desc(root.get("status")), builder.asc(root.get("org_name")), builder.asc(root.get("org_code")));

        Query q = super.entityManager.createQuery(query);
        int page = Integer.parseInt((String) searchCriteriaList.get(0).value);
        int pageSize = Integer.parseInt((String) searchCriteriaList.get(1).value);
        q.setFirstResult(page * pageSize);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public KhoaChiTiet getChiTiet (SearchCriteria org_id) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<KhoaChiTiet> query = builder.createQuery(KhoaChiTiet.class);
        Root<org_organization> root = query.from(org_organization.class);

        Join<org_organization, dmc_thongtinkhoaphong> join = root.join("khoa", JoinType.LEFT);
        join.on(builder.and(builder.equal(root.get("org_id"), join.get("khoaid")), builder.equal(join.get("phongid"), 0)));

        query.multiselect(root.get("org_id"), root.get("org_code"), root.get("org_name"), root.get("org_type"), root.get("note"), root.get("status"),
                          join.get("makhoabyt"), join.get("chuyenkhoaid"));
        query.where(DanhSach.get(List.of(new org_organization()), builder, List.of(root), List.of(org_id), "chitietkhoa"));

        Query q = super.entityManager.createQuery(query);
        return (KhoaChiTiet) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void them (org_organization org, dmc_thongtinkhoaphong dmc) {
        org.persistAndFlush();
        dmc.khoaid = org.org_id;
        dmc.phongid = 0L;
        dmc.csytid = 14331;
        dmc.persistAndFlush();
    }

    @Transactional
    @Timeout
    public int xoaThongTinKhoa (SearchCriteria org_id) {
        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaDelete<dmc_thongtinkhoaphong> delete = builder.createCriteriaDelete(dmc_thongtinkhoaphong.class);
        Root<dmc_thongtinkhoaphong> root = delete.from(dmc_thongtinkhoaphong.class);
        Predicate predicate = new Xoa(builder, builder.conjunction()).getPredicate(root, org_id);

        delete.where(predicate);

        Query deleteQuery = super.entityManager.createQuery(delete);
        return deleteQuery.executeUpdate();
    }

    @Transactional
    @Timeout
    public int capnhatStatus (SearchCriteria org_id) {
        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaUpdate<org_organization> update = builder.createCriteriaUpdate(org_organization.class);
        Root<org_organization> root = update.from(org_organization.class);
        Predicate predicate = new CapNhat(builder, builder.conjunction()).getPredicate(root, org_id);

        update.set("status", 0);
        update.where(predicate);

        Query deleteQuery = super.entityManager.createQuery(update);
        return deleteQuery.executeUpdate();
    }
}
