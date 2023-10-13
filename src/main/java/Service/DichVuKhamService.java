package Service;

import BaseService.DichVuKhamBaseService;
import BaseService.KhoaBaseService;
import DAO.DichVuKham;
import ExceptionResponse.RuntimeExceptionResponse;
import Request.Khoa.KhoaChiTiet;
import Request.Khoa.KhoaDanhSach;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class DichVuKhamService {

    @Inject
    DichVuKhamBaseService dichVuKhamBaseService;

    public Response GetDanhSach (Integer trang, Integer sodong, String search, String order) {

        List<DichVuKham> result;
        try {
            result = dichVuKhamBaseService.GetDanhSach(trang, sodong, search, order);
        } catch(RuntimeException | IllegalAccessException e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response GetChiTiet (long OrgId) {
        DichVuKham result;
        try {
            result = dichVuKhamBaseService.GetChiTiet(OrgId);
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

//    public Response them (DichVuKham dichVuKham) {
//        try {
//            dichVuKhamBaseService.Them(dichVuKham);
//        } catch (Exception e) {
//            return RuntimeExceptionResponse.getExceptionResponse(e);
//        }
//        return Response.status(Response.Status.OK).build();
//    }

    public Response Them (DichVuKham dichVuKham) {
        try {
            int updated = dichVuKhamBaseService.CapNhatStatus(dichVuKham);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            dichVuKhamBaseService.Them(dichVuKham);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return RuntimeExceptionResponse.getExceptionResponse(e);
        }
    }
}
