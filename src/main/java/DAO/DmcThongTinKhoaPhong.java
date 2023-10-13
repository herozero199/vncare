package DAO;

import CustomAnnotation.Concept;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="DMC_THONGTINKHOAPHONG", schema = "QLHK_COMMON")
public class DmcThongTinKhoaPhong extends DAO {    
    
    @Id
    @Column(name="PHONGID")
    public Long PhongId;

    @Id
    @Column(name="KHOAID")
    public Long KhoaId;

    @Column(name="MAKHOABYT")
    public String MaKhoaBYT;

    @Column(name="CHUYENKHOAID")
    public Long ChuyenKhoaId;

    @Column(name="SOPHONG")
    public String SoPhong;

    @Column(name="TENPHONG_CHUYENKHOA")
    public String TenPhongChuyenKhoa;

    @Column(name="LOAIBENHANID")
    public Integer LoaiBenhNhanId;

    @Column(name="STT_PHONGKHAM")
    public Integer STTPhongKham;

    @Column(name="SOPHONG_MANHINH")
    public String SoPhongManHinh;

    @Column(name="CHUYENKHOAPHONGKHAM")
    public String ChuyenKhoaPhongKham;

    @Column(name="PHONGGIAOSU")
    public Integer PhongGiaoSu;

    @Column(name="TUVANTUXA")
    public Integer TuVanTuXa;

    @Column(name="KHAMCSYT")
    public Integer KhamCSYT;

    @Column(name="CSYTID")
    public Integer CSYTId;

    @Column(name = "NGAYTRONGTUAN")
    public String NgayTrongTuan;

    @Column(name = "THOIGIANHD_SANG")
    public String ThoiGianHoatDongSang;

    @Column(name = "THOIGIANHD_CHIEU")
    public String ThoiGianHoatDongChieu;

    @Column(name = "HANG_BHTRAITUYEN_ID")
    public String HangBHTraiTuyenId;

    public String GetPhongId() {return "PhongId";}
    public void SetPhongId(Long Id) {this.PhongId = Id;}

    public String GetKhoaId() {return "KhoaId";}
    public void SetKhoaId(Long Id) {this.KhoaId = Id;}

    public String GetMaKhoaBYT() {return "MaKhoaBYT";}
    public void SetMaKhoaBYT(String Ma) {this.MaKhoaBYT = Ma;}

    public String GetChuyenKhoaId() {return "ChuyenKhoaId";}
    public void SetChuyenKhoaId(Long Ma) {this.ChuyenKhoaId = Ma;}

    public String GetSoPhong() {return "SoPhong";}
    public void SetSoPhong(String SoPhong) {this.SoPhong = SoPhong;}

    public String GetTenPhongChuyenKhoa() {return "TenPhongChuyenKhoa";}
    public void SetTenPhongChuyenKhoa(String Ten) {this.TenPhongChuyenKhoa = Ten;}

    public String GetLoaiBenhNhanId() {return "LoaiBenhNhanId";}
    public void SetLoaiBenhNhanId(Integer Id) {this.LoaiBenhNhanId = Id;}

    public String GetSTTPhongKham() {return "STTPhongKham";}
    public void SetSTTPhongKham(Integer STT) {this.STTPhongKham = STT;}

    public String GetChuyenKhoaPhongKham() {return "ChuyenKhoaPhongKham";}
    public void SetChuyenKhoaPhongKham(String ChuyenKhoa) {this.ChuyenKhoaPhongKham = ChuyenKhoa;}

    public String GetPhongGiaoSu() {return "PhongGiaoSu";}
    public void SetPhongGiaoSu(Integer phongGiaoSu) {this.PhongGiaoSu = phongGiaoSu;}

    public String GetTuVanTuXa() {return "TuVanTuXa";}
    public void SetTuVaTuXa(Integer tuVanTuXa) {this.TuVanTuXa = tuVanTuXa;}

    public String GetKhamCSYT() {return "KhamCSYT";}
    public void SetKhamCSYT(Integer KhamCSYT) {this.KhamCSYT = KhamCSYT;}

    public String GetCSYTId() {return "CSYTId";}
    public void SetCSYTId(Integer Id) {this.CSYTId = Id;}

    public String GetNgayTrongTuan() {return "NgayTrongTuan";}
    public void SetNgayTrongTuan(String Ngay) {this.NgayTrongTuan = Ngay;}

    public String GetThoiGianHDSang() {return "ThoiGianHoatDongSang";}
    public void SetThoiGianHDSang(String Ngay) {this.ThoiGianHoatDongSang = Ngay;}

    public String GetThoiGianHDChieu() {return "ThoiGianHoatDongChieu";}
    public void SetThoiGianHDChieu(String Ngay) {this.ThoiGianHoatDongChieu = Ngay;}

    public String GetHangBhTraiTuyenId() {return "HangBhTraiTuyenId";}
    public void SetHangBhTraiTuyenId(String Id) {this.HangBHTraiTuyenId = Id;}
}
