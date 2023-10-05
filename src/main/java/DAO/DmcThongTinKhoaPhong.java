package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="DMC_THONGTINKHOAPHONG", schema = "QLHK_COMMON")
public class DmcThongTinKhoaPhong extends PanacheEntityBase {

    @Id
    @Column(name="PHONGID")
    public Long PhongId;

    @Id
    @Column(name="KHOAID")
    public Long KhoaId;

    @Column(name="MAKHOABYT")
    public String MaKhoaByt;

    @Column(name="CHUYENKHOAID")
    public Long ChuyenKhoaId;

    @Column(name="SOPHONG")
    public String SoPhong;

    @Column(name="TENPHONG_CHUYENKHOA")
    public String TenPhongChuyenKhoa;

    @Column(name="LOAIBENHANID")
    public Integer LoaiBenhNhanId;

    @Column(name="STT_PHONGKHAM")
    public Integer SttPhongKham;

    @Column(name="SOPHONG_MANHINH")
    public String SoPhongManHinh;

    @Column(name="CHUYENKHOAPHONGKHAM")
    public String ChuyenKhoaPhongKham;

    @Column(name="PHONGGIAOSU")
    public Integer PhongGiaoSu;

    @Column(name="TUVANTUXA")
    public Integer TuVanTuXa;

    @Column(name="KHAMCSYT")
    public Integer KhamCsyt;

    @Column(name="CSYTID")
    public Integer CsytId;

    @Column(name="HANG_BHTRAITUYEN_ID")
    public Integer HangBhTraiTuyenId;

}
