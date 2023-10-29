package src.main.airportmangement.Servlets.Airplanes;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Services.Airplanes.AirplaneService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AirplaneService airplaneService = new AirplaneService();

        List<Airplane> airplanes = airplaneService.readAll();

        request.setAttribute("airplanes", airplanes);
        request.getRequestDispatcher("Admin/Dashboard.jsp").forward(request,response);
    }

}