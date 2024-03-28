package mrajkovski.emtlab1181557.service.impl;

import mrajkovski.emtlab1181557.models.Country;
import mrajkovski.emtlab1181557.models.dto.CountryDto;
import mrajkovski.emtlab1181557.repository.CountryRepository;
import mrajkovski.emtlab1181557.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(),countryDto.getContinent());

        return Optional.of(this.countryRepository.save(country));
    }
}
