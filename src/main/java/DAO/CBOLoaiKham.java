package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Table(name = "CBO_LOAI_KHAM", schema = "QLHK_DATA")
public class CBOLoaiKham extends DAO {

    @Column(name = "NGAYTAO")
    Date NgayTao;

    @Column(name = "GHICHU")
    String GhiChu;

    @Column(name = "SUDUNG")
    Long SuDung;

    @Column(name = "TGKHAMID")
    Long TGKhamId;

    @Column(name = "TGBDSANG")
    Long TGBDSang;

    @Column(name = "TGKTSANG")
    Long TGKTSang;

    @Column(name = "TGBDCHIEU")
    Long TGBDChieu;

    @Column(name = "TGKTCHIEU")
    Long TGKTChieu;

    @Column(name = "TGKHAMCHOBN")
    Long TGKhamChoBN;

    @Column(name = "LOAIKHAM")
    Long LoaiKham;

    @Column(name = "SLBENHNHANTHOIDIEM")
    Integer SLBenhNhanThoiDiem;

    @Column(name = "CSYTID")
    Long CSYTId;

    @Column(name = "ISDELETED")
    Long IsDeleted;

    @Column(name = "NGUOITAOID")
    Long NguoiTaoId;

    @Column(name = "NGAYXOA")
    Date NgayXoa;

    @Column(name = "NGUOIXOAID")
    Long NguoiXoaId;

}
