package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.dto.HostDto;
import mrajkovski.emtlab1181557.service.HostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Host>> getHostById(@PathVariable Long id){
        try{
            Optional<Host> host = this.hostService.getHostById(id);
            return new ResponseEntity<>(host, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Host> save(@RequestBody HostDto hostDto){
        try{
            return this.hostService.save(hostDto)
                    .map(host -> ResponseEntity.ok().body(host))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
