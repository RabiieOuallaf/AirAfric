package src.main.airportmangement.DTO.Users;
import lombok.Data;

@Data
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String cin;
    private String password;
    private String email;
    private String phoneNumber;

    public void setClient (String firstName, String lastName, String cin, String password, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.password = password;
        this.email = email;
        this.phoneNumber = phone;
    }

    public ClientDTO getClient () {
        if (firstName == null && lastName == null && cin == null && password == null && email == null && phoneNumber == null) {
            ClientDTO client = new ClientDTO();
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setCin(cin);
            client.setPassword(password);
            client.setEmail(email);
            client.setPhoneNumber(phoneNumber);
        }
        return null;
    }

    public static class Builder {
        private ClientDTO clientDTO = new ClientDTO();

        public Builder firstName(String firstName) {
            clientDTO.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            clientDTO.lastName = lastName;
            return this;
        }

        public Builder cin(String cin) {
            clientDTO.cin = cin;
            return this;
        }

        public Builder password(String password) {
            clientDTO.password = password;
            return this;
        }

        public Builder email(String email) {
            clientDTO.email = email;
            return this;
        }

        public Builder phone(String phone) {
            clientDTO.phoneNumber = phone;
            return this;
        }

        public ClientDTO build() {
            return clientDTO;
        }
    }


}
