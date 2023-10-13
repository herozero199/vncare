package Controller;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Generator.Generator;
import Request.Phong.PhongChiTiet;
import Request.Phong.PhongThem;
import Service.PhongService;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("phong")
public class PhongController {


    @Inject
    PhongService phongService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    public Response GetDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "sodong") Integer sodong, @QueryParam(value= "search") String search,
                                @QueryParam(value= "Order") String order) {
        if(sodong == null) sodong = 20;
        if(trang == null) trang = 0;
        return phongService.GetDanhSach(trang, sodong, search, order);
    }

    @Path("chitiet/{OrgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetChiTiet(long OrgId) {
        return phongService.GetChiTiet(OrgId);
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Them(PhongThem phongThem) throws IllegalAccessException {
        Set<ConstraintViolation<PhongThem>> validation_org =  validator.validate(phongThem);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        List<PanacheEntityBase> gen = new Generator(Arrays.asList(new OrgOrganization(), new DmcThongTinKhoaPhong()), phongThem).generate();
        return phongService.them((OrgOrganization) gen.get(0), (DmcThongTinKhoaPhong) gen.get(1));
    }

    @Path("xoa/{OrgId}")
    @PUT
    public Response Xoa(long OrgId) {
        return phongService.Xoa(OrgId);
    }
}
