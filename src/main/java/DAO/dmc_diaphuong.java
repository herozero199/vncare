package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DMC_DIAPHUONG", schema = "QLHK_COMMON")
public class dmc_diaphuong extends PanacheEntityBase {

    @Column(name = "MADIAPHUONG")
    public String madiaphuong;

    @Id
    @Column(name="DIAPHUONGID")
    public Long diaphuongid;
}
