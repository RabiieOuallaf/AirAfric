package src.main.airportmangement.DAO.Reservations.Interfaces;

import src.main.airportmangement.Entities.Reservations.City;

import java.util.List;

public interface CityInterface {
    public List<City> readAll();
}
