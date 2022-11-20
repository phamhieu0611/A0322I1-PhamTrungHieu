package mvc.repository.impl;

import mvc.model.LoaiThanhToan;
import mvc.model.PhongTro;
import mvc.repository.PhongTroRepository;
import mvc.utils.ConnectionUtils;
import mvc.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhongTroRepositoryImpl implements PhongTroRepository {
    @Override
    public void create(PhongTro phongTro) throws Exception {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.CREATE);
        ) {
            statement.setInt(1, phongTro.getMa_phong_tro());
            statement.setString(2, phongTro.getMa_tro());
            statement.setString(3, phongTro.getTen_nguoi_thue());
            statement.setInt(4, phongTro.getSo_dien_thoai());
            statement.setDate(5, new java.sql.Date(phongTro.getNgay_thue().getTime()));
            statement.setString(6,phongTro.getMa_thanh_toan());
            statement.setString(7, phongTro.getGhi_chu());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_BY_ID);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public PhongTro findById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String ma_tro = rs.getString("ma_tro");
                String ten_nguoi_thue = rs.getString("ten_nguoi_thue");
                int so_dien_thoai = rs.getInt("so_dien_thoai");
                Date ngay_thue = new Date(rs.getDate("ngay_thue").getTime());
                String ma_thanh_toan = rs.getString("ma_thanh_toan");
                String ghi_chu = rs.getString("ghi_chu");
                return new PhongTro(id, ma_tro, ten_nguoi_thue, so_dien_thoai, ngay_thue, ma_thanh_toan, ghi_chu);
            }
        }
        return null;
    }

    @Override
    public List<PhongTro> findAll() throws SQLException, ClassNotFoundException {
        List<PhongTro> phongTros = new ArrayList<>();
        try (
                Connection connection = ConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(Constants.FIND_ALL);
                ){
            while (rs.next()){
                int ma_phong_tro = rs.getInt("ma_phong_tro");
                String ma_tro = rs.getString("ma_phong");
                String ten_nguoi_thue = rs.getString("ten_nguoi_thue");
                int so_dien_thoai = rs.getInt("so_dien_thoai");
                Date ngay_thue = new Date(rs.getDate("ngay_thue").getTime());
                String ma_thanh_toan = rs.getString("tt.loai_thanh_toan");
                String ghi_chu = rs.getString("ghi_chu");
                phongTros.add(new PhongTro(ma_phong_tro, ma_tro, ten_nguoi_thue,so_dien_thoai, ngay_thue, ma_thanh_toan, ghi_chu));
            }
        }
        return phongTros;
    }
    public List<LoaiThanhToan> displayPaymanet(){
        List<LoaiThanhToan> loaiThanhToans =new ArrayList<>();
        try (
                Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_PAYMENT);
                ){
            while (rs.next()){
                int id =rs.getInt("ma_thanh_toan");
                String name = rs.getString("loai_thanh_toan");
                loaiThanhToans.add(new LoaiThanhToan(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loaiThanhToans;
    }
}
