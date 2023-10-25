package src.main.airportmangement.DAO.Users.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import src.main.airportmangement.DAO.Users.Abstraction.UserDaoAbstract;
import src.main.airportmangement.DAO.Users.Interfaces.AdminDaoInterface;
import org.hibernate.cfg.Configuration;
import src.main.airportmangement.DTO.Users.AdminDTO;
import src.main.airportmangement.Entities.Users.Admin;
import lombok.Data;
@Data
public class AdminDao extends UserDaoAbstract implements AdminDaoInterface {
    private SessionFactory sessionFactory;
    Transaction transaction = null;
    Session session = null;
    private String Password;
    public AdminDao() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public boolean signIn(AdminDTO admin) {
        session = sessionFactory.openSession();

        Admin existingAdmin = (Admin) session.createQuery("FROM * adminstrator WHERE CIN = :cin")
                .setParameter("cin", this.getCIN())
                .uniqueResult();
        try{
            transaction = session.beginTransaction();

            if(existingAdmin != null && existingAdmin.getPassword().equals(this.getPassword())) {
                transaction.commit();
                return true;
            }else {
                return false;
            }
        }catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }

    }
}
