package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORG_OFFICER_TYPE", schema = "QLHK_COMMON")
public class org_officer_type extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    public Long id;

    @Column(name = "NAME")
    public String name;
}
