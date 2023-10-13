package Request.NhanVien;

import DAO.OrgOfficer;
import Request.Request;

public class NhanVienDanhSach extends Request {

    public Long OfficerId;
    public String TenKhoa;
    public Long MaKhoa;
    public String OrfficerType;
    public String OfficerCode;
    public String OfficerName;
    public String TenPhong;
    public Long MaPhong;
    public String ChucDanh;
    public String MaBacSi;
    public String HocHam;
    public String HocVi;

    public NhanVienDanhSach(Long officerId, String tenKhoa, Long maKhoa, String orfficerType, String officerCode, String officerName,
                            String tenPhong, Long maPhong, String chucDanh, String maBacSi, String hocHam, String hocVi) {
        OfficerId = officerId;
        TenKhoa = tenKhoa;
        MaKhoa = maKhoa;
        OrfficerType = orfficerType;
        OfficerCode = officerCode;
        OfficerName = officerName;
        TenPhong = tenPhong;
        MaPhong = maPhong;
        ChucDanh = chucDanh;
        MaBacSi = maBacSi;
        HocHam = hocHam;
        HocVi = hocVi;
    }

    public NhanVienDanhSach() {}
}
