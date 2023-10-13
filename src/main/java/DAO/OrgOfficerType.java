package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORG_OFFICER_TYPE", schema = "QLHK_COMMON")
public class OrgOfficerType extends DAO {

    @Id
    @Column(name = "ID")
    public Long Id;

    @Column(name = "NAME")
    public String Name;

    public String GetId() {return "Id";}
    public void SetId(Long Id) {this.Id = Id;}

    public String GetName() {return "Name";}
    public void SetName(String name) {this.Name = name;}
}
