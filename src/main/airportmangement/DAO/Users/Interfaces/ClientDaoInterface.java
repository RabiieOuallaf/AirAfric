package src.main.airportmangement.DAO.Users.Interfaces;

import src.main.airportmangement.Entities.Users.Client;

public interface ClientDaoInterface {
    boolean signIn(Client client);
    boolean signUp(Client client);
}
