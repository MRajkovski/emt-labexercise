package mrajkovski.emtlab1181557.models.dto;

import lombok.Data;

@Data
public class RoomDto {
    private String name;
    private String category;
    private int numberOfRooms;
    private Long hostId;
}
