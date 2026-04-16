package mk.ukim.finki.accommodationapi.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Host;
import mk.ukim.finki.accommodationapi.repository.HostRepository;
import mk.ukim.finki.accommodationapi.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Host save(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}