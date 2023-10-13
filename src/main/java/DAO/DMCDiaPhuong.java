package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "DMC_DIAPHUONG", schema = "QLHK_COMMON")
@Entity
public class DMCDiaPhuong extends DAO{

    @Column(name = "MADIAPHUONG")
    String MaDiaPhuong;

    @Id
    @Column(name = "DIAPHUONGID")
    Long DiaPhuongId;

    public String getMaDiaPhuongValue() {
        return MaDiaPhuong;
    }

    public Long getDiaPhuongIdValue() {
        return DiaPhuongId;
    }

    public String getMaDiaPhuong() {
        return "MaDiaPhuong";
    }

    public String getDiaPhuongId() {
        return "DiaPhuongId";
    }

    public void setMaDiaPhuong(String maDiaPhuong) {
        MaDiaPhuong = maDiaPhuong;
    }

    public void setDiaPhuongId(Long diaPhuongId) {
        DiaPhuongId = diaPhuongId;
    }
}
