package src.main.airportmangement.Servlets.Users;

import src.main.airportmangement.DAO.Users.Implementation.AdminDao;
import src.main.airportmangement.DTO.Users.AdminDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

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
