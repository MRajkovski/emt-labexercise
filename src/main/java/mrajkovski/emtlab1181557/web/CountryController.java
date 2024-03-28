package mrajkovski.emtlab1181557.web;

import mrajkovski.emtlab1181557.models.Country;
import mrajkovski.emtlab1181557.models.dto.CountryDto;
import mrajkovski.emtlab1181557.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
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
