package src.main.airportmangement.Servlets.Resrevations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Entities.Reservations.City;
import src.main.airportmangement.Services.Airplanes.AirplaneService;
import src.main.airportmangement.Services.Reservations.CityService;
import src.main.airportmangement.Services.Reservations.ReservationService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResrevationServlet", value = "/main")
public class ResrevationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityService cityService = new CityService();
        List<City> cities = cityService.readAll();

        AirplaneService airplaneService = new AirplaneService();
        List<Airplane> airplanes = airplaneService.readAll();

        request.setAttribute("airplanes", airplanes);
        request.setAttribute("cities", cities);

        request.getRequestDispatcher("resrevation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin = request.getParameter("cin");
        String depature = request.getParameter("depature");
        String arrival = request.getParameter("arrival");
        String departureDate = request.getParameter("departureDate");
        String arrivalDate = request.getParameter("ArrivalDate");
        int Weight = Integer.parseInt(request.getParameter("Weight"));
        String airplane = request.getParameter("airplane");

        ReservationService reservationService = new ReservationService();
        boolean isReservationCreated = reservationService.createReservation(cin, depature,arrival,departureDate,arrivalDate,Weight,airplane);
        if(isReservationCreated){
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }
    }
}