package mrajkovski.emtlab1181557.service;


import mrajkovski.emtlab1181557.models.Host;
import mrajkovski.emtlab1181557.models.dto.HostDto;

import java.util.Optional;

public interface HostService {
    Optional<Host> getHostById(Long id);
    Optional<Host> save(HostDto hostDto) throws Exception;
}
