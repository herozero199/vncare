package DAO;


import jakarta.persistence.*;
import CustomAnnotation.Concept;

@Entity
@Table(name="ORG_ORGANIZATION", schema = "QLHK_COMMON")
public class OrgOrganization extends DAO{

    @Id
    @Column(name="ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_organization_seq")
    Long OrgId;

    @Column(name="ORG_CODE")
    String OrgCode;

    @Column(name="ORG_NAME")
    String OrgName;

    @Column(name="ORG_TYPE")
    Integer OrgType;
    
    @Column(name="ORG_LEVEL")
    String OrgLevel;

    @Column(name="ORG_ADDRESS")
    String OrgAddress;

    @Column(name="DB_NAME")
    String DBName;

    @Column(name="DB_SCHEMA")
    String DBSchema;
    
    @Column(name="PARENT_ID")
    Long ParentId;

    @Column(name="STATUS")
    Integer Status;

    @Column(name="PROVINCE_ID")
    Integer ProvinceId;

    @Column(name="NOTE")
    String Note;

    @OneToOne
    @JoinColumn(name="Org_Id", referencedColumnName = "KHOAID", insertable=false, updatable=false)
    DmcThongTinKhoaPhong ThongTinKhoa;

    @OneToOne
    @JoinColumn(name="parent_id", referencedColumnName = "org_id", insertable=false, updatable=false)
    OrgOrganization DonVi;

    @OneToOne
    @JoinColumn(name="Org_Id", referencedColumnName = "PHONGID", insertable=false, updatable=false)
    DmcThongTinKhoaPhong ThongTinPhong;

    public String GetId() {return "OrgId";}
    public void SetId(Long Id) {this.OrgId = Id;}

    public String GetCode() {return "OrgCode";}
    public void SetCode(String Code) {this.OrgCode = Code;}

    public String GetName() {return "OrgName";}
    public void SetName(String Name) {this.OrgName = Name;}

    public String GetType() {return "OrgType";}
    public void SetType(Integer Type) {this.OrgType = Type;}

    public String GetLevel() {return "OrgLevel";}
    public void SetLevel(String Level) {this.OrgLevel = Level;}

    public String GetAddress() {return "OrgAddress";}
    public void SetAddress(String Address) {this.OrgAddress = Address;}

    public String GetDBName() {return "DBName";}
    public void SetDBName(String Name) {this.DBName = Name;}

    public String GetDBSchema() {return "DBSchema";}
    public void SetDbSchema(String Name) {this.DBSchema = Name;}

    public String GetMaDonVi() {return "ParentId";}
    public void SetMaDonVi(Long Ma) {this.ParentId = Ma;}

    public String GetTrangThai() {return "Status";}
    public void SetTrangThai(Integer Status) {this.Status = Status;}

    public String GetMaSoYTe() {return "ProvinceId";}
    public void SetMaSoYTe(Integer Ma) {this.ProvinceId = Ma;}

    public String GetGhiChu() {return "Note";}
    public void SetGhiChu(String GhiChu) {this.Note = GhiChu;}

    public String GetThongTinKhoa() {return "ThongTinKhoa";}
    public String GetThongTinPhong() {return "ThongTinPhong";}

    public String GetDonVi() {return "DonVi";}

    public Long getOrgId() {
        return OrgId;
    }

    public String getOrgCode() {
        return OrgCode;
    }

    public String getOrgName() {
        return OrgName;
    }

    public Integer getOrgType() {
        return OrgType;
    }

    public String getOrgLevel() {
        return OrgLevel;
    }

    public String getOrgAddress() {
        return OrgAddress;
    }

    public String getDBName() {
        return DBName;
    }

    public String getDBSchema() {
        return DBSchema;
    }

    public Long getParentId() {
        return ParentId;
    }

    public Integer getStatus() {
        return Status;
    }

    public Integer getProvinceId() {
        return ProvinceId;
    }

    public String getNote() {
        return Note;
    }
}
