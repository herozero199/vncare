package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name="ORG_ORGANIZATION", schema = "QLHK_COMMON")
public class OrgOrganization extends PanacheEntityBase{

    @Id
    @Column(name="ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_organization_seq")
    public Long OrgId;

    @Column(name="ORG_CODE")
    public String OrgCode;

    @Column(name="ORG_NAME")
    public String OrgName;

    @Column(name="ORG_TYPE")
    public Integer OrgType;

    @Column(name="ORG_LEVEL")
    public String OrgLevel;

    @Column(name="ORG_ADDRESS")
    public String OrgAddress;

    @Column(name="DB_NAME")
    public String DbName;

    @Column(name="DB_SCHEMA")
    public String DbSchema;

    @Column(name="PARENT_ID")
    public Long ParentId;

    @Column(name="STATUS")
    public Integer Status;

    @Column(name="PROVINCE_ID")
    public Integer ProvinceId;

    @Column(name="NOTE")
    public String Note;

    @OneToOne
    @JoinColumn(name="org_id", referencedColumnName = "khoaid", insertable=false, updatable=false)
    public DmcThongTinKhoaPhong Khoa;

    @OneToOne
    @JoinColumn(name="parent_id", referencedColumnName = "org_id", insertable=false, updatable=false)
    public OrgOrganization DonVi;

    @OneToOne
    @JoinColumn(name="org_id", referencedColumnName = "phongid", insertable=false, updatable=false)
    public DmcThongTinKhoaPhong Phong;

}
