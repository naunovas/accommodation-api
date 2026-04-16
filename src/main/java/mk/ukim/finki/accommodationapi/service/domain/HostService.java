package mk.ukim.finki.accommodationapi.service.domain;

import mk.ukim.finki.accommodationapi.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Host save(Host host);
    void deleteById(Long id);
}