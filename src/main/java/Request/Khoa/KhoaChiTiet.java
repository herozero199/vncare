package Request.Khoa;

import Request.Request;

public class KhoaChiTiet extends Request {

    public Long OrgId;
    public String OrgCode;
    public String MaKhoaByt;
    public String OrgName;
    public Integer OrgType;
    public String Note;
    public Long ChuyenKhoaId;

    public KhoaChiTiet(Long orgId, String orgCode, String maKhoaByt, String orgName, Integer orgType, String note, Long chuyenKhoaId) {
        OrgId = orgId;
        OrgCode = orgCode;
        MaKhoaByt = maKhoaByt;
        OrgName = orgName;
        OrgType = orgType;
        Note = note;
        ChuyenKhoaId = chuyenKhoaId;
    }

    public KhoaChiTiet() {}

//    public Long getOrgId() {
//        return OrgId;
//    }
//
//    public void setOrgId(Long orgId) {
//        OrgId = orgId;
//    }
//
//    public String getOrgCode() {
//        return OrgCode;
//    }
//
//    public void setOrgCode(String orgCode) {
//        OrgCode = orgCode;
//    }
//
//    public String getMaKhoaByt() {
//        return MaKhoaByt;
//    }
//
//    public void setMaKhoaByt(String maKhoaByt) {
//        MaKhoaByt = maKhoaByt;
//    }
//
//    public String getOrgName() {
//        return OrgName;
//    }
//
//    public void setOrgName(String orgName) {
//        OrgName = orgName;
//    }
//
//    public Integer getOrgType() {
//        return OrgType;
//    }
//
//    public void setOrgType(Integer orgType) {
//        OrgType = orgType;
//    }
//
//    public String getNote() {
//        return Note;
//    }
//
//    public void setNote(String note) {
//        Note = note;
//    }
//
//    public Long getChuyenKhoaId() {
//        return ChuyenKhoaId;
//    }
//
//    public void setChuyenKhoaId(Long chuyenKhoaId) {
//        ChuyenKhoaId = chuyenKhoaId;
//    }
}
