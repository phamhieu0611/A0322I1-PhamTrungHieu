import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/discount")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("des");
        double price = Double.parseDouble(request.getParameter("price"));
        double percent = Double.parseDouble(request.getParameter("discount"));

        double discountAmount = price * percent * 0.01;
        double discountPrice = price * discountAmount;

        request.setAttribute("discountAmount", "Discount Amount: "+discountAmount);
        request.setAttribute("discountPrice", "Discount Price: "+discountPrice);
        request.setAttribute("descreption", "Name product: "+product);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
