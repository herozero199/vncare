package base_service;

import DAO.org_officer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import repository.NhanVienRepository;
import request.NhanVienChiTiet;
import request.NhanVienDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class NhanVienBaseService {

    @Inject
    NhanVienRepository nhanVienRepository;

    public List<NhanVienDanhSach> getDanhSach(List<SearchCriteria> searchCriteriaList) {
        return nhanVienRepository.getDanhSach(searchCriteriaList);
    }

    public NhanVienChiTiet getChiTiet(SearchCriteria officer_id) {
        return nhanVienRepository.getChiTiet(officer_id);
    }

    public void them(org_officer nhanvien) {
        nhanVienRepository.them(nhanvien);
    }

    public int xoa(SearchCriteria officer_id) {
        return nhanVienRepository.xoa(officer_id);
    }
}
