package controller;

import DAO.org_officer;
import generator.Generator;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import request.NhanVienChiTiet;
import search.SearchCriteria;
import search.SearchOperation;
import service.NhanVienService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("nhanvien")
public class NhanVienController {

    @Inject
    NhanVienService nhanVienService;

    @Inject
    Validator validator;

    @GET
    @Path("/danhsach")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDanhSach(@QueryParam("trang") @DefaultValue("1") String trang,@QueryParam("so_dong") @DefaultValue("20") String so_dong,
                                @QueryParam("ma_nhan_vien") Long ma_nhan_vien, @QueryParam("ma_bac_sy") String ma_bac_sy,
                                @QueryParam("ten_nhan_vien") String ten_nhan_vien, @QueryParam("loai_nhan_vien") Long loai_nhan_vien,
                                @QueryParam("ten_khoa") String ten_khoa, @QueryParam("ten_phong") String ten_phong)
    {
        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        searchCriteriaList.add(new SearchCriteria("trang", SearchOperation.EQUALITY, Integer.parseInt(trang)));
        searchCriteriaList.add(new SearchCriteria("so dong", SearchOperation.EQUALITY, Integer.parseInt(so_dong)));
        searchCriteriaList.add(new SearchCriteria("ma_nhan_vien", SearchOperation.EQUALITY, ma_nhan_vien));
        searchCriteriaList.add(new SearchCriteria("ma_bac_sy", SearchOperation.EQUALITY, ma_bac_sy));
        searchCriteriaList.add(new SearchCriteria("ten_nhan_vien", SearchOperation.EQUALITY, ten_nhan_vien));
        searchCriteriaList.add(new SearchCriteria("loai_nhan_vien", SearchOperation.EQUALITY, loai_nhan_vien));
        searchCriteriaList.add(new SearchCriteria("ten_khoa", SearchOperation.EQUALITY, ten_khoa));
        searchCriteriaList.add(new SearchCriteria("ten_phong", SearchOperation.EQUALITY, ten_phong));

        return nhanVienService.getDanhSach(searchCriteriaList);
    }

    @GET
    @Path("/chitiet/{officer_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChiTiet(long officer_id) {
        return nhanVienService.getChiTiet(new SearchCriteria("org_id", SearchOperation.EQUALITY, officer_id));
    }

    @POST
    @Path("/them")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response them(NhanVienChiTiet nhanVienChiTiet) throws IllegalAccessException {
        Set<ConstraintViolation<NhanVienChiTiet>> violations = validator.validate(nhanVienChiTiet);
        if(!violations.isEmpty()) {
            String message = violations.stream().map(violation -> violation.getMessage())
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
        }

        List<PanacheEntityBase> gen = new Generator(List.of(new org_officer()), nhanVienChiTiet).generate();
        return nhanVienService.them((org_officer) gen.get(0));
    }

    @PUT
    @Path("/xoa/{officer_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response xoa(long officer_id) {
        return nhanVienService.xoa(new SearchCriteria("officer_id", SearchOperation.EQUALITY, officer_id));
    }
}
