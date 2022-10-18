package mvc.utils;

public interface Constants {
    String CREATE = "insert into phongtro values(?,?,?,?,?,?,?)";
    String DELETE_BY_ID = "delete from phongtro where ma_phong_tro = ?";
    String FIND_BY_ID = "select * from phongtro where ma_phong_tro = ?";
    String SELECT_PAYMENT = "select * from thanhtoan";
    String FIND_ALL = "select ma_phong_tro, ma_phong, ten_nguoi_thue, so_dien_thoai, ngay_thue, tt.loai_thanh_toan, ghi_chu from phongtro pt join thanhtoan tt on pt.ma_thanh_toan = tt.ma_thanh_toan";
}
