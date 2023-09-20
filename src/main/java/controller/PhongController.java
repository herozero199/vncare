package controller;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import generator.Generator;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import request.KhoaChiTiet;
import request.PhongChiTiet;
import search.SearchCriteria;
import search.SearchOperation;
import service.KhoaService;
import service.PhongService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/phong")
public class PhongController {

    @Inject
    PhongService phongService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    public Response getDanhSach(@QueryParam(value="search") String search) {
//        @QueryParam("trang") @DefaultValue("1") String trang, @QueryParam("so_dong") @DefaultValue("20") String so_dong,
//        @QueryParam("ma_phong") String ma_phong, @QueryParam("ten_phong") String ten_phong, @QueryParam("ten_khoa") Integer ten_khoa,
//        @QueryParam("trang_thai") Integer trang_thai
        List<SearchCriteria> searchCriteriaList = SearchCriteria.getListSearchCriteria(search);
        return phongService.getDanhSach(searchCriteriaList);
    }

    @Path("chitiet/{org_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChiTiet(long org_id) {
        return phongService.getChiTiet(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response them(PhongChiTiet phongChiTiet) throws IllegalAccessException {
        Set<ConstraintViolation<PhongChiTiet>> validation_org =  validator.validate(phongChiTiet);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(violation -> violation.getMessage())
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        List<PanacheEntityBase> gen = new Generator(Arrays.asList(new org_organization(), new dmc_thongtinkhoaphong()), phongChiTiet).generate();
        return phongService.them((org_organization) gen.get(0), (dmc_thongtinkhoaphong) gen.get(1));
    }

    @Path("xoa/{org_id}")
    @PUT
    public Response xoa(long org_id) {
        return phongService.xoa(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
    }
}
