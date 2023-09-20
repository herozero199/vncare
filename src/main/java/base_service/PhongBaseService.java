package base_service;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.KhoaRepository;
import repository.PhongRepository;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import request.PhongChiTiet;
import request.PhongDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class PhongBaseService {

    @Inject
    PhongRepository phongRepository;

    public List<PhongDanhSach> getDanhSach (List<SearchCriteria> searchCriteriaList) throws RuntimeException{
        return phongRepository.getDanhSachPhong(searchCriteriaList);
    }

    public PhongChiTiet getChiTiet (SearchCriteria org_id) throws RuntimeException {
        return phongRepository.getChiTiet(org_id);
    }

    public void them (org_organization org, dmc_thongtinkhoaphong dmc) {
        phongRepository.them(org, dmc);
    }

    public int xoaThongTinPhong (SearchCriteria org_id) {
        return phongRepository.xoaThongTinPhong(org_id);
    }

    public int capnhatStatus (SearchCriteria org_id) {
        return phongRepository.capnhatStatus(org_id);
    }

}
