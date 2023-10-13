package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "DMC_DICHVU", schema = "QLHK_DATA")
public class DichVuKham extends DAO {

    @Id
    @Column(name = "DICHVUID")
    Integer DichVuId;

    @Column(name = "MADICHVU")
    String MaDichVu;

    @Column(name = "TENDICHVU")
    String TenDichVu;

    @Column(name = "TRANGTHAI")
    Integer TrangThai;

    @Column(name = "NGAYAPDUNGGIAMOI")
    Date NgayApDungGiaMoi;

    @Column(name = "GIATVTXCU")
    Long GiaTVTXCu;

    @Column(name = "GIATVTXMOI")
    Long GiaTVTXMoi;

    @Column(name = "GIACSYTCU")
    Long GiaCSYTCu;

    @Column(name = "GIACSYTMOI")
    Long GiaCSYTMoi;

    @Column(name = "CSYTID")
    Long CSYTId;

    public Integer getDichVuIdValue() {
        return DichVuId;
    }

    public String getMaDichVuValue() {
        return MaDichVu;
    }

    public String getTenDichVuValue() {
        return TenDichVu;
    }

    public Integer getTrangThaiValue() {
        return TrangThai;
    }

    public Date getNgayApDungGiaMoiValue() {
        return NgayApDungGiaMoi;
    }

    public Long getGiaTVTXCuValue() {
        return GiaTVTXCu;
    }

    public Long getGiaTVTXMoiValue() {
        return GiaTVTXMoi;
    }

    public Long getGiaCSYTCuValue() {
        return GiaCSYTCu;
    }

    public Long getGiaCSYTMoiValue() {
        return GiaCSYTMoi;
    }

    public Long getCSYTIdValue() {
        return CSYTId;
    }

    public String getDichVuId() {
        return "DichVuId";
    }

    public String getMaDichVu() {
        return "MaDichVu";
    }

    public String getTenDichVu() {
        return "TenDichVu";
    }

    public String getTrangThai() {
        return "TrangThai";
    }

    public String getNgayApDungGiaMoi() {
        return "NgayApDungGiaMoi";
    }

    public String getGiaTVTXCu() {
        return "GiaTVTXCu";
    }

    public String getGiaTVTXMoi() {
        return "GiaTVTXMoi";
    }

    public String getGiaCSYTCu() {
        return "GiaCSYTCu";
    }

    public String getGiaCSYTMoi() {
        return "GiaCSYTMoi";
    }

    public String getCSYTId() {
        return "CSYTId";
    }
}
