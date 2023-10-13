package BaseService;

import DAO.OrgOfficer;
import Repository.KhoaRepository;
import Repository.NhanVienRepository;
import Request.NhanVien.NhanVienDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class NhanVienBaseService {

    @Inject
    NhanVienRepository nhanVienRepository;

    public List<NhanVienDanhSach> GetDanhSach (Integer trang, Integer sodong, String search, String order) throws RuntimeException, IllegalAccessException {
        return nhanVienRepository.GetDanhSachNhanVien(trang, sodong, search, order);
    }

    public OrgOfficer GetChiTiet (long OrgId) throws RuntimeException, IllegalAccessException {
        return nhanVienRepository.GetChiTiet(OrgId);
    }

    public void Them (OrgOfficer NhanVien) throws IllegalAccessException {
        nhanVienRepository.Them(NhanVien);
    }

    public int XoaThongTinNhanVien (long OfficerId) throws IllegalAccessException {
        return nhanVienRepository.XoaThongTinNhanVien(OfficerId);
    }

    public int CapNhatStatus (long org_id) throws IllegalAccessException {
        return nhanVienRepository.CapNhatStatus(org_id);
    }
}
