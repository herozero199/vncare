package BaseService;

import DAO.DichVuKham;
import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Repository.DichVuKhamRepository;
import Repository.KhoaRepository;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class DichVuKhamBaseService {

    @Inject
    DichVuKhamRepository dichVuKhamRepository;

    public List<DichVuKham> GetDanhSach (Integer trang, Integer sodong, String search, String order) throws RuntimeException, IllegalAccessException {
        return dichVuKhamRepository.GetDanhSachDichVu(trang, sodong, search, order);
    }

    public DichVuKham GetChiTiet (long DichVuId) throws RuntimeException, IllegalAccessException {
        return dichVuKhamRepository.GetChiTiet(DichVuId);
    }

    public void Them (DichVuKham dichVuKham) throws IllegalAccessException {
        dichVuKhamRepository.Them(dichVuKham);
    }

//    public int XoaThongTinDichVu (long DichVuId) {
//        return dichVuKhamRepository.XoaThongTinKhoa(DichVuId);
//    }

    public int CapNhatStatus (DichVuKham dichVuKham) throws IllegalAccessException {
        return dichVuKhamRepository.CapNhatStatus(dichVuKham);
    }
}
