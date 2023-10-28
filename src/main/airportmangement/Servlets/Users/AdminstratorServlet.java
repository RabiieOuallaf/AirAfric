package src.main.airportmangement.Servlets.Users;

import jakarta.servlet.http.HttpSession;
import src.main.airportmangement.DAO.Users.Implementation.AdminDAO;
import src.main.airportmangement.DTO.Users.AdminDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Services.Airplanes.AirplaneService;

import java.io.IOException;
import java.util.List;

@WebServlet(name="AdminServlet", value = "/admin")
public class AdminstratorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isActive = (boolean) session.getAttribute("Active");

        if(isActive){

            AirplaneService airplaneService = new AirplaneService();
            List<Airplane> airplanes = airplaneService.readAll();

            request.setAttribute("airplanes", airplanes);
            request.getRequestDispatcher("Admin/Dashboard.jsp").forward(request,response);
        }

        request.getRequestDispatcher("Admin/Login.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        String password = request.getParameter("password");

        if(isValidLogin(cin,password)){
            HttpSession session = request.getSession();
            session.setAttribute("Active", true);

            response.sendRedirect("Admin/Dashboard.jsp");
        }else {
            request.setAttribute("message", "Invalid credentials");
            request.getRequestDispatcher("Admin/Login.jsp").forward(request,response);
        }
    }

    private boolean isValidLogin(String CIN, String password) {
        AdminDAO adminDao = new AdminDAO();
        AdminDTO adminDTO = new AdminDTO.Builder()
                .cin(CIN)
                .password(password)
                .build();
        return adminDao.signIn(adminDTO);
    }

}
