package src.main.airportmangement.DAO.Airplanes.Interfaces;

import src.main.airportmangement.Entities.Airplanes.Airplane;

import java.util.List;

public interface AirplaneInterface {
    public Airplane create(Airplane airplane);
    public Airplane update(Airplane airplane);
    public List<Airplane> readAll();
    public Airplane getAirplane(String matricule);
    public boolean delete(String matricule);

}
