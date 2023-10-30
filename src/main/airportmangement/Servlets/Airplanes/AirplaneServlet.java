package src.main.airportmangement.Servlets.Airplanes;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Services.Airplanes.AirplaneService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Airplane", urlPatterns = {"/airplane/create", "/airplane/update/*", "/airplane/delete/*"})
public class AirplaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];

        if(action.equals("create")){

            request.getRequestDispatcher("/Airplane/create-airplane.jsp").forward(request,response);

        }else if(Objects.equals(action, "update")){
            String matricule = request.getRequestURI().split("/")[3];

            AirplaneService airplaneService = new AirplaneService();
            Airplane airplane = airplaneService.getAirplane(matricule);

            request.setAttribute("matricule",airplane.getMatricule());
            request.setAttribute("model",airplane.getModel());

            request.getRequestDispatcher("/Airplane/update-airplane.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];

        if(action.equals("create")){

            String matricule = request.getParameter("matricule");
            String model = request.getParameter("model");

            AirplaneService airplaneService = new AirplaneService();


            boolean airplaneCreated = airplaneService.createAirplane(matricule, model);

            if(airplaneCreated) {
                response.sendRedirect("/DashboardServlet");
            }else {
                response.sendRedirect("/Airplane/create-airplane.jsp");
            }


        }else if(Objects.equals(action,"update")){

            String matricule = request.getParameter("matricule");
            String model = request.getParameter("model");
            String referenceMatricule = request.getParameter("reference");

            AirplaneService airplaneService = new AirplaneService();
            boolean isAirplaneUpdated = airplaneService.updateAirplane(referenceMatricule,matricule,model);

            if(isAirplaneUpdated){
                List<Airplane> airplanes = airplaneService.readAll();

                request.setAttribute("airplanes", airplanes);
                response.sendRedirect("/Admin/Dashboard.jsp");
            }else {
                response.sendRedirect("/Airplane/update-airplane.jsp");
            }

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String airplaneMatircule = request.getRequestURI().split("/")[3];

        AirplaneService airplaneService = new AirplaneService();
        boolean isAirplaneDeleted = airplaneService.deleteAirplane(airplaneMatircule);
        if(isAirplaneDeleted) {
            List<Airplane> airplanes = airplaneService.readAll();

            request.setAttribute("airplanes", airplanes);
            response.sendRedirect("/Admin/Dashboard.jsp");
        }
    }
}