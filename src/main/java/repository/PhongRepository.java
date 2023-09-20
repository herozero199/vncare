package repository;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Timeout;
import predicate.CapNhat;
import predicate.ChiTiet;
import predicate.DanhSach;
import predicate.Xoa;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import request.PhongChiTiet;
import request.PhongDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class PhongRepository extends Repo{

    public List<PhongDanhSach> getDanhSachPhong (List<SearchCriteria> searchCriteriaList) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<PhongDanhSach> query = builder.createQuery(PhongDanhSach.class);
        Root<org_organization> root = query.from(org_organization.class);

        Join<org_organization, dmc_thongtinkhoaphong> join1 = root.join("phong", JoinType.LEFT);
        join1.on(builder.and(builder.equal(root.get("org_id"), join1.get("phongid")),
                             builder.equal(root.get("parent_id"), join1.get("khoaid"))));

        Join<org_organization, org_organization> join2 = root.join("donvi", JoinType.LEFT);
        join2.on(builder.and(builder.equal(root.get("parent_id"), join2.get("org_id"))));

        Predicate predicate = new DanhSach(builder, builder.conjunction()).getPredicateKhoa_Phong(searchCriteriaList, root, "5");
        predicate = builder.and(predicate, builder.equal(root.get("org_level"), "5"));

        query.multiselect(root.get("org_id"), root.get("parent_id"), root.get("org_code"), root.get("org_name"), root.get("status"));
        query.where(predicate);
        query.orderBy(builder.desc(root.get("status")), builder.asc(root.get("org_name")), builder.asc(root.get("org_code")));

        Query q = super.entityManager.createQuery(query);
        int page = (int) searchCriteriaList.get(0).value;
        int pageSize = (int) searchCriteriaList.get(1).value;
        q.setFirstResult(page * pageSize);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public PhongChiTiet getChiTiet (SearchCriteria org_id) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<PhongChiTiet> query = builder.createQuery(PhongChiTiet.class);
        Root<org_organization> root = query.from(org_organization.class);

        Join<org_organization, dmc_thongtinkhoaphong> joinPhong = root.join("phong", JoinType.LEFT);
        joinPhong.on(builder.and(builder.equal(root.get("org_id"), joinPhong.get("phongid")),
                             builder.equal(root.get("parent_id"), joinPhong.get("khoaid"))));

        Join<org_organization, org_organization> joinDonVi = root.join("donvi", JoinType.INNER);
        joinDonVi.on(builder.and(builder.equal(root.get("parent_id"), joinDonVi.get("org_id"))));

        Predicate predicate = new ChiTiet(builder, builder.conjunction()).getPredicateKhoa_Phong(root, org_id, "5");

        query.multiselect(root.get("org_id"), root.get("parent_id"), root.get("org_code"), joinPhong.get("sophong"), root.get("org_name"), joinPhong.get("tenphong_chuyenkhoa"),
                          root.get("org_type"), joinPhong.get("loaibenhanid"), root.get("note"), joinPhong.get("stt_phongkham"), joinPhong.get("sophong_manhinh"),
                          joinPhong.get("chuyenkhoaphongkham"), root.get("org_address"), joinPhong.get("phonggiaosu"), joinPhong.get("tuvantuxa"), joinPhong.get("khamcsyt"),
                          root.get("status"));
        query.where(predicate);

        Query q = super.entityManager.createQuery(query);
        return (PhongChiTiet) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void them (org_organization org, dmc_thongtinkhoaphong dmc) {
        org.persistAndFlush();
        dmc.persistAndFlush();
    }

    @Transactional
    @Timeout
    public int xoaThongTinPhong (SearchCriteria org_id) {
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
