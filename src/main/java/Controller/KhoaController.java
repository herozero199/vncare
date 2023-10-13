package Controller;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import Request.Khoa.KhoaThem;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import Request.Khoa.KhoaChiTiet;
import Service.KhoaService;
import Generator.Generator;

import java.util.Arrays;
import java.util.List;
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
    public Response GetDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "sodong") Integer sodong, @QueryParam(value= "search") String search,
                                @QueryParam(value= "Order") String order) {
        if(sodong == null) sodong = 20;
        if(trang == null) trang = 0;
        return khoaService.GetDanhSach(trang, sodong, search, order);
    }

    @Path("chitiet/{OrgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetChiTiet(long OrgId) {
        return khoaService.GetChiTiet(OrgId);
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Them(KhoaThem khoaThem) throws IllegalAccessException {
        Set<ConstraintViolation<KhoaThem>> validation_org =  validator.validate(khoaThem);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        List<PanacheEntityBase> gen = new Generator(Arrays.asList(new OrgOrganization(), new DmcThongTinKhoaPhong()), khoaThem).generate();
        return khoaService.them((OrgOrganization) gen.get(0), (DmcThongTinKhoaPhong) gen.get(1));
    }

    @Path("xoa/{OrgId}")
    @PUT
    public Response Xoa(long OrgId) {
        return khoaService.Xoa(OrgId);
    }
}
