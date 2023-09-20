package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CBO_TGKHAM_SANG", schema="QLHK_DATA")
public class cbo_tgkham_sang extends PanacheEntityBase {

    @Id
    @Column(name="ID")
    public Long id;

    @Column(name="TIME")
    public String time;
}
