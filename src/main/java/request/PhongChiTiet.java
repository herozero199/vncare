package request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PhongChiTiet extends Request {

    Long org_id;

    Long parent_id;

    @Size(max=100, message = "org_code's max length is 100 characters")
    @NotNull(message = "org_code cannot be left blank")
    String org_code;

    @Size(max=200, message = "so_phong's max length is 200 characters")
    @NotNull(message = "so_phong cannot be left blank")
    String so_phong;

    @Size(max=30, message = "org_name's max length is 30 characters")
    @NotNull(message = "org_name cannot be left blank")
    String org_name;


    String tenphong_chuyenkhoa;

    @Max(value=99999, message = "org_type's max digits is 5 digits")
    @NotNull(message = "org_type cannot be left blank")
    Integer org_type;

    Integer loaibenhanid;

    String note;

    @Max(value=999999, message = "stt_phongkham's max digit is 6 digits")
    Integer stt_phongkham;

    @Size(max=30, message = "sophong_manhinh's max length is 30 characters")
    String sophong_manhinh;

    @Size(max=200, message = "chuyenkhoaphongkham's max length is 200 chracters")
    String chuyenkhoaphongkham;

    @Size(max=40, message = "org_address's max length is 40 characters")
    String org_address;

    Integer phonggiaosu;

    Integer tuvantuxa;

    Integer khamcsyt;

    Integer status;

    public PhongChiTiet(Long org_id, Long parent_id, String org_code, String so_phong, String org_name, String tenphong_chuyenkhoa, Integer org_type,
                        Integer loaibenhanid, String note, Integer stt_phongkham, String sophong_manhinh, String chuyenkhoaphongkham, String org_address,
                        Integer phonggiaosu, Integer tuvantuxa, Integer khamcsyt, Integer status) {
        this.org_id = org_id;
        this.parent_id = parent_id;
        this.org_code = org_code;
        this.so_phong = so_phong;
        this.org_name = org_name;
        this.tenphong_chuyenkhoa = tenphong_chuyenkhoa;
        this.org_type = org_type;
        this.loaibenhanid = loaibenhanid;
        this.note = note;
        this.stt_phongkham = stt_phongkham;
        this.sophong_manhinh = sophong_manhinh;
        this.chuyenkhoaphongkham = chuyenkhoaphongkham;
        this.org_address = org_address;
        this.phonggiaosu = phonggiaosu;
        this.tuvantuxa = tuvantuxa;
        this.khamcsyt = khamcsyt;
        this.status = status;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getSo_phong() {
        return so_phong;
    }

    public void setSo_phong(String so_phong) {
        this.so_phong = so_phong;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getTenphong_chuyenkhoa() {
        return tenphong_chuyenkhoa;
    }

    public void setTenphong_chuyenkhoa(String tenphong_chuyenkhoa) {
        this.tenphong_chuyenkhoa = tenphong_chuyenkhoa;
    }

    public Integer getOrg_type() {
        return org_type;
    }

    public void setOrg_type(Integer org_type) {
        this.org_type = org_type;
    }

    public Integer getLoaibenhanid() {
        return loaibenhanid;
    }

    public void setLoaibenhanid(Integer loaibenhanid) {
        this.loaibenhanid = loaibenhanid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStt_phongkham() {
        return stt_phongkham;
    }

    public void setStt_phongkham(Integer stt_phongkham) {
        this.stt_phongkham = stt_phongkham;
    }

    public String getSophong_manhinh() {
        return sophong_manhinh;
    }

    public void setSophong_manhinh(String sophong_manhinh) {
        this.sophong_manhinh = sophong_manhinh;
    }

    public String getChuyenkhoaphongkham() {
        return chuyenkhoaphongkham;
    }

    public void setChuyenkhoaphongkham(String chuyenkhoaphongkham) {
        this.chuyenkhoaphongkham = chuyenkhoaphongkham;
    }

    public String getOrg_address() {
        return org_address;
    }

    public void setOrg_address(String org_address) {
        this.org_address = org_address;
    }

    public Integer getPhonggiaosu() {
        return phonggiaosu;
    }

    public void setPhonggiaosu(Integer phonggiaosu) {
        this.phonggiaosu = phonggiaosu;
    }

    public Integer getTuvantuxa() {
        return tuvantuxa;
    }

    public void setTuvantuxa(Integer tuvantuxa) {
        this.tuvantuxa = tuvantuxa;
    }

    public Integer getKhamcsyt() {
        return khamcsyt;
    }

    public void setKhamcsyt(Integer khamcsyt) {
        this.khamcsyt = khamcsyt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
