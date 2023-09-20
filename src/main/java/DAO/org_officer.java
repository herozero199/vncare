package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.sql.Clob;
import java.sql.Date;

@Entity
@Table(name="ORG_OFFICER", schema = "QLHK_COMMON")
public class org_officer extends PanacheEntityBase {

    @Id
    @Column(name="OFFICER_ID")
    public Long officer_id;

    @Column(name="OFFICER_TYPE")
    public Long officer_type;

    @Column(name="DEPT_ID")
    public Long dept_id;

    @Column(name="SUBDEPT_ID")
    public Long subdept_id;

    @Column(name="COMPANY_ID")
    public Long company_id;

    @Column(name="STATUS")
    public Integer status;

    @Column(name="OFFICER_CODE")
    public String officer_code;

    @Column(name="OFFICER_NAME")
    public String officer_name;

    @Column(name="CHUCDANH")
    public String chucdanh;

    @Column(name="MA_BAC_SI")
    public String ma_bac_si;

    @Column(name="HOC_HAM")
    public String hoc_ham;

    @Column(name="HOC_VI")
    public String hoc_vi;

    @Column(name="TRINHDO")
    public String trinhdo;

    @Column(name="EMAIL")
    public String email;

    @Column(name="NOTE")
    public String note;

    @Column(name="PHONE")
    public String phone;

    @Column(name="OTP")
    public Integer otp;

    @Column(name="DIACHI")
    public String diachi;

    @Column(name="NGAYSINH")
    public Date ngaysinh;

    @Column(name="GIOITINH")
    public Integer gioitinh;

    @Column(name="CHU_KY_ANH")
    @Lob
    public Clob chu_ky_anh;

    @Column(name="SO_BHYT")
    public String so_bhyt;

    @Column(name="SO_BHXH")
    public String so_bhxh;

    @Column(name="TRUONGKHOA")
    public Integer truongkhoa;

    @OneToOne
    @JoinColumn(name="officer_type", referencedColumnName = "id")
    public org_officer_type loaiNhanVien;

    @OneToOne
    @JoinColumn(name="dept_id", referencedColumnName = "org_id")
    public org_organization khoa;

    @OneToOne
    @JoinColumn(name="subdept_id", referencedColumnName = "org_id")
    public org_organization phong;
}
