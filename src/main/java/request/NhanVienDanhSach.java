package request;

public class NhanVienDanhSach extends  Request {

    Long officer_id;
    String ten_khoa;
    Long dept_id;
    String loai_nhan_vien;
    String officer_code;
    String officer_name;
    String ten_phong;
    Long supdept_id;
    String chucdanh;
    String ma_bac_si;
    String hoc_ham;
    String hoc_vi;
    String trinhdo;

    public NhanVienDanhSach(Long officer_id, String ten_khoa, Long dept_id, String loai_nhan_vien, String officer_code, String officer_name, String ten_phong,
                            Long supdept_id, String chucdanh, String ma_bac_si, String hoc_ham, String hoc_vi, String trinhdo) {
        this.officer_id = officer_id;
        this.ten_khoa = ten_khoa;
        this.dept_id = dept_id;
        this.loai_nhan_vien = loai_nhan_vien;
        this.officer_code = officer_code;
        this.officer_name = officer_name;
        this.ten_phong = ten_phong;
        this.supdept_id = supdept_id;
        this.chucdanh = chucdanh;
        this.ma_bac_si = ma_bac_si;
        this.hoc_ham = hoc_ham;
        this.hoc_vi = hoc_vi;
        this.trinhdo = trinhdo;
    }

    public Long getOfficer_id() {
        return officer_id;
    }

    public void setOfficer_id(Long officer_id) {
        this.officer_id = officer_id;
    }

    public String getTen_khoa() {
        return ten_khoa;
    }

    public void setTen_khoa(String ten_khoa) {
        this.ten_khoa = ten_khoa;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getLoai_nhan_vien() {
        return loai_nhan_vien;
    }

    public void setLoai_nhan_vien(String loai_nhan_vien) {
        this.loai_nhan_vien = loai_nhan_vien;
    }

    public String getOfficer_code() {
        return officer_code;
    }

    public void setOfficer_code(String officer_code) {
        this.officer_code = officer_code;
    }

    public String getOfficer_name() {
        return officer_name;
    }

    public void setOfficer_name(String officer_name) {
        this.officer_name = officer_name;
    }

    public String getTen_phong() {
        return ten_phong;
    }

    public void setTen_phong(String ten_phong) {
        this.ten_phong = ten_phong;
    }

    public Long getSupdept_id() {
        return supdept_id;
    }

    public void setSupdept_id(Long supdept_id) {
        this.supdept_id = supdept_id;
    }

    public String getChucdanh() {
        return chucdanh;
    }

    public void setChucdanh(String chucdanh) {
        this.chucdanh = chucdanh;
    }

    public String getMa_bac_si() {
        return ma_bac_si;
    }

    public void setMa_bac_si(String ma_bac_si) {
        this.ma_bac_si = ma_bac_si;
    }

    public String getHoc_ham() {
        return hoc_ham;
    }

    public void setHoc_ham(String hoc_ham) {
        this.hoc_ham = hoc_ham;
    }

    public String getHoc_vi() {
        return hoc_vi;
    }

    public void setHoc_vi(String hoc_vi) {
        this.hoc_vi = hoc_vi;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
