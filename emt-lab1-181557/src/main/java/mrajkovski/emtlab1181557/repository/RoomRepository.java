package mrajkovski.emtlab1181557.repository;

import mrajkovski.emtlab1181557.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
