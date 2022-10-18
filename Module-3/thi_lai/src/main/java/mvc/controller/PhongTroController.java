package mvc.controller;

import mvc.model.LoaiThanhToan;
import mvc.model.PhongTro;
import mvc.repository.PhongTroRepository;
import mvc.repository.impl.PhongTroRepositoryImpl;
import mvc.service.PhongTroService;
import mvc.service.impl.PhongTroServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PhongTroController", urlPatterns = "/phongtro")
public class PhongTroController extends HttpServlet {

    private PhongTroService service = new PhongTroServiceImpl();
    private PhongTroServiceImpl phongTroService = new PhongTroServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "create":
                createNew(request,response);
                break;
            default:
                doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            action = "list";
        }
        switch (action) {
            case "create":
                showTypeRentList(request,response);
                request.getRequestDispatcher("/exam/product/create.jsp").forward(request, response);
                break;
            case "delete":
                try {
                    delete(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> phongTros = null;
        try {
            phongTros = service.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("phongTros", phongTros);
        request.getRequestDispatcher("/exam/product/list.jsp").forward(request, response);
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma_tro = request.getParameter("ma_tro");
        String ten_nguoi_thue = request.getParameter("ten_nguoi_thue");
        int so_dien_thoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String ngay_thue = request.getParameter("ngay_thue");
        String ma_thanh_toan = request.getParameter("ma_thanh_toan");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ghi_chu = request.getParameter("ghi_chu");
        Date ngayThue = null;
        String error = null;
        try {
            ngayThue = format.parse(ngay_thue);
        } catch (ParseException e) {
            error = "ngay thue sai format";
        }

        if (error == null){
            try {
                service.create(new PhongTro(ma_tro, ten_nguoi_thue, so_dien_thoai, ngayThue, ma_thanh_toan, ghi_chu));
            } catch (Exception e) {
                error = e.getMessage();
            }
        }

        if (error == null){
            response.sendRedirect("/phongtro");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/exam/product/create.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteById(id);

        List<PhongTro> phongTros = service.findAll();
        request.setAttribute("phongTros", phongTros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showTypeRentList(HttpServletRequest request, HttpServletResponse response) {
        List<LoaiThanhToan> loaiThanhToans = null;
        loaiThanhToans = phongTroService.displayPaymanet();
        request.setAttribute("loaiThanhToans", loaiThanhToans);
    }
}
