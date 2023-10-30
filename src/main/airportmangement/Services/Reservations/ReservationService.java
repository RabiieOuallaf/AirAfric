package src.main.airportmangement.Services.Reservations;

import src.main.airportmangement.DAO.Reservations.Implementation.ReservationDAO;
import src.main.airportmangement.Entities.Reservations.Reservation;

public class ReservationService {
    public boolean createReservation(String cin, String depature, String arrival, String departureDate, String ArrivalDate, int Weight, String airplane){

        int addionalWeight = Weight - 10;
        int addtionalPrice = addionalWeight * 25;
        int price = 150 + addtionalPrice;

        ReservationDAO reservationDAO = new ReservationDAO();
        Reservation reservation = new Reservation();
        reservation.setCin(cin);
        reservation.setDepartureLocation(depature);
        reservation.setArrivalLocation(arrival);
        reservation.setDepartureDate(departureDate);
        reservation.setArrivalDate(ArrivalDate);
        reservation.setPrice(price);
        reservation.setAirplane(airplane);  

        return reservationDAO.createReservation(reservation);

    }
}
