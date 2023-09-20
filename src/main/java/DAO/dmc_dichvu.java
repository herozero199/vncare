package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="DMC_DICHVU", schema="QLHK_DATA")
public class dmc_dichvu extends PanacheEntityBase {

    @Id
    @Column(name="DICHVUID")
    public Integer dichvuid;

    @Column(name="MADICHVU")
    public String madichvu;

    @Column(name="TENDICHVU")
    public String tendichvu;

    @Column(name="TRANGTHAI")
    public Integer trangthai;

    @Column(name="NGAYAPDUNGGIAMOI")
    public Date ngayapdunggiamoi;

    @Column(name="GIATVTXCU")
    public Long giatvtxcu;

    @Column(name="GIATVTXMOI")
    public Long giatvtxmoi;

    @Column(name="GIACSYTCU")
    public Long giacsytcu;


    @Column(name="GIACSYTMOI")
    public Long giacsytmoi;

    @Column(name="CSYTID")
    public Long csytid;
}
