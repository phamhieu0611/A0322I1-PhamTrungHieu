package mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletController")
public class ServletController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null || action.trim().equals("")){
            doGet(request, response);
            return;
        }
        switch (action){
            case "create":
                createNew(request, response);
                break;
            case "update":
                try{
                    updateEdit(request, response);
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")){
            doGet(request, response);
            return;
        }
        switch (action){
            case "create":
                showType(request, response);
                request.getRequestDispatcher("/WEB-INF/views/soMot/create.jsp").forward(request, response);
                break;
            case "update":
                showType(request, response);
                try{
                    showEditUpdate(request, response);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteDAT(request, response);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "detail":
                try {
                    detailDAT(request, response);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailDAT(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteDAT(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showType(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
    }
}
