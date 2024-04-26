package mrajkovski.emtlab1181557.service.impl;

import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.Room;
import mrajkovski.emtlab1181557.models.dto.RoomDto;
import mrajkovski.emtlab1181557.models.enums.RoomCategory;
import mrajkovski.emtlab1181557.repository.HostRepository;
import mrajkovski.emtlab1181557.repository.RoomRepository;
import mrajkovski.emtlab1181557.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HostRepository hostRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HostRepository hostRepository) {
        this.roomRepository = roomRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public Optional<Room> save(RoomDto roomDto) throws Exception {
        Host host = this.hostRepository.findById(roomDto.getHostId()).orElseThrow(()-> new Exception("Host not found"));

        Room room = new Room(
                roomDto.getName(),
                RoomCategory.valueOf(roomDto.getCategory()),
                roomDto.getNumberOfRooms(),
                host
        );

        return Optional.of(this.roomRepository.save(room));
    }

    @Override
    public List<Room> findAll(){
        return this.roomRepository.findAll();
    }
    @Override
    public Optional<Room> findById(Long id) {
        return this.roomRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.roomRepository.deleteById(id);
    }

    @Override
    public Optional<Room> edit(Long id, RoomDto roomDto) throws Exception {
        Room room = this.roomRepository.findById(id).orElseThrow(()-> new Exception("Room not found"));
        room.setName(roomDto.getName());
        room.setCategory(RoomCategory.valueOf(roomDto.getCategory()));
        room.setNumberOfRooms(roomDto.getNumberOfRooms());

        Host host = this.hostRepository.findById(roomDto.getHostId()).orElseThrow(()-> new Exception("Host not found"));
        room.setHost(host);

        return Optional.of(this.roomRepository.save(room));
    }

    @Override
    public Optional<Room> book(Long id) throws Exception {
        Room room = this.roomRepository.findById(id).orElseThrow(()-> new Exception("Room not found"));

        if(room.getNumberOfRooms() == 0){
            throw new Exception("No available rooms");
        }

        room.setNumberOfRooms(room.getNumberOfRooms() - 1);

        return Optional.of(this.roomRepository.save(room));
    }
}
