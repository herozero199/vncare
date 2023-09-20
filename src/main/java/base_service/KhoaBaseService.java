package base_service;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import repository.KhoaRepository;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class KhoaBaseService {

    @Inject
    KhoaRepository khoaRepository;

    public List<KhoaDanhSach> getDanhSach (List<SearchCriteria> searchCriteriaList) throws RuntimeException{
        return khoaRepository.getDanhSachKhoa(searchCriteriaList);
    }

    public KhoaChiTiet getChiTiet (SearchCriteria org_id) throws RuntimeException {
        return khoaRepository.getChiTiet(org_id);
    }

    public void them (org_organization org, dmc_thongtinkhoaphong dmc) {
        khoaRepository.them(org, dmc);
    }

    public int xoaThongTinKhoa (SearchCriteria org_id) {
        return khoaRepository.xoaThongTinKhoa(org_id);
    }

    public int capnhatStatus (SearchCriteria org_id) {
        return khoaRepository.capnhatStatus(org_id);
    }
}
