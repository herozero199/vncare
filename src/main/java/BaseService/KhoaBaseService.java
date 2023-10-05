package BaseService;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Repository.KhoaRepository;
import Request.KhoaChiTiet;
import Request.KhoaDanhSach;

import java.util.List;

@ApplicationScoped
public class KhoaBaseService {

    @Inject
    KhoaRepository khoaRepository;

    public List<KhoaDanhSach> getDanhSach (Integer trang, Integer sodong, String search, String order) throws RuntimeException{
        return khoaRepository.getDanhSachKhoa(trang, sodong, search, order);
    }

//    public KhoaChiTiet getChiTiet (SearchCriteria org_id) throws RuntimeException {
//        return khoaRepository.getChiTiet(org_id);
//    }
//
//    public void them (org_organization org, dmc_thongtinkhoaphong dmc) {
//        khoaRepository.them(org, dmc);
//    }
//
//    public int xoaThongTinKhoa (SearchCriteria org_id) {
//        return khoaRepository.xoaThongTinKhoa(org_id);
//    }
//
//    public int capnhatStatus (SearchCriteria org_id) {
//        return khoaRepository.capnhatStatus(org_id);
//    }
}
