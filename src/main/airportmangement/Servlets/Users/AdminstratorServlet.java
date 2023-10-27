package src.main.airportmangement.Servlets.Users;

import src.main.airportmangement.DAO.Users.Implementation.AdminDao;
import src.main.airportmangement.DTO.Users.AdminDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AdminServlet", value = "/admin")
public class AdminstratorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Authentification/Login.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        String password = request.getParameter("password");

        if(isValidLogin(cin,password)){
            response.sendRedirect("dashboard.jsp");
        }else {
            request.setAttribute("message", "Invalid credentials");
            request.getRequestDispatcher("Authentification/Login.jsp").forward(request,response);
        }
    }

    private boolean isValidLogin(String CIN, String password) {
        AdminDao adminDao = new AdminDao();
        AdminDTO adminDTO = new AdminDTO.Builder()
                .cin(CIN)
                .password(password)
                .build();
        return adminDao.signIn(adminDTO);
    }

}
