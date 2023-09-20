package repository;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_officer;
import DAO.org_officer_type;
import DAO.org_organization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Timeout;
import predicate.ChiTiet;
import predicate.DanhSach;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import request.NhanVienChiTiet;
import request.NhanVienDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class NhanVienRepository extends  Repo{

    public List<NhanVienDanhSach> getDanhSach(List<SearchCriteria> searchCriteriaList) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<NhanVienDanhSach> query = builder.createQuery(NhanVienDanhSach.class);
        Root<org_officer> root = query.from(org_officer.class);

        Join<org_officer, org_officer_type> joinLoaiNhanVien = root.join("loaiNhanVien", JoinType.LEFT);
        joinLoaiNhanVien.on(builder.equal(root.get("officer_type"), joinLoaiNhanVien.get("id")));

        Join<org_officer, org_organization> joinKhoa = root.join("khoa", JoinType.LEFT);
        joinKhoa.on(builder.equal(root.get("dept_id"), joinKhoa.get("org_id")));

        Join<org_officer, org_organization> joinPhong = root.join("phong", JoinType.LEFT);
        joinPhong.on(builder.equal(root.get("subdept_id"), joinPhong.get("org_id")));

        Predicate predicate = new DanhSach(builder, builder.conjunction()).getPredicateNhanVien(searchCriteriaList, root);

        query.multiselect(root.get("officer_id"), joinKhoa.get("org_name"), root.get("dept_id"), joinLoaiNhanVien.get("name"), root.get("officer_code"),
                          root.get("officer_name"), joinPhong.get("org_name"), root.get("subdept_id"), root.get("chucdanh"), root.get("ma_bac_si"), root.get("hoc_ham"),
                          root.get("hoc_vi"), root.get("trinhdo"));
        query.where(predicate);
        query.orderBy(builder.asc(root.get("officer_name")), builder.asc(root.get("officer_code")));

        Query q = super.entityManager.createQuery(query);
        int page = (int) searchCriteriaList.get(0).value;
        int pageSize = (int) searchCriteriaList.get(1).value;
        q.setFirstResult(page * pageSize);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public NhanVienChiTiet getChiTiet (SearchCriteria officer_id) {

        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<NhanVienChiTiet> query = builder.createQuery(NhanVienChiTiet.class);
        Root<org_officer> root = query.from(org_officer.class);

        Predicate predicate = new ChiTiet(builder, builder.conjunction()).getPredicateNhanVien(root, officer_id);

        query.multiselect(root.get("officer_id"), root.get("company_id"), root.get("dept_id"), root.get("subdept_id"), root.get("officer_type"), root.get("officer_code"),
                root.get("officer_name"), root.get("email"), root.get("note"), root.get("chucdanh"), root.get("ma_bac_si"), root.get("hoc_ham"), root.get("hoc_vi"),
                root.get("trinhdo"), root.get("phone"), root.get("otp"), root.get("diachi"), root.get("ngaysinh"), root.get("gioitinh"),
                root.get("chu_ky_anh"), root.get("so_bhyt"), root.get("so_bhxh"), root.get("truongkhoa"));
        query.where(predicate);

        Query q = super.entityManager.createQuery(query);
        return (NhanVienChiTiet) q.getSingleResult();
    }

    @Timeout
    @Transactional
    public void them (org_officer nhanvien) {
        nhanvien.persistAndFlush();
    }

    @Timeout
    @Transactional
    public int xoa (SearchCriteria officer_id) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaUpdate<org_officer> update = builder.createCriteriaUpdate(org_officer.class);
        Root<org_officer> root = update.getRoot();

        update.set("status", 0);
        update.where(builder.equal(root.get("officer_id"), officer_id.value));

        Query q = this.entityManager.createQuery(update);
        return q.executeUpdate();
    }
}
