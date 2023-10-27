package src.main.airportmangement.Entities.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "adminstrator")
@Table(name="adminstrator")
public class Adminstrator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int adminID;

    @Column(name ="firstname")
    @Setter
    @Getter
    private String FirstName;

    @Basic
    @Column(name = "lastname")
    @Setter
    @Getter
    private String LastName;

    @Basic
    @Column(name = "cin")
    @Setter
    @Getter
    private String cin;

    @Basic
    @Column(name = "phone")
    @Setter
    @Getter
    private String phoneNumber;

    @Basic
    @Column(name = "email")
    @Setter
    @Getter
    private String email;

    @Basic
    @Column(name = "password")
    @Setter
    @Getter
    private String password;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adminstrator admin = (Adminstrator) o;

        if (adminID != admin.adminID) return false;
        if (!Objects.equals(FirstName, admin.FirstName)) return false;
        if (!Objects.equals(LastName, admin.LastName)) return false;
        if (!Objects.equals(email, admin.email)) return false;
        if (!Objects.equals(password, admin.password)) return false;
        if (!Objects.equals(phoneNumber, admin.phoneNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminID;
        result = 31 * result + (FirstName != null ? FirstName.hashCode() : 0);
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

}