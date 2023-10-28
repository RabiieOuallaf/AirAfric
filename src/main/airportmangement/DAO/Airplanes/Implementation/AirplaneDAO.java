package src.main.airportmangement.DAO.Airplanes.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import src.main.airportmangement.DAO.Airplanes.Abstraction.AirplaneAbstract;
import src.main.airportmangement.DAO.Airplanes.Interfaces.AirplaneInterface;
import src.main.airportmangement.Entities.Airplanes.Airplane;

import java.util.List;

public class AirplaneDAO extends AirplaneAbstract implements AirplaneInterface {
    private SessionFactory sessionFactory;
    private Transaction transaction;

    public AirplaneDAO() {
        sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public Airplane create(Airplane airplane) {
        Airplane existingAirplane = getAirplane(airplane.getMatricule());
        if(existingAirplane == null) {
            try(Session session = sessionFactory.openSession()) {
                try{
                    transaction = session.beginTransaction();
                    System.out.println(airplane);
                    session.save(airplane);
                    transaction.commit();
                    return airplane;
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }else {
            return null;
        }
    }

    @Override
    public Airplane update(Airplane airplane) {

        Airplane existingAirplane = getAirplane(airplane.getModel());
        if(existingAirplane != null){
            try(Session session = sessionFactory.openSession()) {
                try{
                    transaction = session.beginTransaction();
                    session.update(airplane);
                    transaction.commit();
                    return airplane;
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }else {
            return null;
        }
    }

    @Override
    public List<Airplane> readAll() {
        try(Session session = sessionFactory.openSession()) {
            try{
                transaction = session.beginTransaction();
                List<Airplane> airplanes = session.createQuery("FROM airplane", Airplane.class).list();
                transaction.commit();
                return airplanes;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Airplane getAirplane(String matricule) {
        try(Session session = sessionFactory.openSession()) {
            try{
                transaction = session.beginTransaction();
                Airplane exisitingAirplane = session.createQuery("FROM airplane WHERE matricule = :matricule", Airplane.class)
                        .setParameter("matricule", matricule)
                        .uniqueResult();
                transaction.commit();
                return exisitingAirplane;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean delete(String matricule) {
        Airplane existingAirplane = getAirplane(matricule);
        if (existingAirplane != null) {
            try (Session session = sessionFactory.openSession()) {
                try {
                    transaction = session.beginTransaction();
                    session.delete(existingAirplane);
                    transaction.commit();
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            return false;
        }
    }
}
