package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Country;
import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.dto.CountryDto;
import mrajkovski.emtlab1181557.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Country>> getHostById(@PathVariable Long id){
        try{
            Optional<Country> country = this.countryService.getCountryById(id);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto){
        try{
            return this.countryService.save(countryDto)
                    .map(country->ResponseEntity.ok().body(country))
                    .orElseGet(()-> ResponseEntity.badRequest().build());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
