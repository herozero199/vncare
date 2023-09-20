package controller;

import DAO.dmc_thongtinkhoaphong;
import DAO.org_organization;
import generator.Generator;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import request.KhoaChiTiet;
import search.SearchCriteria;
import search.SearchOperation;
import service.KhoaService;
import service.TaiKhoanCongService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@Path("taikhoancong")
public class TaiKhoanCongController {
//
//    @Inject
//    TaiKhoanCongService taiKhoanCongService;
//
//    @Inject
//    Validator validator;
//
//    @Path("chitiet/{csyt_id}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getChiTiet(long csyt_id) {
//        return taiKhoanCongService.getChiTiet(new SearchCriteria("org_id", SearchOperation.EQUALITY, csyt_id));
//    }
//
//    @Path("them")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response them(KhoaChiTiet khoaChiTiet) {
//        Set<ConstraintViolation<KhoaChiTiet>> validation_org =  validator.validate(khoaChiTiet);
//        if(!validation_org.isEmpty()) {
//            String violations = validation_org.stream().map(violation -> violation.getMessage())
//                    .collect(Collectors.joining("\n"));
//            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
//        }
//
//        List<Object> gen = new Generator().generateFromKhoaChiTiet(khoaChiTiet);
//        return khoaService.them((org_organization) gen.get(0), (dmc_thongtinkhoaphong) gen.get(1));
//    }
//
//    @Path("xoa/{org_id}")
//    @PUT
//    public Response xoa(long org_id) {
//        return khoaService.xoa(new SearchCriteria("org_id", SearchOperation.EQUALITY, org_id));
//    }
}
