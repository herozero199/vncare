package DAO;

import CustomAnnotation.Where;
import CustomAnnotation.Wheres;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name="ORG_ORGANIZATION", schema = "QLHK_COMMON")
public class org_organization extends PanacheEntityBase{

    @Id
    @Column(name="ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_organization_seq")
    public Long org_id;

    @Column(name="ORG_CODE")
    public String org_code;

    @Column(name="ORG_NAME")
    public String org_name;

    @Column(name="ORG_TYPE")
    public Integer org_type;

    @Column(name="ORG_LEVEL")
    @Wheres(value = {
            @Where(name = "danhsachkhoa", searchOperation = "=", value = "4", connector = "&"),
            @Where(name = "chitietkhoa", searchOperation = "=", value = "4", connector = "&")
    })
    public String org_level;

    @Column(name="ORG_ADDRESS")
    public String org_address;

    @Column(name="DB_NAME")
    public String db_name;

    @Column(name="DB_SCHEMA")
    public String db_schema;

    @Column(name="PARENT_ID")
    @Wheres(value = {
            @Where( name="danhsachkhoa", searchOperation = "=", value = "14331", connector = "&"),
            @Where( name="chitietkhoa", searchOperation = "=", value = "14331", connector = "&")
    })
    public Long parent_id;

    @Column(name="STATUS")
    @Wheres(value = {
            @Where(name="danhsachkhoa", searchOperation = "=", value = "1", connector = "&")
    })
    public Integer status;

    @Column(name="PROVINCE_ID")
    public Integer province_id;

    @Column(name="NOTE")
    public String note;

    @OneToOne
    @JoinColumn(name="org_id", referencedColumnName = "khoaid", insertable=false, updatable=false)
    public dmc_thongtinkhoaphong khoa;

    @OneToOne
    @JoinColumn(name="parent_id", referencedColumnName = "org_id", insertable=false, updatable=false)
    public org_organization donvi;

    @OneToOne
    @JoinColumn(name="org_id", referencedColumnName = "phongid", insertable=false, updatable=false)
    public dmc_thongtinkhoaphong phong;

    public org_organization(Long org_id, String org_code, String org_name, Integer status) {
        this.org_id = org_id;
        this.org_code = org_code;
        this.org_name = org_name;
        this.status = status;
    }

    public org_organization() {}

    @Override
    public String toString() {
        return "org_organization{" +
                "org_id=" + org_id +
                ", org_code='" + org_code + '\'' +
                ", org_name='" + org_name + '\'' +
                ", org_type=" + org_type +
                ", org_level='" + org_level + '\'' +
                ", org_address='" + org_address + '\'' +
                ", db_name='" + db_name + '\'' +
                ", db_schema='" + db_schema + '\'' +
                ", parent_id=" + parent_id +
                ", status=" + status +
                ", province_id=" + province_id +
                ", note='" + note + '\'' +
                ", khoa=" + khoa +
                ", donvi=" + donvi +
                ", phong=" + phong +
                '}';
    }
}
