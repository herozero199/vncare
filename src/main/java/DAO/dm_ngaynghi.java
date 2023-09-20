package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="DM_NGAYNGHI", schema="QLHK_DATA")
public class dm_ngaynghi extends PanacheEntityBase {

    @Id
    @Column(name="NGAYNGHIID")
    Long ngaynghiid;

    @Column(name="LOAI")
    Integer loai;

    @Column(name="TUNGAY")
    Date tungay;

    @Column(name="THU")
    Integer thu;

    @Column(name="DENNGAY")
    Date denngay;

    @Column(name="NGHISANG")
    Integer nghisang;

    @Column(name="NGHICHIEU")
    Integer nghichieu;

    @Column(name="NGHITVTX")
    Integer nghitvtx;

    @Column(name="NGHICSYT")
    Integer nghicsyt;

    @Column(name="CSYTID")
    Long csytid;

    @Column(name="NGAY_TAO")
    Date ngay_tao;

    @Column(name="NGUOI_TAO")
    String nguoi_tao;
}
