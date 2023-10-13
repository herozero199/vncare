package BaseService;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Repository.KhoaRepository;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;

import java.util.List;

@ApplicationScoped
public class KhoaBaseService {

    @Inject
    KhoaRepository khoaRepository;

    public List<KhoaDanhSach> GetDanhSach (Integer trang, Integer sodong, String search, String order) throws RuntimeException, IllegalAccessException {
        return khoaRepository.GetDanhSachKhoa(trang, sodong, search, order);
    }

    public KhoaChiTiet GetChiTiet (long OrgId) throws RuntimeException, IllegalAccessException {
        return khoaRepository.GetChiTiet(OrgId);
    }

    public void Them (OrgOrganization org, DmcThongTinKhoaPhong dmc) throws IllegalAccessException {
        khoaRepository.Them(org, dmc);
    }

    public int XoaThongTinKhoa (long OrgId) {
        return khoaRepository.XoaThongTinKhoa(OrgId);
    }

    public int CapNhatStatus (long org_id) throws IllegalAccessException {
        return khoaRepository.CapNhatStatus(org_id);
    }
}
