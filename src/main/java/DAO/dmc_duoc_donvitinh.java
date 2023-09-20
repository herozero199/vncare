package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DMC_DUOC_DONVITINH", schema="QLHK_DATA")
public class dmc_duoc_donvitinh extends PanacheEntityBase {

    @Id
    @Column(name="DUOCDONVITINHID")
    Long duocdonvitinhid;

    @Column(name="TENDONVITINH")
    String tendonvitinh;
}
