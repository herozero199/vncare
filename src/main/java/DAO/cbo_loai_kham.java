package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CBO_LOAI_KHAM", schema = "QLKH_DATA")
public class cbo_loai_kham extends PanacheEntityBase {

    @Id
    @Column(name="ID")
    public Long id;

    @Column(name="DESCRIPTION")
    public String description;
}
