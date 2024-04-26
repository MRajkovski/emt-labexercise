package mrajkovski.emtlab1181557.service.impl;

import mrajkovski.emtlab1181557.models.Country;
import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.dto.HostDto;
import mrajkovski.emtlab1181557.repository.CountryRepository;
import mrajkovski.emtlab1181557.repository.HostRepository;
import mrajkovski.emtlab1181557.service.HostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Host> getHostById(Long id){
        return this.hostRepository.findById(id);
    }
    @Override
    public Optional<Host> save(HostDto hostDto) throws Exception {
        Country country = this.countryRepository.findById(hostDto.getCountryId()).orElseThrow(()-> new Exception("Country not found"));

        Host host = new Host(hostDto.getName(), hostDto.getSurname(),country);

        return Optional.of(this.hostRepository.save(host));
    }
}
