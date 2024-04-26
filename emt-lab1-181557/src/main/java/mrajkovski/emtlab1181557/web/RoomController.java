package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Room;
import mrajkovski.emtlab1181557.models.dto.RoomDto;
import mrajkovski.emtlab1181557.models.enums.RoomCategory;
import mrajkovski.emtlab1181557.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Room>> getAllRooms(){
        try{
            List<Room> rooms = this.roomService.findAll();

            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @PostMapping("/add")
    public ResponseEntity<Room> save(@RequestBody RoomDto roomDto){
        try{
            return this.roomService.save(roomDto)
                    .map(room -> ResponseEntity.ok().body(room))
                    .orElseGet(()-> ResponseEntity.badRequest().build());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Room> save(@PathVariable Long id, @RequestBody RoomDto roomDto){
        try{
            return this.roomService.edit(id,roomDto)
                    .map(room -> ResponseEntity.ok().body(room))
                    .orElseGet(()-> ResponseEntity.badRequest().build());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/categories")
    public List<RoomCategory> getCategories(){
        return List.of(RoomCategory.values());
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<Room> book(@PathVariable Long id){
        try{
            return this.roomService.book(id)
                    .map(room -> ResponseEntity.ok().body(room))
                    .orElseGet(()-> ResponseEntity.badRequest().build());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Room> deleteById(@PathVariable Long id){
        this.roomService.deleteById(id);
        if(this.roomService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
