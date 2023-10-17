package Request.Khoa;

import Request.Request;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class KhoaDanhSach extends Request {

    public Long khoaId;
    public String maKhoa;
    public String tenKhoa;
    public int trangThai;

    public KhoaDanhSach(List<Object> select) {
        this.khoaId = (Long) select.get(0);
        this.maKhoa = (String) select.get(1);
        this.tenKhoa = (String) select.get(2);
        this.trangThai = (Integer) select.get(3);
    }

    public KhoaDanhSach() {}

}






