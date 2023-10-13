package Repository;

import DAO.HTTaiKhoanCong;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TaiKhoanCongRepository extends Repository {

    public HTTaiKhoanCong GetChiTiet(Long CSYTId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HTTaiKhoanCong> query = builder.createQuery(HTTaiKhoanCong.class);
        Root<HTTaiKhoanCong> root = query.from(HTTaiKhoanCong.class);

        HTTaiKhoanCong taiKhoanCong = new HTTaiKhoanCong();

        // Select
        query.select(root);

        // Where
        query.where(builder.equal(root.get(taiKhoanCong.getCSYTId()), 14331));

        Query q = entityManager.createQuery(query);

        return (HTTaiKhoanCong) q.getSingleResult();
    }

    public int Xoa(Long CSYTId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<HTTaiKhoanCong> query = builder.createCriteriaDelete(HTTaiKhoanCong.class);
        Root<HTTaiKhoanCong> root = query.from(HTTaiKhoanCong.class);

        HTTaiKhoanCong taiKhoanCong = new HTTaiKhoanCong();

        query.where(builder.equal(root.get(taiKhoanCong.getCSYTId()), 14331));

        Query q = entityManager.createQuery(query);
        return q.executeUpdate();
    }

    public void Them(HTTaiKhoanCong taiKhoanCong) {
        taiKhoanCong.persistAndFlush();
    }

    public int Update(HTTaiKhoanCong taiKhoanCong) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<HTTaiKhoanCong> update = builder.createCriteriaUpdate(HTTaiKhoanCong.class);
        Root<HTTaiKhoanCong> root = update.from(HTTaiKhoanCong.class);

        // Set
        update.set(taiKhoanCong.getHisUserCSYT(), taiKhoanCong.getHisUserCSYTValue());
        update.set(taiKhoanCong.getHisPassCSYT(), taiKhoanCong.getHisPassCSYTValue());
        update.set(taiKhoanCong.getHisUserINSR(), taiKhoanCong.getHisUserINSRValue());
        update.set(taiKhoanCong.getHisPassINSR(), taiKhoanCong.getHisPassINSRValue());
        update.set(taiKhoanCong.getTinhId(), taiKhoanCong.getTinhIdValue());
        update.set(taiKhoanCong.getHuyenId(), taiKhoanCong.getHuyenIdValue());
        update.set(taiKhoanCong.getTenCSYT(), taiKhoanCong.getTenCSYTValue());

        // Where
        update.where(builder.equal(root.get(taiKhoanCong.getCSYTId()), taiKhoanCong.getCSYTIdValue()));

        Query q = entityManager.createQuery(update);

        return q.executeUpdate();
    }


}
