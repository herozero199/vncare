package Repository;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOfficer;
import DAO.OrgOfficerType;
import DAO.OrgOrganization;
import Generator.GenerateSelect;
import Parser.OrderParser;
import Parser.SearchParser;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;
import Request.NhanVien.NhanVienDanhSach;
import jakarta.ejb.Timeout;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class NhanVienRepository extends Repository {

    public List<NhanVienDanhSach> GetDanhSachNhanVien (Integer trang, Integer sodong, String search, String order) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<NhanVienDanhSach> query = builder.createQuery(NhanVienDanhSach.class);
        Root<OrgOfficer> root = query.from(OrgOfficer.class);

        OrgOfficer officer = new OrgOfficer();
        OrgOfficerType type = new OrgOfficerType();
        OrgOrganization org = new OrgOrganization();

        // Join
        Join<OrgOfficer, OrgOfficerType> join = root.join(officer.GetLoaiNhanVien(), JoinType.LEFT);
        join.on(builder.equal(root.get(officer.GetLoaiNhanVienId()), join.get(type.GetId())));

        Join<OrgOfficer, OrgOrganization> join2 = root.join(officer.GetKhoa(), JoinType.LEFT);
        join2.on(builder.equal(root.get(officer.GetMaKhoa()), join2.get(org.GetId())));

        Join<OrgOfficer, OrgOrganization> join3 = root.join(officer.GetPhong(), JoinType.LEFT);
        join3.on(builder.equal(root.get(officer.GetMaPhong()), join3.get(org.GetId())));

        // Select
        query.multiselect(GenerateSelect.Generate(root, new KhoaDanhSach()));

        // Where
        query.where( builder.equal(root.get(officer.GetTrangThai()), 1));
        query.where( builder.equal(root.get(officer.GetMaCongTy()), 14331));
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

    public OrgOfficer GetChiTiet (long OfficerId) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<OrgOfficer> query = builder.createQuery(OrgOfficer.class);
        Root<OrgOfficer> root = query.from(OrgOfficer.class);

        OrgOfficer officer = new OrgOfficer();

        // Select
        query.select(root);

        // Where
        query.where(builder.equal(root.get(officer.GetMaCongTy()), 1443));
        query.where(builder.equal(root.get(officer.GetNhanVienId()), OfficerId));

        Query q = super.entityManager.createQuery(query);
        return (OrgOfficer) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void Them (OrgOfficer NhanVien) {
        NhanVien.persistAndFlush();
    }

    @Transactional
    @Timeout
    public int XoaThongTinNhanVien (long OrgId) {
        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaDelete<DmcThongTinKhoaPhong> delete = builder.createCriteriaDelete(DmcThongTinKhoaPhong.class);
        Root<DmcThongTinKhoaPhong> root = delete.from(DmcThongTinKhoaPhong.class);

        DmcThongTinKhoaPhong dmc = new DmcThongTinKhoaPhong();

        // Where
        delete.where(builder.equal(root.get(dmc.GetKhoaId()), OrgId));
        delete.where(builder.equal(root.get(dmc.GetPhongId()), 0));

        Query deleteQuery = super.entityManager.createQuery(delete);
        return deleteQuery.executeUpdate();
    }

    @Transactional
    @Timeout
    public int CapNhatStatus (long OfficerId) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaUpdate<OrgOfficer> update = builder.createCriteriaUpdate(OrgOfficer.class);
        Root<OrgOfficer> root = update.from(OrgOfficer.class);

        OrgOfficer org = new OrgOfficer();

        // Set
        update.set(org.GetTrangThai(), 0);

        // Where
        update.where(builder.equal(root.get(org.GetNhanVienId()), OfficerId));

        Query deleteQuery = super.entityManager.createQuery(update);
        return deleteQuery.executeUpdate();
    }
}
