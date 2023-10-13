package Repository;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Generator.GenerateSelect;
import Parser.OrderParser;
import Parser.SearchParser;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongDanhSach;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongDanhSach;
import jakarta.ejb.Timeout;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PhongRepository extends Repository {

    public List<PhongDanhSach> GetDanhSachPhong (Integer trang, Integer sodong, String search, String order) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<PhongDanhSach> query = builder.createQuery(PhongDanhSach.class);
        Root<OrgOrganization> root = query.from(OrgOrganization.class);

        OrgOrganization org = new OrgOrganization();
        DmcThongTinKhoaPhong dmc = new DmcThongTinKhoaPhong();

        // Join
        Join<OrgOrganization, DmcThongTinKhoaPhong> join = root.join(org.GetThongTinPhong(), JoinType.LEFT);
        join.on(builder.equal(root.get(org.GetId()), join.get(dmc.GetPhongId())));
        join.on(builder.equal(root.get(org.GetMaDonVi()), join.get(dmc.GetKhoaId())));

        Join<OrgOrganization, OrgOrganization> join2 = root.join(org.GetDonVi(), JoinType.LEFT);
        join2.on(builder.equal(root.get(org.GetMaDonVi()), join2.get(org.GetId())));

        // Select
        query.multiselect(GenerateSelect.Generate(root, new PhongDanhSach()));

        // Where
        query.where( builder.equal(root.get(org.GetLevel()), "5"));
        query.where( builder.equal(root.get(org.GetMaDonVi()), 14331));
        if(search != null)
            query.where(new SearchParser(builder, builder.conjunction(), root).Parse(search));

        // Order
        if(order != null) {
            query.orderBy(new OrderParser<>(builder, builder.conjunction(), root).Parse(order));
        }

        Query q = super.entityManager.createQuery(query);
        q.setFirstResult(trang * sodong);
        q.setMaxResults(sodong);
        return q.getResultList();
    }

    public PhongChiTiet GetChiTiet (long OrgId) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<PhongChiTiet> query = builder.createQuery(PhongChiTiet.class);
        Root<OrgOrganization> root = query.from(OrgOrganization.class);

        OrgOrganization org = new OrgOrganization();
        DmcThongTinKhoaPhong dmc = new DmcThongTinKhoaPhong();

        // Join
        Join<OrgOrganization, DmcThongTinKhoaPhong> join = root.join(org.GetThongTinPhong(), JoinType.LEFT);
        join.on(builder.equal(root.get(org.GetId()), join.get(dmc.GetPhongId())));
        join.on(builder.equal(root.get(org.GetMaDonVi()), join.get(dmc.GetKhoaId())));

        Join<OrgOrganization, OrgOrganization> join2 = root.join(org.GetDonVi(), JoinType.INNER);
        join2.on(builder.equal(root.get(org.GetMaDonVi()), join2.get(org.GetId())));

        // Select
        query.multiselect(GenerateSelect.Generate(root, new PhongChiTiet()));
//        query.multiselect(root.get(org.GetId()), root.get(org.GetCode()), join.get(dmc.GetMaKhoaBYT()),
//                root.get(org.GetName()), root.get(org.GetType()), root.get(org.GetGhiChu()),
//                join.get(dmc.GetChuyenKhoaId()));

        // Where
        query.where(builder.equal(root.get(org.GetLevel()), "5"));
        query.where(builder.equal(root.get(org.GetMaDonVi()), 14331));
        query.where(builder.equal(root.get(org.GetId()), OrgId));

        Query q = super.entityManager.createQuery(query);
        return (PhongChiTiet) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void Them (OrgOrganization org, DmcThongTinKhoaPhong dmc) {
        org.SetMaSoYTe(1);
        org.persistAndFlush();
        dmc.SetKhoaId(org.getOrgId());
        dmc.SetCSYTId(14331);
        dmc.SetHangBhTraiTuyenId("2");
        dmc.persistAndFlush();
    }

//    @Transactional
//    @Timeout
//    public int XoaThongTinPhong (long OrgId) throws IllegalAccessException {
//        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
//        CriteriaDelete<DmcThongTinKhoaPhong> delete = builder.createCriteriaDelete(DmcThongTinKhoaPhong.class);
//        Root<DmcThongTinKhoaPhong> root = delete.from(DmcThongTinKhoaPhong.class);
//
//        DmcThongTinKhoaPhong dmc = new DmcThongTinKhoaPhong();
//
//        // Where
//        delete.where(builder.equal(root.get(dmc.GetKhoaId()), OrgId));
//        delete.where(builder.equal(root.get(dmc.GetPhongId()), 0));
//
//        Query deleteQuery = super.entityManager.createQuery(delete);
//        return deleteQuery.executeUpdate();
//    }

    @Transactional
    @Timeout
    public int CapNhatStatus (long OrgId) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaUpdate<OrgOrganization> update = builder.createCriteriaUpdate(OrgOrganization.class);
        Root<OrgOrganization> root = update.from(OrgOrganization.class);

        OrgOrganization org = new OrgOrganization();

        // Set
        update.set(org.GetTrangThai(), 0);

        // Where
        update.where(builder.equal(root.get(org.GetId()), OrgId));
        update.where(builder.equal(root.get(org.GetLevel()), "5"));

        Query deleteQuery = super.entityManager.createQuery(update);
        return deleteQuery.executeUpdate();
    }
}
