package src.main.airportmangement.DAO.Users.Abstraction;
import lombok.Data;
@Data
public abstract class UserDaoAbstract {
    public String FirstName;
    public String LastName;
    public String CIN;
    public String Email;
    public String PhoneNumber;

}
