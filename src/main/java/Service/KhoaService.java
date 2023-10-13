package Service;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import BaseService.KhoaBaseService;
import ExceptionResponse.RuntimeExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;
import java.util.List;

@ApplicationScoped
public class KhoaService {

    @Inject
    KhoaBaseService khoaBaseService;

    public Response GetDanhSach (Integer trang, Integer sodong, String search, String order) {

        List<KhoaDanhSach> result;
        try {
            result = khoaBaseService.GetDanhSach(trang, sodong, search, order);
        } catch(RuntimeException | IllegalAccessException e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response GetChiTiet (long OrgId) {
        KhoaChiTiet result;
        try {
            result = khoaBaseService.GetChiTiet(OrgId);
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them (OrgOrganization org, DmcThongTinKhoaPhong dmc) {
        try {
            khoaBaseService.Them(org, dmc);
        } catch (Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response Xoa (long OrgId) {
        try {
            int deleted = khoaBaseService.XoaThongTinKhoa(OrgId);
            if(deleted == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            int updated = khoaBaseService.CapNhatStatus(OrgId);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }
}
