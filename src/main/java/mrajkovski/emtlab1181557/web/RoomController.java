package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Room;
import mrajkovski.emtlab1181557.models.dto.RoomDto;
import mrajkovski.emtlab1181557.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
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
