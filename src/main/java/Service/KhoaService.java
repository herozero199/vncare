package Service;

import BaseService.RequestObject;
import DAO.DAO;
import DAO.OrgOrganization;
import DAO.DmcThongTinKhoaPhong;
import ExceptionResponse.RuntimeExceptionResponse;
import FileReading.FileReading;
import Repository.KhoaRepository;
import Request.Khoa.KhoaThem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class KhoaService {

    @Inject
    KhoaRepository khoaRepository;

    public Response layDanhSach(Integer trang, Integer soDong, String filter) {

        try {
            String requestObjectName = RequestObject.getRequestObjectName("src/main/java/SQLStatement/Khoa/DanhSach/Request.txt");
            String query = FileReading.ReadFile("src/main/java/SQLStatement/Khoa/DanhSach/SQL.txt");
            return Response.status(Response.Status.OK).entity(khoaRepository.layDanhSach(query, requestObjectName, trang, soDong, filter)).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }

    public Response layChiTiet(Long orgId) {

        try {
            String requestObjectName = RequestObject.getRequestObjectName("src/main/java/SQLStatement/Khoa/ChiTiet/Request.txt");
            String query = FileReading.ReadFile("src/main/java/SQLStatement/Khoa/ChiTiet/SQL.txt");
            return Response.status(Response.Status.OK).entity(khoaRepository.layChiTiet(query, requestObjectName, orgId)).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }

    public Response themKhoa(KhoaThem khoaThem) {
        try {
            List<DAO> daoList = khoaThem.extract(Arrays.asList(OrgOrganization.class, DmcThongTinKhoaPhong.class), khoaThem.getClass());
            if (daoList == null) return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            khoaRepository.themKhoa((OrgOrganization) daoList.get(0), (DmcThongTinKhoaPhong) daoList.get(1));
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }

    public Response xoaKhoa(Long orgId) {

        try {
            String query = FileReading.ReadFile("src/main/java/SQLStatement/Khoa/Xoa/XoaThongTinKhoa.txt");
            int deleted = khoaRepository.xoa(query, orgId);
            if(deleted == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            query = FileReading.ReadFile("src/main/java/SQLStatement/Khoa/Xoa/CapNhatTrangThai.txt");
            int updated = khoaRepository.capNhatTrangThai(query, orgId);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }
}
