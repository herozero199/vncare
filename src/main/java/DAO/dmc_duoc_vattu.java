package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DMC_DUOC_VATTU", schema = "QLHK_DATA")
public class dmc_duoc_vattu extends PanacheEntityBase {

    @Id
    @Column(name="DUOCVATTUID")
    Long duocvattuid;

    @Column(name="MADUOCVATTU")
    String maduocvattu;

    @Column(name="TENDUOCVATTU")
    String tenduocvattu;

    @Column(name="HAMLUONG")
    String hamluong;

    @Column(name="TRANGTHAI")
    Integer trangthai;

    @Column(name="DUOCHOATCHATID")
    Long duochoatchatid;

    @Column(name="DUOCDUONGDUNGID")
    Long duocduongdungid;

    @Column(name="DONVICAPPHATID")
    Long donvicapphatid;

    @Column(name="CSYTID")
    Long csytid;

    @Column(name="SODANGKY")
    String sodangky;

    @Column(name="SOQUYETDINH")
    String soquyetdinh;

    @Column(name="HOATCHATSDK")
    String hoatchatsdk;

    @Column(name="DONGGOI")
    String donggoi;

    @Column(name="HAGNSANXUAT")
    String hangsanxuat;

    @Column(name="NUOCSANXUAT")
    String nuocsanxuat;
}
