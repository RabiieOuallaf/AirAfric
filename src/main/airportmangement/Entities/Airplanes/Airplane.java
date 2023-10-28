package src.main.airportmangement.Entities.Airplanes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "airplane")
@Table(name = "airplane")
public class Airplane {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int airplaneID;

    @Basic
    @Column(name = "model")
    @Setter
    @Getter
    private String model;

    @Basic
    @Column(name = "matricule")
    @Setter
    @Getter
    private String matricule;

    @Basic
    @Column(name = "capacity")
    @Setter
    @Getter
    private int capacity;


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        if (airplaneID!= airplane.airplaneID) return false;
        if(!Objects.equals(model, airplane.model)) return false;
        if(!Objects.equals(matricule, airplane.matricule)) return false;
        if(!Objects.equals(capacity, airplane.capacity)) return false;

        return true;
    }

    public int hashCode() {
        int result = airplaneID;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (matricule != null ? matricule.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }
}
