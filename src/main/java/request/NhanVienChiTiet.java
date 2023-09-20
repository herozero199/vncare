package request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import javax.sql.rowset.serial.SerialClob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;

public class NhanVienChiTiet extends  Request{

    Long officer_id;
    Long company_id;

    @NotNull(message = "dept_id cannot be left blank")
    Long dept_id;
    Long subdept_id;
    Long officer_type;

    @NotNull(message = "officer_code cannot be left blank")
    String officer_code;

    @NotNull(message = "officer_name cannot be left blank")
    String officer_name;
    String email;
    String note;
    String chucdanh;
    String ma_bac_si;
    String hoc_ham;
    String hoc_vi;
    String trinhdo;
    String phone;
    Integer otp;
    String diachir;

    @Pattern(regexp = "DD/MM/YYYY", message = "ngaysinh must be in format DD/MM/YYYY")
    Date ngaysinh;
    Integer gioitinh;
    Clob chu_ky_anh;
    String so_bhyt;
    String so_bhxh;
    Integer truongkhoa;

    public NhanVienChiTiet(Long officer_id, Long company_id, Long dept_id, Long subdept_id, Long officer_type, String officer_code, String officer_name, String email, String note, String chucdanh, String ma_bac_si, String hoc_ham, String hoc_vi, String trinhdo, String phone, Integer otp, String diachi, Date ngaysinh, Integer gioitinh, Clob chu_ky_anh, String so_bhyt, String so_bhxh, Integer truongkhoa) throws SQLException {
        this.officer_id = officer_id;
        this.company_id = company_id;
        this.dept_id = dept_id;
        this.subdept_id = subdept_id;
        this.officer_type = officer_type;
        this.officer_code = officer_code;
        this.officer_name = officer_name;
        this.email = email;
        this.note = note;
        this.chucdanh = chucdanh;
        this.ma_bac_si = ma_bac_si;
        this.hoc_ham = hoc_ham;
        this.hoc_vi = hoc_vi;
        this.trinhdo = trinhdo;
        this.phone = phone;
        this.otp = otp;
        this.diachir = diachi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chu_ky_anh = chu_ky_anh;
        this.so_bhyt = so_bhyt;
        this.so_bhxh = so_bhxh;
        this.truongkhoa = truongkhoa;
    }

    public Long getOfficer_id() {
        return officer_id;
    }

    public void setOfficer_id(Long officer_id) {
        this.officer_id = officer_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public Long getSubdept_id() {
        return subdept_id;
    }

    public void setSubdept_id(Long supdept_id) {
        this.subdept_id = supdept_id;
    }

    public Long getOfficer_type() {
        return officer_type;
    }

    public void setOfficer_type(Long officer_type) {
        this.officer_type = officer_type;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getDiachir() {
        return diachir;
    }

    public void setDiachir(String diachir) {
        this.diachir = diachir;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Clob getChu_ky_anh() {
        return chu_ky_anh;
    }

    public void setChu_ky_anh(Clob chu_ky_anh) {
        this.chu_ky_anh = chu_ky_anh;
    }

    public String getSo_bhyt() {
        return so_bhyt;
    }

    public void setSo_bhyt(String so_bhyt) {
        this.so_bhyt = so_bhyt;
    }

    public String getSo_bhxh() {
        return so_bhxh;
    }

    public void setSo_bhxh(String so_bhxh) {
        this.so_bhxh = so_bhxh;
    }

    public Integer getTruongkhoa() {
        return truongkhoa;
    }

    public void setTruongkhoa(Integer truongkhoa) {
        this.truongkhoa = truongkhoa;
    }
}
