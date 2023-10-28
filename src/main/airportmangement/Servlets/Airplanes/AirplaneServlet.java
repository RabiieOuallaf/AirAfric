package src.main.airportmangement.Servlets.Airplanes;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Services.Airplanes.AirplaneService;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Airplane", urlPatterns = {"/airplane/create", "/airplane/update", "/airplane/delete"})
public class AirplaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];

        if(action.equals("create")){
            request.getRequestDispatcher("/Airplane/create-airplane.jsp").forward(request,response);

        }else if(Objects.equals(action, "update")){
            String matricule = request.getParameter("matricule");

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
                response.sendRedirect("/Admin/Dashboard");
            }else {
                response.sendRedirect("/Airplane/create-airplane.jsp");
            }


        }else if(Objects.equals(action,"update")){

            String matricule = request.getParameter("matricule");
            String model = request.getParameter("model");

            AirplaneService airplaneService = new AirplaneService();
            boolean isAirplaneUpdated = airplaneService.updateAirplane(matricule,model);

            if(isAirplaneUpdated){
                response.sendRedirect("/Admin/Dashboard");
            }else {
                response.sendRedirect("/Airplane/update-airplane.jsp");
            }

        }
    }
}