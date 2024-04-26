package mrajkovski.emtlab1181557.service;


import mrajkovski.emtlab1181557.models.Country;
import mrajkovski.emtlab1181557.models.dto.CountryDto;

import java.util.Optional;

public interface CountryService {
    Optional<Country> getCountryById(Long id);
    Optional<Country> save(CountryDto countryDto);
}
