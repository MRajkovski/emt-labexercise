package mrajkovski.emtlab1181557.service;


import mrajkovski.emtlab1181557.models.Room;
import mrajkovski.emtlab1181557.models.dto.RoomDto;

import java.util.Optional;

public interface RoomService {
    Optional<Room> save(RoomDto roomDto) throws Exception;

    Optional<Room> findById(Long id);

    void deleteById(Long id);
    Optional<Room> edit(Long id, RoomDto roomDto) throws Exception;
    Optional<Room> book(Long id) throws Exception;
}
