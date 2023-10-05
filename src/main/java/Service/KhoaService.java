package Service;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import BaseService.KhoaBaseService;
import ExceptionResponse.RuntimeExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import Request.KhoaChiTiet;
import Request.KhoaDanhSach;

import java.util.List;

@ApplicationScoped
public class KhoaService {

    @Inject
    KhoaBaseService khoaBaseService;

    public Response GetDanhSach (Integer trang, Integer sodong, String search, String order) {

        List<KhoaDanhSach> result;
        try {
            result = khoaBaseService.getDanhSach(trang, sodong, search, order);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

//    public Response GetChiTiet (long OrgId) {
//        KhoaChiTiet result;
//        try {
//            result = khoaBaseService.GetChiTiet(OrgId);
//        } catch(RuntimeException e) {
//            return new RuntimeExceptionResponse().getExceptionResponse(e);
//        }
//        return Response.status(Response.Status.OK).entity(result).build();
//    }

//    public Response them (org_organization org, dmc_thongtinkhoaphong dmc) {
//        try {
//            khoaBaseService.them(org, dmc);
//        } catch (ConstraintViolationException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
//        } catch (TimeoutException f) {
//            return Response.status(Response.Status.GATEWAY_TIMEOUT).entity(f.getMessage()).build();
//        }
//        return Response.status(Response.Status.OK).build();
//    }
//
//    public Response xoa (SearchCriteria org_id) {
//        try {
//            int deleted = khoaBaseService.xoaThongTinKhoa(org_id);
//            if(deleted == 0)
//                return Response.status(Response.Status.NOT_FOUND).build();
//
//            int updated = khoaBaseService.capnhatStatus(org_id);
//            if(updated == 0)
//                return Response.status(Response.Status.NOT_FOUND).build();
//
//            return Response.status(Response.Status.OK).build();
//        } catch(RuntimeException e) {
//            return new RuntimeExceptionResponse().getExceptionResponse(e);
//        }
//    }
}
