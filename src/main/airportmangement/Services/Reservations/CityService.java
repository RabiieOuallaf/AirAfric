package src.main.airportmangement.Services.Reservations;

import src.main.airportmangement.DAO.Reservations.Implementation.CityDAO;
import src.main.airportmangement.Entities.Reservations.City;

import java.util.List;

public class CityService {
    public List<City> readAll() {
        CityDAO cityDAO = new CityDAO();
        List<City> cities = cityDAO.readAll();
        return cities;
    }
}
