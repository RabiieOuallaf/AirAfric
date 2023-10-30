package src.main.airportmangement.Entities.Reservations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cities")
@Table(name="cities")
public class City {
    @Id
    @Column(name = "id")
    @Setter
    @Getter
    int id;

    @Column(name = "name")
    @Setter
    @Getter
    String name;

    @Column(name = "country")
    @Setter
    @Getter
    String country;

}
