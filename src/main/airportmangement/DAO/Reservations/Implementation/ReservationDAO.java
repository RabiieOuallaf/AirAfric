package src.main.airportmangement.DAO.Reservations.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import src.main.airportmangement.DAO.Reservations.Interfaces.ReservationInterface;
import src.main.airportmangement.Entities.Reservations.Reservation;

public class ReservationDAO implements ReservationInterface {
    private SessionFactory sessionFactory;
    private Transaction transaction;

    public ReservationDAO() {
        sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }


    @Override
    public boolean createReservation(Reservation reservation) {
        try(Session session = sessionFactory.openSession()){
            try{
                transaction = session.beginTransaction();
                session.save(reservation);
                transaction.commit();
                return true;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}
