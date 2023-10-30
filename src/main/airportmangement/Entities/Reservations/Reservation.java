package src.main.airportmangement.Entities.Reservations;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservation")
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Basic
    @Column(name = "cin")
    @Setter
    @Getter
    String cin;

    @Basic
    @Column(name = "depatureLocation")
    @Setter
    @Getter
    String departureLocation;

    @Basic
    @Column(name = "arivalLocation")
    @Setter
    @Getter
    String arrivalLocation;

    @Basic
    @Column(name = "depaturedate")
    @Setter
    @Getter
    String departureDate;

    @Basic
    @Column(name = "arivaldate")
    @Setter
    @Getter
    String arrivalDate;

    @Basic
    @Column(name = "airplane")
    @Setter
    @Getter
    String airplane;
    @Basic
    @Column(name = "price")
    @Setter
    @Getter
    int price;

}
