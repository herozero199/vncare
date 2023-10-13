package Request.Phong;

import Request.Request;

public class PhongDanhSach extends Request {

    Long OrgId;
    Long ParentId;
    String OrgCode;
    String TenKhoa;
    String TenPhong;

    public PhongDanhSach(Long orgId, Long parentId, String orgCode, String tenKhoa, String tenPhong) {
        OrgId = orgId;
        ParentId = parentId;
        OrgCode = orgCode;
        TenKhoa = tenKhoa;
        TenPhong = tenPhong;
    }

    public PhongDanhSach() {
    }

    public Long getOrgId() {
        return OrgId;
    }

    public void setOrgId(Long orgId) {
        OrgId = orgId;
    }

    public Long getParentId() {
        return ParentId;
    }

    public void setParentId(Long parentId) {
        ParentId = parentId;
    }

    public String getOrgCode() {
        return OrgCode;
    }

    public void setOrgCode(String orgCode) {
        OrgCode = orgCode;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }
}
