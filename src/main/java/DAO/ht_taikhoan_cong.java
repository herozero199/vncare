package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="HT_TAIKHOAN_CONG", schema = "QLHK_COMMON")
public class ht_taikhoan_cong extends PanacheEntityBase {

    @Column(name = "CSYT_ID")
    public Long csyt_id;

    @Column(name = "HIS_USER_CSYT")
    public String his_user_csyt;

    @Column(name = "HIS_PASS_CSYT")
    public String his_pass_csyt;

    @Column(name = "HIS_USER_INSTR")
    public String his_user_insr;

    @Column(name = "HIS_PASS_INSTR")
    public String his_pass_insr;

    @Column(name = "TINH_ID")
    public Integer tinh_id;

    @Column(name = "HUYEN_ID")
    public Long huyen_id;

    @Column(name = "TEN_CSYT")
    public String ten_csyt;
}
