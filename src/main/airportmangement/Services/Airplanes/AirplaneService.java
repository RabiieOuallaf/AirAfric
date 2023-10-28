package src.main.airportmangement.Services.Airplanes;


import src.main.airportmangement.DAO.Airplanes.Implementation.AirplaneDAO;
import src.main.airportmangement.Entities.Airplanes.Airplane;

import java.util.List;

public class AirplaneService {
    public boolean createAirplane(String matricule, String model) {
        AirplaneDAO airplaneDAO = new AirplaneDAO();
        Airplane airplaneEntity = new Airplane();
        airplaneEntity.setMatricule(matricule);
        airplaneEntity.setModel(model);
        airplaneEntity.setCapacity(30);



        Airplane isAirplaneCreated = airplaneDAO.create(airplaneEntity);

        return isAirplaneCreated != null;
    }

    public boolean updateAirplane(String matricule, String model){
        AirplaneDAO airplaneDAO = new AirplaneDAO();
        Airplane airplaneEntity = new Airplane();
        airplaneEntity.setMatricule(matricule);
        airplaneEntity.setModel(model);
        airplaneEntity.setCapacity(30);


        Airplane isAirplaneUpdated = airplaneDAO.update(airplaneEntity);

        return isAirplaneUpdated!= null;
    }

    public Airplane getAirplane(String matricule){
        AirplaneDAO airplaneDAO = new AirplaneDAO();

        Airplane airplaneEntity = airplaneDAO.getAirplane(matricule);

        return airplaneEntity;
    }

    public List<Airplane> readAll(){
        AirplaneDAO airplaneDAO = new AirplaneDAO();

        List<Airplane> airplaneEntities = airplaneDAO.readAll();
        System.out.println(airplaneEntities);

        return airplaneEntities;

    }

    public boolean deleteAirplane(String matricule){
        AirplaneDAO airplaneDAO = new AirplaneDAO();

        boolean isAirplaneDeleted = airplaneDAO.delete(matricule);

        return isAirplaneDeleted;
    }


}
