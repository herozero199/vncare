package Repository;

import DAO.*;
import Generator.GenerateSelect;
import Parser.OrderParser;
import Parser.SearchParser;
import Request.Khoa.KhoaChiTiet;
import jakarta.ejb.Timeout;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Parameter;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import Request.Khoa.KhoaDanhSach;
import jakarta.transaction.Transactional;

import javax.security.auth.login.Configuration;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class KhoaRepository extends  Repository{

    public List<KhoaDanhSach> GetDanhSachKhoa (Integer trang, Integer sodong, String search, String order) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<KhoaDanhSach> query = builder.createQuery(KhoaDanhSach.class);
        Root<OrgOrganization> root = query.from(OrgOrganization.class);

        // Select
        query.multiselect(GenerateSelect.Generate(root, new KhoaDanhSach()));

        // Where
        OrgOrganization org = new OrgOrganization();
        query.where( builder.equal(root.get(org.GetLevel()), "4"));
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

    public KhoaChiTiet GetChiTiet (long OrgId) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<KhoaChiTiet> query = builder.createQuery(KhoaChiTiet.class);
        Root<OrgOrganization> root = query.from(OrgOrganization.class);

        OrgOrganization org = new OrgOrganization();
        DmcThongTinKhoaPhong dmc = new DmcThongTinKhoaPhong();

        // Join
        Join<OrgOrganization, DmcThongTinKhoaPhong> join = root.join(org.GetThongTinKhoa(), JoinType.LEFT);
        join.on(builder.and(builder.equal(root.get(org.GetId()), join.get(dmc.GetKhoaId())), builder.equal(join.get(dmc.GetPhongId()), 0)));

        // Select
        query.multiselect(GenerateSelect.Generate(root, new KhoaChiTiet()));

        // Where
        query.where(builder.equal(root.get(org.GetLevel()), "4"));
        query.where(builder.equal(root.get(org.GetMaDonVi()), 14331));
        query.where(builder.equal(root.get(org.GetId()), OrgId));

        Query q = super.entityManager.createQuery(query);
        return (KhoaChiTiet) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void Them (OrgOrganization org, DmcThongTinKhoaPhong dmc) {
        org.SetMaSoYTe(1);
        org.SetTrangThai(1);
        org.persistAndFlush();
        dmc.SetKhoaId(org.getOrgId());
        dmc.SetPhongId(0L);
        dmc.SetCSYTId(14331);
        dmc.persistAndFlush();
    }

    @Transactional
    @Timeout
    public int XoaThongTinKhoa (long OrgId) {
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
    public int CapNhatStatus (long OrgId) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaUpdate<OrgOrganization> update = builder.createCriteriaUpdate(OrgOrganization.class);
        Root<OrgOrganization> root = update.from(OrgOrganization.class);

        OrgOrganization org = new OrgOrganization();

        // Set
        update.set(org.GetTrangThai(), 0);

        // Where
        update.where(builder.equal(root.get(org.GetId()), OrgId));

        Query deleteQuery = super.entityManager.createQuery(update);
        return deleteQuery.executeUpdate();
    }
}
