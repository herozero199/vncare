package Repository;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class KhoaRepository extends Repositories {

    @Transactional
    public void themKhoa(OrgOrganization orgOrganization, DmcThongTinKhoaPhong dmcThongTinKhoaPhong) {
        orgOrganization.provinceId = 1;
        orgOrganization.status = 1;
        orgOrganization.orgLevel = "4";
        orgOrganization.persistAndFlush();

        dmcThongTinKhoaPhong.khoaId = orgOrganization.orgId;
        dmcThongTinKhoaPhong.phongId = 0L;
        dmcThongTinKhoaPhong.persistAndFlush();
    }

    @Transactional
    public int capNhatTrangThai(String query, Long orgId) {

        query = query.replace("?id", String.valueOf(orgId));
        return entityManager.createQuery(query).executeUpdate();
    }
}
