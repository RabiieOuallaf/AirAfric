package src.main.airportmangement.DAO.Users.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import src.main.airportmangement.DAO.Users.Abstraction.UserDaoAbstract;
import src.main.airportmangement.DAO.Users.Interfaces.ClientDaoInterface;
import src.main.airportmangement.DTO.Users.ClientDTO;
import org.hibernate.cfg.Configuration;
import src.main.airportmangement.Entities.Users.Client;

public class ClientDAO extends UserDaoAbstract implements ClientDaoInterface {
    private SessionFactory sessionFactory;
    Transaction transaction = null;
    Session session = null;

    public ClientDAO() {
        sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }


    @Override
    public boolean signIn(Client client) {
        try(Session session = sessionFactory.openSession()){
            try {
                transaction = session.beginTransaction();
                Client existingClient = session.find(Client.class, client.getCin());
                if (existingClient != null) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }finally {
                transaction.commit();
            }
        }
    }

    @Override
    public boolean signUp(Client client) {
        try (Session session = sessionFactory.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.save(client);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return false;
    }
}
