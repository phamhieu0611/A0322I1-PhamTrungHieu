import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operator = request.getParameter("operator");
        double so1 = Double.parseDouble(request.getParameter("so1"));
        double so2 = Double.parseDouble(request.getParameter("so2"));
        double result = 0;

        switch (operator){
            case "+":
                result = so1 + so2;
                break;
            case "-":
                result = so1 - so2;
                break;
            case "*":
                result = so1 * so2;
                break;
            case "/":
                result = so1 / so2;
                break;
        }
        request.setAttribute("result","Kết quả là "+result);
        request.getRequestDispatcher("count.jsp").forward(request,response);
    }
}
