package BaseService;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Repository.PhongRepository;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongDanhSach;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PhongBaseService {

    @Inject
    PhongRepository phongRepository;

    public List<PhongDanhSach> GetDanhSach (Integer trang, Integer sodong, String search, String order) throws RuntimeException, IllegalAccessException {
        return phongRepository.GetDanhSachPhong(trang, sodong, search, order);
    }

    public PhongChiTiet GetChiTiet (long OrgId) throws RuntimeException, IllegalAccessException {
        return phongRepository.GetChiTiet(OrgId);
    }

    public void Them (OrgOrganization org, DmcThongTinKhoaPhong dmc) throws IllegalAccessException {
        phongRepository.Them(org, dmc);
    }

//    public int XoaThongTinPhong (long OrgId) throws IllegalAccessException {
//        return phongRepository.XoaThongTinPhong(OrgId);
//    }

    public int CapNhatStatus (long org_id) throws IllegalAccessException {
        return phongRepository.CapNhatStatus(org_id);
    }
}
