package request;

import java.sql.Date;

public class NgayNghiChiTiet extends Request {

    Long ngaynghiid;

    Integer loai;

    Integer thu;

    Date tungay;

    Date denngay;

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

    public Integer getLoai() {
        return loai;
    }

    public void setLoai(Integer loai) {
        this.loai = loai;
    }

    public Integer getThu() {
        return thu;
    }

    public void setThu(Integer thu) {
        this.thu = thu;
    }

    public Date getTungay() {
        return tungay;
    }

    public void setTungay(Date tungay) {
        this.tungay = tungay;
    }

    public Date getDenngay() {
        return denngay;
    }

    public void setDenngay(Date denngay) {
        this.denngay = denngay;
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
