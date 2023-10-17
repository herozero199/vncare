package Controller;

import Request.Khoa.KhoaThem;
import Service.KhoaService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;
import java.util.stream.Collectors;

@Path("khoa")
public class KhoaController {

    @Inject
    KhoaService khoaService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "soDong") Integer soDong,
                                @QueryParam(value= "Search") String filter) {

        return khoaService.layDanhSach(trang, soDong, filter);
    }

    @Path("chitiet/{orgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChiTiet(Long orgId) {
        return khoaService.layChiTiet(orgId);
    }

    @Path("them")
    @POST
    public Response themKhoa(KhoaThem khoaThem) {

        Set<ConstraintViolation<KhoaThem>> validation_org =  validator.validate(khoaThem);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        return khoaService.themKhoa(khoaThem);
    }

    @Path("xoa/{orgId}")
    @DELETE
    public Response xoaKhoa(Long orgId) {
        return khoaService.xoaKhoa(orgId);
    }
}
