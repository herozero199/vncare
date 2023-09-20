package service;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import base_service.KhoaBaseService;
import exception_respose.RuntimeExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import search.SearchCriteria;
import java.util.List;

@ApplicationScoped
public class KhoaService {

    @Inject
    KhoaBaseService khoaBaseService;

    public Response getDanhSach (List<SearchCriteria> searchCriteriaList) {
        List<KhoaDanhSach> result;
        try {
            result = khoaBaseService.getDanhSach(searchCriteriaList);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response getChiTiet (SearchCriteria org_id) {
        KhoaChiTiet result;
        try {
            result = khoaBaseService.getChiTiet(org_id);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them (org_organization org, dmc_thongtinkhoaphong dmc) {
        try {
            khoaBaseService.them(org, dmc);
        } catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (TimeoutException f) {
            return Response.status(Response.Status.GATEWAY_TIMEOUT).entity(f.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response xoa (SearchCriteria org_id) {
        try {
            int deleted = khoaBaseService.xoaThongTinKhoa(org_id);
            if(deleted == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            int updated = khoaBaseService.capnhatStatus(org_id);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
    }
}
