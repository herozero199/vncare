package Service;

import BaseService.NhanVienBaseService;
import DAO.OrgOfficer;
import ExceptionResponse.RuntimeExceptionResponse;
import Request.NhanVien.NhanVienDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class NhanVienService {

    @Inject
    NhanVienBaseService nhanVienBaseService;

    public Response GetDanhSach (Integer trang, Integer sodong, String search, String order) {

        List<NhanVienDanhSach> result;
        try {
            result = nhanVienBaseService.GetDanhSach(trang, sodong, search, order);
        } catch(RuntimeException | IllegalAccessException e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response GetChiTiet (long OfficerId) {
        OrgOfficer result;
        try {
            result = nhanVienBaseService.GetChiTiet(OfficerId);
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them (OrgOfficer nhanVien) {
        try {
            nhanVienBaseService.Them(nhanVien);
        } catch (Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response Xoa (long OrgId) {
        try {
//            int deleted = nhanVienBaseService.XoaThongTinNhanVien(OrgId);
//            if(deleted == 0)
//                return Response.status(Response.Status.NOT_FOUND).build();

            int updated = nhanVienBaseService.CapNhatStatus(OrgId);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }
}
