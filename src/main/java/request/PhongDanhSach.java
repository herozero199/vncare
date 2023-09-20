package request;

import service.PhongService;

public class PhongDanhSach extends Request{

    Long org_id;

    String org_code;

    String org_name;

    String tenkhoa;

    Integer status;

    Long parent_id;

    public PhongDanhSach() {}
    public PhongDanhSach(Long org_id, Long parent_id, String org_code, String org_name, Integer status) {
        this.org_id = org_id;
        this.parent_id = parent_id;
        this.org_code = org_code;
        this.org_name = org_name;
        this.status = status;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}
