package Service;

import BaseService.PhongBaseService;
import BaseService.PhongBaseService;
import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import ExceptionResponse.RuntimeExceptionResponse;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongDanhSach;
import Request.Phong.PhongDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class PhongService {

    @Inject
    PhongBaseService phongBaseService;

    public Response GetDanhSach (Integer trang, Integer sodong, String search, String order) {

        List<PhongDanhSach> result;
        try {
            result = phongBaseService.GetDanhSach(trang, sodong, search, order);
        } catch(RuntimeException | IllegalAccessException e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response GetChiTiet (long OrgId) {
        PhongChiTiet result;
        try {
            result = phongBaseService.GetChiTiet(OrgId);
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them (OrgOrganization org, DmcThongTinKhoaPhong dmc) {
        try {
            phongBaseService.Them(org, dmc);
        } catch (Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response Xoa (long OrgId) {
        try {
//            int deleted = phongBaseService.XoaThongTinPhong(OrgId);
//            if(deleted == 0)
//                return Response.status(Response.Status.NOT_FOUND).build();

            int updated = phongBaseService.CapNhatStatus(OrgId);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }
}
