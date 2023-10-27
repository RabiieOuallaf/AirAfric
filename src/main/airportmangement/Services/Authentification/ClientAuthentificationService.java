package src.main.airportmangement.Services.Authentification;


import src.main.airportmangement.DAO.Users.Implementation.ClientDAO;
import src.main.airportmangement.Entities.Users.Client;
import org.mindrot.jbcrypt.BCrypt;
public class ClientAuthentificationService {
    public boolean signIn(String cin, String password){
        ClientDAO clientDAO = new ClientDAO();
        Client clientEntity = new Client();
        clientEntity.setCin(cin);
        clientEntity.setPassword(password);

        boolean isClientSignedIn = clientDAO.signIn(clientEntity);

        if(isClientSignedIn){
            return true;
        }else {
            return false;
        }
    }
    public boolean signUp(String firstName,String lastName,String email,String password,String phone,String cin) {

        ClientDAO clientDAO = new ClientDAO();
        Client clientEntity = new Client();
        clientEntity.setFirstName("firstName");
        clientEntity.setLastName("lastName");
        clientEntity.setEmail("email");
        clientEntity.setPhoneNumber("phone");
        clientEntity.setCin("cin");

        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
        clientEntity.setPassword(hashedPassword);

        boolean isClientSignedUp = clientDAO.signUp(clientEntity);

        if(isClientSignedUp){
            return true;
        }else {
            return false;
        }



    }
}
