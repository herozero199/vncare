package request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class KhoaChiTiet extends Request {

    Long org_id;

    @Size(max=100, message = "org_code's max length is 100 characters")
    @NotNull(message = "org_code cannot be left blank")
    String org_code;

    @Size(max=300, message = "org_name's max length is 300 characters")
    @NotNull(message = "org_name cannot be left blank")
    String org_name;

    Integer status;
    Integer org_type;
    Long chuyenkhoaid;

    @Size(max=20)
    @NotNull(message = "makhoabyt cannot be left blank")
    String makhoabyt;
    String note;


    public KhoaChiTiet() {}
    public KhoaChiTiet(Long org_id, String org_code, String org_name, Integer org_type, String note, Integer status, String makhoabyt, Long chuyenkhoaid) {
        this.org_id = org_id;
        this.org_code = org_code;
        this.org_name = org_name;
        this.status = status;
        this.org_type = org_type;
        this.chuyenkhoaid = chuyenkhoaid;
        this.makhoabyt = makhoabyt;
        this.note = note;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrg_type() {
        return org_type;
    }

    public void setOrg_type(Integer org_type) {
        this.org_type = org_type;
    }

    public Long getChuyenkhoaid() {
        return chuyenkhoaid;
    }

    public void setChuyenkhoaid(Long chuyenkhoaid) {
        this.chuyenkhoaid = chuyenkhoaid;
    }

    public String getMakhoabyt() {
        return makhoabyt;
    }

    public void setMakhoabyt(String makhoabyt) {
        this.makhoabyt = makhoabyt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "KhoaChiTiet{" +
                "org_code='" + org_code + '\'' +
                ", org_name='" + org_name + '\'' +
                ", status=" + status +
                ", org_type=" + org_type +
                ", chuyenkhoaid=" + chuyenkhoaid +
                ", makhoabyt='" + makhoabyt + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
