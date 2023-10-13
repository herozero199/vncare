package Repository;

import DAO.DichVuKham;
import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Generator.GenerateSelect;
import Parser.OrderParser;
import Parser.SearchParser;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;
import jakarta.ejb.Timeout;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DichVuKhamRepository extends Repository {

    public List<DichVuKham> GetDanhSachDichVu (Integer trang, Integer sodong, String search, String order) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<DichVuKham> query = builder.createQuery(DichVuKham.class);
        Root<DichVuKham> root = query.from(DichVuKham.class);

        // Select
        query.select(root);

        // Where
        DichVuKham dvk = new DichVuKham();
        query.where( builder.equal(root.get(dvk.getDichVuId()), 14331));
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

    public DichVuKham GetChiTiet (long DichVuId) throws IllegalAccessException {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<DichVuKham> query = builder.createQuery(DichVuKham.class);
        Root<DichVuKham> root = query.from(DichVuKham.class);

        DichVuKham dvk = new DichVuKham();

        // Select
        query.select(root);

        // Where
        query.where(builder.equal(root.get(dvk.getDichVuId()), DichVuId));
        query.where(builder.equal(root.get(dvk.getCSYTId()), 14331));

        Query q = super.entityManager.createQuery(query);
        return (DichVuKham) q.getSingleResult();
    }

    @Transactional
    @Timeout
    public void Them (DichVuKham dichVuKham) {
        dichVuKham.persistAndFlush();
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
    public int CapNhatStatus (DichVuKham dichVuKham) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaUpdate<DichVuKham> update = builder.createCriteriaUpdate(DichVuKham.class);
        Root<DichVuKham> root = update.from(DichVuKham.class);

        // Set
        update.set(dichVuKham.getMaDichVu(), dichVuKham.getMaDichVuValue());
        update.set(dichVuKham.getTenDichVu(), dichVuKham.getTenDichVuValue());
        // need to update

        // Where
        update.where(builder.equal(root.get(dichVuKham.getDichVuId()), dichVuKham.getDichVuIdValue()));

        Query deleteQuery = super.entityManager.createQuery(update);
        return deleteQuery.executeUpdate();
    }
}
