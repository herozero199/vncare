package request;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


public class KhoaDanhSach extends PanacheEntityBase {
    
    private Long id;
    private String ma_khoa;
    private String ten_khoa;
    private int trang_thai;

    public KhoaDanhSach(Long id, String ma_khoa, String ten_khoa, int trang_thai) {
        this.id = id;
        this.ma_khoa = ma_khoa;
        this.ten_khoa = ten_khoa;
        this.trang_thai = trang_thai;
    }

    public String getMa_khoa() {
        return ma_khoa;
    }

    public void setMa_khoa(String ma_khoa) {
        this.ma_khoa = ma_khoa;
    }

    public String getTen_khoa() {
        return ten_khoa;
    }

    public void setTen_khoa(String ten_khoa) {
        this.ten_khoa = ten_khoa;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

}
