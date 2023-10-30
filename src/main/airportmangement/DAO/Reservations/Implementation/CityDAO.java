package src.main.airportmangement.DAO.Reservations.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import src.main.airportmangement.DAO.Reservations.Interfaces.CityInterface;
import src.main.airportmangement.Entities.Airplanes.Airplane;
import src.main.airportmangement.Entities.Reservations.City;

import java.util.ArrayList;
import java.util.List;

public class CityDAO implements CityInterface {
    private SessionFactory sessionFactory;
    private Transaction transaction;

    public CityDAO() {
        sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }


    @Override
    public List<City> readAll() {
        try(Session session = sessionFactory.openSession()) {
            try{
                transaction = session.beginTransaction();
                Query query = session.createQuery("FROM cities");
                List<City> cities = query.getResultList();
                transaction.commit();

                if(!cities.isEmpty()){
                    return cities;
                }else {
                    return new ArrayList<>();
                }

            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }

    }
}
