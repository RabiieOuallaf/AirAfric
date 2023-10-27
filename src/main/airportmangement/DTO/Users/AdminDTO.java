package src.main.airportmangement.DTO.Users;
import lombok.Data;

@Data

public class AdminDTO {
    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String phoneNumber;
    private String password;


    public void setAdmin(String firstName,String lastName,String cin,String email,String phoneNumber,String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }

    public AdminDTO getAdmin() {
        if(this.firstName != null && lastName != null && cin != null && email != null && phoneNumber != null && password != null){
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setFirstName(this.firstName);
            adminDTO.setLastName(this.lastName);
            adminDTO.setCin(this.cin);
            adminDTO.setEmail(this.email);
            adminDTO.setPhoneNumber(this.phoneNumber);
            adminDTO.setPassword(this.password);
            return adminDTO;
        };
        return null;
    }

    public static class Builder {
        private AdminDTO adminDTO = new AdminDTO();

        public Builder firstName(String FirstName) {
            adminDTO.firstName = FirstName;
            return this;
        }
        public Builder lastName(String LastName){
            adminDTO.lastName = LastName;
            return this;
        }
        public Builder cin(String cin){
            adminDTO.cin = cin;
            return this;
        }
        public Builder email(String email) {
            adminDTO.email = email;
            return this;
        }
        public Builder phoneNumber(String phoneNumber) {
            adminDTO.phoneNumber = phoneNumber;
            return this;
        }
        public Builder password(String password) {
            adminDTO.password = password;
            return this;
        }

        public AdminDTO build() {
            return adminDTO;
        }

    }

}
