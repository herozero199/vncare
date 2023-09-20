package service;

import DAO.org_officer;
import base_service.NhanVienBaseService;
import exception_respose.RuntimeExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import request.KhoaDanhSach;
import request.NhanVienChiTiet;
import request.NhanVienDanhSach;
import search.SearchCriteria;

import java.util.List;

@ApplicationScoped
public class NhanVienService {

    @Inject
    NhanVienBaseService nhanVienBaseService;

    public Response getDanhSach(List<SearchCriteria> searchCriteriaList) {
        List<NhanVienDanhSach> result;
        try {
            result = nhanVienBaseService.getDanhSach(searchCriteriaList);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response getChiTiet(SearchCriteria officer_id) {
        NhanVienChiTiet result;
        try {
            result = nhanVienBaseService.getChiTiet(officer_id);
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    public Response them(org_officer nhanvien) {
        try {
            nhanVienBaseService.them(nhanvien);
        } catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (
        TimeoutException f) {
            return Response.status(Response.Status.GATEWAY_TIMEOUT).entity(f.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response xoa(SearchCriteria officer_id) {
        try {
            int deleted = nhanVienBaseService.xoa(officer_id);

            if(deleted == 0)
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch(RuntimeException e) {
            return new RuntimeExceptionResponse().getExceptionResponse(e);
        }
        return Response.status(Response.Status.OK).build();
    }
}
