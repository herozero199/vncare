package Controller;

import DAO.DichVuKham;
import Service.DichVuKhamService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Set;
import java.util.stream.Collectors;

@Path("dichvukham")
public class DichVuKhamController {

    @Inject
    DichVuKhamService dichVuKhamService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    public Response GetDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "sodong") Integer sodong, @QueryParam(value= "search") String search,
                                @QueryParam(value= "Order") String order) {
        if(sodong == null) sodong = 20;
        if(trang == null) trang = 0;
        return dichVuKhamService.GetDanhSach(trang, sodong, search, order);
    }

    @Path("chitiet/{DivhVuId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetChiTiet(long DichVuId) {
        return dichVuKhamService.GetChiTiet(DichVuId);
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Them(DichVuKham dichVuKham) throws IllegalAccessException {
        Set<ConstraintViolation<DichVuKham>> validation_org =  validator.validate(dichVuKham);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        return dichVuKhamService.Them(dichVuKham);
    }

//    @Path("xoa/{DichVuId}")
//    @PUT
//    public Response Xoa(long DichVuId) {
//        return dichVuKhamService.Xoa(DichVuId);
//    }
}
