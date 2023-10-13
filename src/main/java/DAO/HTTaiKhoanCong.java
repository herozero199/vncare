package DAO;

import jakarta.persistence.*;

@Table(name = "HT_TAIKHOAN_CONG", schema = "QLHK_COMMON")
public class HTTaiKhoanCong extends  DAO {

    @Column(name = "CSYT_ID")
    Long CSYTId;

    @Column(name = "HIS_USER_CSYT")
    String HisUserCSYT;

    @Column(name = "HIS_PASS_CSYT")
    String HisPassCSYT;

    @Column(name = "HIS_USER_INSR")
    String HisUserINSR;

    @Column(name = "HIS_PASS_INSR")
    String HisPassINSR;

    @Column(name = "TINH_ID")
    Integer TinhId;

    @Column(name = "HUYEN_ID")
    Long HuyenId;

    @Column(name = "TEN_CSYT")
    String TenCSYT;

    @OneToOne
    @JoinColumn(name = "Tinh_Id", referencedColumnName = "DIAPHUONGID")
    DMCDiaPhuong DiaPhuong;

    @OneToOne
    @JoinColumn(name = "Huyen_Id", referencedColumnName = "DIAPHUONGID")
    DMCDiaPhuong Huyen;

    public Long getCSYTIdValue() {
        return CSYTId;
    }

    public String getHisUserCSYTValue() {
        return HisUserCSYT;
    }

    public String getHisPassCSYTValue() {
        return HisPassCSYT;
    }

    public String getHisUserINSRValue() {
        return HisUserINSR;
    }

    public String getHisPassINSRValue() {
        return HisPassINSR;
    }

    public Integer getTinhIdValue() {
        return TinhId;
    }

    public Long getHuyenIdValue() {
        return HuyenId;
    }

    public String getTenCSYTValue() {
        return TenCSYT;
    }

    public String getCSYTId() {
        return "CSYTId";
    }

    public String getHisUserCSYT() {
        return "HisUserCSYT";
    }

    public String getHisPassCSYT() {
        return "HisPassCSYT";
    }

    public String getHisUserINSR() {
        return "HisUserINSR";
    }

    public String getHisPassINSR() {
        return "HisPassINSR";
    }

    public String getTinhId() {
        return "TinhId";
    }

    public String getHuyenId() {
        return "HuyenId";
    }

    public String getTenCSYT() {
        return "TenCSYT";
    }
}
