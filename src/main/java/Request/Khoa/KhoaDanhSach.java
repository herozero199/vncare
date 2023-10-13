package Request.Khoa;

import Request.Request;

public class KhoaDanhSach extends Request {

    private Long OrgId;
    private String OrgCode;
    private String OrgName;
    private int Status;

    public KhoaDanhSach(Long OrgId, String OrgCode, String OrgName, int Status) {
        this.OrgId = OrgId;
        this.OrgCode = OrgCode;
        this.OrgName = OrgName;
        this.Status = Status;
    }

    public KhoaDanhSach() {}

    public Long getOrgId() {
        return OrgId;
    }

    public void setOrgId(Long orgId) {
        OrgId = orgId;
    }

    public String getOrgCode() {
        return OrgCode;
    }

    public void setOrgCode(String orgCode) {
        OrgCode = orgCode;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}






