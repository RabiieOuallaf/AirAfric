package src.main.airportmangement.DAO.Users.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import src.main.airportmangement.DAO.Users.Abstraction.UserDaoAbstract;
import src.main.airportmangement.DAO.Users.Interfaces.AdminDaoInterface;
import org.hibernate.cfg.Configuration;
import src.main.airportmangement.DTO.Users.AdminDTO;
import src.main.airportmangement.Entities.Users.Adminstrator;
import lombok.Data;
@Data
public class AdminDAO extends UserDaoAbstract implements AdminDaoInterface {
    private SessionFactory sessionFactory;
    Transaction transaction = null;
    Session session = null;
    public AdminDAO() {
        sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public boolean signIn(AdminDTO admin) {
        session = sessionFactory.openSession();

        try{

            String hql = "FROM adminstrator a WHERE a.cin = :cin";
            Query query = session.createQuery(hql);
            query.setParameter("cin",admin.getCin());
            Adminstrator existingAdmin = (Adminstrator) query.uniqueResult();


            transaction = session.beginTransaction();

            if(existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
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
