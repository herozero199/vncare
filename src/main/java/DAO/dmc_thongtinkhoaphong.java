package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="DMC_THONGTINKHOAPHONG", schema = "QLHK_COMMON")
public class dmc_thongtinkhoaphong extends PanacheEntityBase {

    @Id
    @Column(name="PHONGID")
    public Long phongid;

    @Id
    @Column(name="KHOAID")
    public Long khoaid;

    @Column(name="MAKHOABYT")
    public String makhoabyt;

    @Column(name="CHUYENKHOAID")
    public Long chuyenkhoaid;

    @Column(name="SOPHONG")
    public String sophong;

    @Column(name="TENPHONG_CHUYENKHOA")
    public String tenphong_chuyenkhoa;

    @Column(name="LOAIBENHANID")
    public Integer loaibenhanid;

    @Column(name="STT_PHONGKHAM")
    public Integer stt_phongkham;

    @Column(name="SOPHONG_MANHINH")
    public String sophong_manhinh;

    @Column(name="CHUYENKHOAPHONGKHAM")
    public String chuyenkhoaphongkham;

    @Column(name="PHONGGIAOSU")
    public Integer phonggiaosu;

    @Column(name="TUVANTUXA")
    public Integer tuvantuxa;

    @Column(name="KHAMCSYT")
    public Integer khamcsyt;

    @Column(name="CSYTID")
    public Integer csytid;

    @Column(name="HANG_BHTRAITUYEN_ID")
    public Integer hang_bhtraituyen_id;

    @Override
    public String toString() {
        return "dmc_thongtinkhoaphong{" +
                "phongid=" + phongid +
                ", khoaid=" + khoaid +
                ", makhoabyt='" + makhoabyt + '\'' +
                ", chuyenkhoaid=" + chuyenkhoaid +
                ", sophong='" + sophong + '\'' +
                ", tenphong_chuyenkhoa='" + tenphong_chuyenkhoa + '\'' +
                ", loaibenhanid=" + loaibenhanid +
                ", stt_phongkham=" + stt_phongkham +
                ", sophong_manhinh='" + sophong_manhinh + '\'' +
                ", chuyenkhoaphongkham='" + chuyenkhoaphongkham + '\'' +
                ", phonggiaosu=" + phonggiaosu +
                ", tuvantuxa=" + tuvantuxa +
                ", khamcsyt=" + khamcsyt +
                ", csytid=" + csytid +
                ", hang_bhtraituyen_id=" + hang_bhtraituyen_id +
                '}';
    }
}
