package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="DMC_THONGTINKHOAPHONG", schema = "QLHK_COMMON")
public class DmcThongTinKhoaPhong extends DAO {

    @Id
    @Column(name="PHONGID")
    public Long phongId;

    @Id
    @Column(name="KHOAID")
    public Long khoaId;

    @Column(name="MAKHOABYT")
    public String maKhoaByt;

    @Column(name="CHUYENKHOAID")
    public Long chuyenKhoaId;

    @Column(name="SOPHONG")
    public String soPhong;

    @Column(name="TENPHONG_CHUYENKHOA")
    public String tenPhongChuyenKhoa;

    @Column(name="LOAIBENHANID")
    public Integer loaiBenhNhanId;

    @Column(name="STT_PHONGKHAM")
    public Integer sttPhongKham;

    @Column(name="SOPHONG_MANHINH")
    public String soPhongManHinh;

    @Column(name="CHUYENKHOAPHONGKHAM")
    public String chuyenKhoaPhongKham;

    @Column(name="PHONGGIAOSU")
    public Integer phongGiaoSu;

    @Column(name="TUVANTUXA")
    public Integer tuVanTuXa;

    @Column(name="KHAMCSYT")
    public Integer khamCsyt;

    @Column(name="CSYTID")
    public Integer csytId;

    @Column(name = "NGAYTRONGTUAN")
    public String ngayTrongTuan;

    @Column(name = "THOIGIANHD_SANG")
    public String thoiGianHoatDongSang;

    @Column(name = "THOIGIANHD_CHIEU")
    public String thoiGianHoatDongChieu;

    @Column(name = "HANG_BHTRAITUYEN_ID")
    public Integer hangBhTraiTuyenId;

}