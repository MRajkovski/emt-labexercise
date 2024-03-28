package mrajkovski.emtlab1181557.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mrajkovski.emtlab1181557.models.enums.RoomCategory;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private RoomCategory category;
    private int numberOfRooms;
    @ManyToOne
    private Host host;

    public Room(String name, RoomCategory category, int numberOfRooms, Host host) {
        this.name = name;
        this.category = category;
        this.numberOfRooms = numberOfRooms;
        this.host = host;
    }
}
