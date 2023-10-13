package Controller;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOfficer;
import DAO.OrgOrganization;
import Generator.Generator;
import Service.NhanVienService;
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

@Path("nhanvien")
public class NhanVienController {

    @Inject
    NhanVienService nhanVienService;

    @Inject
    Validator validator;


    @Path("danhsach")
    @GET
    public Response GetDanhSach(@QueryParam(value= "trang") Integer trang, @QueryParam(value= "sodong") Integer sodong, @QueryParam(value= "search") String search,
                                @QueryParam(value= "Order") String order) {
        if(sodong == null) sodong = 20;
        if(trang == null) trang = 0;
        return nhanVienService.GetDanhSach(trang, sodong, search, order);
    }

    @Path("chitiet/{OrgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetChiTiet(long OfficerId) {
        return nhanVienService.GetChiTiet(OfficerId);
    }

    @Path("them")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Them(OrgOfficer nhanVien) throws IllegalAccessException {
        Set<ConstraintViolation<OrgOfficer>> validation_org =  validator.validate(nhanVien);
        if(!validation_org.isEmpty()) {
            String violations = validation_org.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }

        return nhanVienService.them(nhanVien);
    }

    @Path("xoa/{OrgId}")
    @PUT
    public Response Xoa(long OrgId) {
        return nhanVienService.Xoa(OrgId);
    }
}
