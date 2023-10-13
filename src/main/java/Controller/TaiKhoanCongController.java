package Controller;

import DAO.HTTaiKhoanCong;
import Service.TaiKhoanCongService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("taikhoancong")
public class TaiKhoanCongController {

    @Inject
    TaiKhoanCongService taiKhoanCongService;

    @GET
    @Path("chitiet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetChiTiet(Long CSYTId) {
        return taiKhoanCongService.GetChiTiet(CSYTId);
    }

    @PUT
    @Path("xoa")
    public Response Xoa(Long CSYTId) {
        return taiKhoanCongService.Xoa(CSYTId);
    }

    @POST
    @Path("them")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Them(HTTaiKhoanCong taiKhoanCong) {
        return taiKhoanCongService.Them(taiKhoanCong);
    }
}
