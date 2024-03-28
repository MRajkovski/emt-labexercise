package mrajkovski.emtlab1181557.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Host {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
