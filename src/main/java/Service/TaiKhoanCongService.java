package Service;

import BaseService.TaiKhoanCongBaseService;
import DAO.HTTaiKhoanCong;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TaiKhoanCongService {

    @Inject
    TaiKhoanCongBaseService taiKhoanCongBaseService;

    public Response GetChiTiet(Long CSYTId) {
        HTTaiKhoanCong taiKhoanCong = taiKhoanCongBaseService.GetChiTiet(CSYTId);
        return Response.status(Response.Status.OK).entity(taiKhoanCong).build();
    }

    public Response Xoa(Long CSYTId) {
        return taiKhoanCongBaseService.Xoa(CSYTId);
    }

    public Response Them(HTTaiKhoanCong taiKhoanCong) {

        int updated = taiKhoanCongBaseService.CapNhat(taiKhoanCong);

        if(updated == 0)
            taiKhoanCongBaseService.Them(taiKhoanCong);

        return Response.status(Response.Status.OK).build();
    }
}
