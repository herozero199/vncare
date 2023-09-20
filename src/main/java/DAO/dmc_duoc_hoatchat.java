package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DMC_DUOC_HOATCHAT", schema = "QLHK_DATA")
public class dmc_duoc_hoatchat extends PanacheEntityBase {

    @Id
    @Column(name="DUOCHOATCHATID")
    Long duochoatchatid;

    @Column(name="TENHOATCHAT")
    String tenhoatchat;

}
