package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Table(name="QLHK_TGKHAM", schema="QLHK_DATA")
public class qlkh_tgkham extends PanacheEntityBase {

    @Column(name="NGAYTAO")
    public Date ngaytao;

    @Column(name="GHICHU")
    public String ghichu;

    @Column(name="SUDUNG")
    public Long sudung;

    @Column(name="TGKHAMID")
    public Long tgkhamid;

    @Column(name="TGBDSANG")
    public Long tgbdsang;

    @Column(name="TGKTSANG")
    public Long tgktsang;

    @Column(name="TGBDCHIEU")
    public Long tgbdchieu;

    @Column(name="TGKTCHIEU")
    public Long tgktchieu;

    @Column(name="TGKHAMCHOBN")
    public Long tgkhamchobn;

    @Column(name="LOAIKHAM")
    public Long loaikham;

    @Column(name="SLBENHNHANTHOIDIEM")
    public Integer slbenhnhanthoidiem;

    @Column(name="CSYTID")
    public Long csytid;

    @Column(name="ISDELETED")
    public Long isdeleted;

    @Column(name="NGUOITAOID")
    public Long nguoitaoid;

    @Column(name="NGAYXOA")
    public Date ngayxoa;

    @Column(name="NGUOIXOAID")
    public Long nguoixoaid;

}
