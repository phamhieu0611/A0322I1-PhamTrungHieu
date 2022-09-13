package controller;
import model.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://icdn.dantri.com.vn/thumb_w/660/2021/10/30/trang-nhungdocx-1635528230350.jpeg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://icdn.dantri.com.vn/thumb_w/660/2021/10/30/trang-nhungdocx-1635528230350.jpeg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam ĐỊnh", "https://icdn.dantri.com.vn/thumb_w/660/2021/10/30/trang-nhungdocx-1635528230350.jpeg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://icdn.dantri.com.vn/thumb_w/660/2021/10/30/trang-nhungdocx-1635528230350.jpeg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://icdn.dantri.com.vn/thumb_w/660/2021/10/30/trang-nhungdocx-1635528230350.jpeg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("view/list.jsp").forward(request,response);
    }
}
