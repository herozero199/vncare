package request;

import java.sql.Date;

public class NgayNghiDanhSach extends Request{

    Long ngaynghiid;

    String loai;

    String loai_text;

    Date tungay;

    Integer thu;

    String ngaynghi;

    Integer nghisang;

    Integer nghichieu;

    Integer nghitvtx;

    Integer nghicsyt;

    public Long getNgaynghiid() {
        return ngaynghiid;
    }

    public void setNgaynghiid(Long ngaynghiid) {
        this.ngaynghiid = ngaynghiid;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getLoai_text() {
        return loai_text;
    }

    public void setLoai_text(String loai_text) {
        this.loai_text = loai_text;
    }

    public Date getTungay() {
        return tungay;
    }

    public void setTungay(Date tungay) {
        this.tungay = tungay;
    }

    public Integer getThu() {
        return thu;
    }

    public void setThu(Integer thu) {
        this.thu = thu;
    }

    public String getNgaynghi() {
        return ngaynghi;
    }

    public void setNgaynghi(String ngaynghi) {
        this.ngaynghi = ngaynghi;
    }

    public Integer getNghisang() {
        return nghisang;
    }

    public void setNghisang(Integer nghisang) {
        this.nghisang = nghisang;
    }

    public Integer getNghichieu() {
        return nghichieu;
    }

    public void setNghichieu(Integer nghichieu) {
        this.nghichieu = nghichieu;
    }

    public Integer getNghitvtx() {
        return nghitvtx;
    }

    public void setNghitvtx(Integer nghitvtx) {
        this.nghitvtx = nghitvtx;
    }

    public Integer getNghicsyt() {
        return nghicsyt;
    }

    public void setNghicsyt(Integer nghicsyt) {
        this.nghicsyt = nghicsyt;
    }
}
