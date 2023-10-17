package Request.Khoa;

import Request.Request;
import jakarta.validation.constraints.NotNull;

public class KhoaThem extends Request {

    public Long orgId;
    public Long parentId;
    public String orgLevel;
    @NotNull
    public String orgCode;
    public String dbSchema;
    public Integer provinceId;
    public Integer status;
    @NotNull
    public String orgName;
    @NotNull
    public Integer orgType;
    public String note;
    public Long khoaId;
    public Long phongId;
    public Integer csytId;
    public Integer hangBhTraiTuyenId;
    public String maKhoaByt;
    public Integer loaiBenhNhanId;
    public Long chuyenKhoaId;

}
