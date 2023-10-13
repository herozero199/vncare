package DAO;

import jakarta.persistence.*;

import java.sql.Clob;
import java.sql.Date;

@Entity
@Table(name = "ORG_OFFICER", schema = "QLHK_COMMON")
public class OrgOfficer extends DAO{

    @Id
    @Column(name = "OFFICER_ID")
    Long OfficerId;
    @Column(name = "OFFICER_TYPE")
    Long OfficerType;
    @Column(name = "DEPT_ID")
    Long DeptId;
    @Column(name = "SUBDEPT_ID")
    Long SubDeptId;
    @Column(name = "COMPANY_ID")
    Long CompanyId;
    @Column(name = "STATUS")
    Integer Status;
    @Column(name = "OFFICER_CODE")
    String OfficerCode;
    @Column(name = "OFFICER_NAME")
    String OfficerName;
    @Column(name = "CHUCDANH")
    String ChucDanh;
    @Column(name = "MA_BAC_SI")
    String MaBacSi;
    @Column(name = "HOC_HAM")
    String HocHam;
    @Column(name = "HOC_VI")
    String HocVi;
    @Column(name = "TRINHDO")
    String TrinhDo;
    @Column(name = "EMAIL")
    String Email;
    @Column(name = "NOTE")
    String Note;
    @Column(name = "PHONE")
    String Phone;
    @Column(name = "OTP")
    Integer OTP;
    @Column(name = "DIACHI")
    String DiaChi;
    @Column(name = "NGAYSINH")
    Date NgaySinh;
    @Column(name = "GIOITINH")
    Integer GioiTinh;
    @Lob
    @Column(name = "CHU_KY_ANH")
    Clob ChuKyAnh;
    @Column(name = "SO_BHYT")
    String SoBHYT;
    @Column(name = "SO_BHXH")
    String SoBHXH;
    @Column(name = "TRUONGKHOA")
    Integer TruongKhoa;

    @OneToOne
    @JoinColumn(name="Officer_Type", referencedColumnName = "Id", insertable=false, updatable=false)
    OrgOfficerType LoaiNhanVien;

    @OneToOne
    @JoinColumn(name="Dept_Id", referencedColumnName = "Org_Id", insertable=false, updatable=false)
    OrgOrganization Khoa;

    @OneToOne
    @JoinColumn(name="Subdept_id", referencedColumnName = "Org_Id", insertable=false, updatable=false)
    OrgOrganization Phong;

    public String GetNhanVienId() {return "OfficerId";}
    public void SetNhanVienId(Long Id) {this.OfficerId = Id;}

    public String GetLoaiNhanVienId() {return "OfficerType";}
    public void SetLoaiNhanVienId(Long Loai) {this.OfficerType = Loai;}

    public String GetMaKhoa() {return "DeptId";}
    public void SetMaKhoa(Long Id) {this.DeptId = Id;}

    public String GetMaPhong() {return "SubdeptId";}
    public void SetMaPhong(Long Id) {this.SubDeptId = Id;}

    public String GetMaCongTy() {return "CompanyId";}
    public void SetMaCongTy(Long Id) {this.CompanyId = Id;}

    public String GetTrangThai() {return "Status";}
    public void SetTrangThai(Integer trangthai) {this.Status = trangthai;}

    public String GetMaNhanVien() {return "OfficerCode";}
    public void SetMaNhanVien(String Ma) {this.OfficerCode = Ma;}

    public String GetTenNhanVien() {return "OfficerName";}
    public void SetTenNhanVien(String Ten) {this.OfficerName = Ten;}

    public String GetChucDanh() {return "ChucDanh";}
    public void SetChucDanh(String chucDanh) {this.ChucDanh = chucDanh;}

    public String GetMaBacSi() {return "MaBacSi";}
    public void SetMaBacSi(String Ma) {this.MaBacSi = Ma;}

    public String GetHocHam() {return "HocHam";}
    public void SetHocHam(String hocHam) {this.HocHam = hocHam;}

    public String GetTrinhDo() {return "TrinhDo";}
    public void SetTrinhDo(String trinhDo) {this.TrinhDo = trinhDo;}

    public String GetEmail() {return "Email";}
    public void SetEmail(String email) {this.Email = email;}

    public String GetGhiChu() {return "Note";}
    public void SetGhiChu(String ghichu) {this.Note = ghichu;}

    public String GetPhone() {return "Phone";}
    public void SetPhone(String phone) {this.Phone = phone;}

    public String GetOTP() {return "OTP";}
    public void SetOTP(Integer OTP) {this.OTP = OTP;}

    public String GetDiaChi() {return "DiaChi";}
    public void SetDiaChi(String DiaChi) {this.DiaChi = DiaChi;}

    public String GetNgaySinh() {return "NgaySinh";}
    public void SetNgaySinh(Date ngaysinh) {this.NgaySinh = ngaysinh;}

    public String GetGioiTinh() {return "GioiTinh";}
    public void SetGioiTinh(Integer gioitinh) {this.GioiTinh = gioitinh;}

    public String GetChuKyAnh() {return "ChuKyAnh";}
    public void SetChuKyAnh(Clob chuKyAnh) {this.ChuKyAnh = chuKyAnh;}

    public String GetSoBHYT() {return "SoBHYT";}
    public void SetSoBHYT(String soBHYT) {this.SoBHYT = soBHYT;}

    public String GetSoBHXH() {return "SoBHXH";}
    public void SetSoBHXH(String soBHXH) {this.SoBHXH = soBHXH;}

    public String GetTruongKhoa() {return "TruongKhoa";}
    public void SetTruongKhoa(Integer truongKhoa) {this.TruongKhoa = truongKhoa;}

    public String GetLoaiNhanVien() {return "LoaiNhanVien";}

    public String GetKhoa() {return "Khoa";}
    public String GetPhong() {return "Phong";}
}
