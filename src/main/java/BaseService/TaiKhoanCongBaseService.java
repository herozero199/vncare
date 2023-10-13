package BaseService;

import DAO.HTTaiKhoanCong;
import Repository.TaiKhoanCongRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TaiKhoanCongBaseService {

    @Inject
    TaiKhoanCongRepository taiKhoanCongRepository;

    public HTTaiKhoanCong GetChiTiet(Long CSYTId) {
        return taiKhoanCongRepository.GetChiTiet(CSYTId);
    }

    public Response Xoa(Long CSYTId) {
        int deleted = taiKhoanCongRepository.Xoa(CSYTId);
        if(deleted == 0)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.status(Response.Status.OK).build();
    }

    public void Them(HTTaiKhoanCong taiKhoanCong) {
        taiKhoanCongRepository.Them(taiKhoanCong);
    }

    public int CapNhat(HTTaiKhoanCong taiKhoanCong) {
        return taiKhoanCongRepository.Update(taiKhoanCong);
    }
}
