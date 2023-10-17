package Request.Khoa;

import Request.Request;

import java.util.List;

public class KhoaChiTiet extends Request {

    public Long khoaId;
    public String maKhoa;
    public String maKhoaByt;
    public String tenKhoa;
    public Integer loaiKhoa;
    public String ghiChu;
    public Long chuyenKhoaId;

    public KhoaChiTiet(List<Object> select) {
        this.khoaId = (Long) select.get(0);
        this.maKhoa = (String) select.get(1);
        this.maKhoaByt = (String) select.get(2);
        this.tenKhoa = (String) select.get(3);
        this.loaiKhoa = (Integer) select.get(4);
        this.ghiChu = (String) select.get(5);
        this.chuyenKhoaId = (Long) select.get(6);
    }

    public KhoaChiTiet() {}

}
