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
import request.KhoaDanhSach;
import search.SearchCriteria;
import search.SearchOperation;
import service.KhoaService;

import java.util.ArrayList;
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
    public Response getDanhSach(@QueryParam(value="search") String search) {

        List<SearchCriteria> searchCriteriaList = SearchCriteria.getListSearchCriteria(search);
        return khoaService.getDanhSach(searchCriteriaList);
    }

    @Path("chitiet/{org_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChiTiet(long org_id) {
        return khoaService.getChiTiet(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response them(KhoaChiTiet khoaChiTiet) throws IllegalAccessException {
        Set<ConstraintViolation<KhoaChiTiet>> validation_org =  validator.validate(khoaChiTiet);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(violation -> violation.getMessage())
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        List<PanacheEntityBase> gen = new Generator(Arrays.asList(new org_organization(), new dmc_thongtinkhoaphong()), khoaChiTiet).generate();
        return khoaService.them((org_organization) gen.get(0), (dmc_thongtinkhoaphong) gen.get(1));
    }

    @Path("xoa/{org_id}")
    @PUT
    public Response xoa(long org_id) {
        return khoaService.xoa(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
    }
}
