package service;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import base_service.KhoaBaseService;
import base_service.PhongBaseService;
import exception_respose.RuntimeExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import request.KhoaChiTiet;
import request.KhoaDanhSach;
import request.PhongChiTiet;
import request.PhongDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class PhongService {

    @Inject
    PhongBaseService phongBaseService;

    public Response getDanhSach (List<SearchCriteria> searchCriteriaList) {
        List<PhongDanhSach> result;
        try {
            result = phongBaseService.getDanhSach(searchCriteriaList);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response getChiTiet (SearchCriteria org_id) {
        PhongChiTiet result;
        try {
            result = phongBaseService.getChiTiet(org_id);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them (org_organization org, dmc_thongtinkhoaphong dmc) {
        try {
            phongBaseService.them(org, dmc);
        } catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (TimeoutException f) {
            return Response.status(Response.Status.GATEWAY_TIMEOUT).entity(f.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response xoa (SearchCriteria org_id) {
        try {
            int updated = phongBaseService.capnhatStatus(org_id);
            if(updated == 0)
                return Response.status(Response.Status.NOT_FOUND).build();

            return Response.status(Response.Status.OK).build();
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
    }
}
