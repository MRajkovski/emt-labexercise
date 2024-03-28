package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.dto.HostDto;
import mrajkovski.emtlab1181557.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
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
