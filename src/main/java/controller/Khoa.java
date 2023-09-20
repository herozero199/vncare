package controller;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.KhoaService;

import java.util.Set;
import java.util.stream.Collectors;

@Path("khoa")
public class Khoa {

    @Inject
    KhoaService khoaService;

    @Inject
    Validator validator;


    @Path("danhsach?trang={trang}&so_dong={so_dong}")
    @GET
    public Response danh_sach(int trang, int so_dong, @QueryParam("ma_khoa") String ma_khoa, @QueryParam("ten_khoa") String ten_khoa, @QueryParam("trang_thai") Integer trang_thai) {
        if(trang <= 0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Page number must be greater or euqal to 1").build();
        return khoaService.get_danh_sach(trang, so_dong, ma_khoa, ten_khoa, trang_thai);
    }

    @Path("chitiet/{org_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response chi_tiet(long org_id) {
        return khoaService.get_chi_tiet(org_id);
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response them(JsonObject jsonObject) {
        org_organization org = jsonObject.getJsonObject("org_organization").mapTo(org_organization.class);
        Set<ConstraintViolation<org_organization>> validation_org =  validator.validate(org);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(violation -> violation.getMessage())
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        dmc_thongtinkhoaphong dmc = jsonObject.getJsonObject("dmc_thongtinkhoaphong").mapTo(dmc_thongtinkhoaphong.class);
        Set<ConstraintViolation<dmc_thongtinkhoaphong>> validation_dmc =  validator.validate(dmc);
        if(!validation_org.isEmpty()) {
            String violations = validation_dmc.stream().map(violation -> violation.getMessage())
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        return khoaService.them(org, dmc);
    }

    @Path("xoa/{org_id}")
    @PUT
    public Response xoa(long org_id) {
        return khoaService.xoa(org_id);
    }
}
