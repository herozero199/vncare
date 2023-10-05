package Controller;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import Request.KhoaChiTiet;
import Request.KhoaDanhSach;
import Service.KhoaService;

@Path("khoa")
public class KhoaController {

    @Inject
    KhoaService khoaService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    public Response getDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "sodong") Integer sodong, @QueryParam(value= "search") String search,
                                @QueryParam(value= "Order") String order) {

        return khoaService.GetDanhSach(trang, sodong, search, order);
    }

//    @Path("chitiet/{OrgId}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getChiTiet(long OrgId) {
//        return khoaService.GetChiTiet(OrgId);
//    }

//    @Path("them")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response them(KhoaChiTiet khoaChiTiet) throws IllegalAccessException {
//        Set<ConstraintViolation<KhoaChiTiet>> validation_org =  validator.validate(khoaChiTiet);
//        if(!validation_org.isEmpty()) {
//            String violations = validation_org.stream().map(violation -> violation.getMessage())
//                    .collect(Collectors.joining("\n"));
//            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
//        }
//
//        List<PanacheEntityBase> gen = new Generator(Arrays.asList(new org_organization(), new dmc_thongtinkhoaphong()), khoaChiTiet).generate();
//        return khoaService.them((org_organization) gen.get(0), (dmc_thongtinkhoaphong) gen.get(1));
//    }
//
//    @Path("xoa/{org_id}")
//    @PUT
//    public Response xoa(long org_id) {
//        return khoaService.xoa(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
//    }
}
