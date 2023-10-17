package DAO;


import jakarta.persistence.*;

@Entity
@Table(name="ORG_ORGANIZATION", schema = "QLHK_COMMON")
public class OrgOrganization extends DAO{

    @Id
    @Column(name="ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_organization_seq")
    public Long orgId;

    @Column(name="ORG_CODE")
    public String orgCode;

    @Column(name="ORG_NAME")
    public String orgName;

    @Column(name="ORG_TYPE")
    public Integer orgType;

    public @Column(name="ORG_LEVEL")
    String orgLevel;

    @Column(name="ORG_ADDRESS")
    public String orgAddress;

    @Column(name="DB_NAME")
    public String dbName;

    @Column(name="DB_SCHEMA")
    public String dbSchema;

    @Column(name="PARENT_ID")
    public Long parentId;

    @Column(name="STATUS")
    public Integer status;

    @Column(name="PROVINCE_ID")
    public Integer provinceId;

    @Column(name="NOTE")
    public String note;

}