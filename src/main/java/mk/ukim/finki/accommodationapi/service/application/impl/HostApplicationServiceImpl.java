package mk.ukim.finki.accommodationapi.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Country;
import mk.ukim.finki.accommodationapi.model.domain.Host;
import mk.ukim.finki.accommodationapi.model.dto.CreateHostDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayHostDto;
import mk.ukim.finki.accommodationapi.service.application.HostApplicationService;
import mk.ukim.finki.accommodationapi.service.domain.CountryService;
import mk.ukim.finki.accommodationapi.service.domain.HostService;
import mk.ukim.finki.accommodationapi.web.handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    private final CountryService countryService;

    private DisplayHostDto toDto(Host host) {
        return new DisplayHostDto(
                host.getId(),
                host.getName(),
                host.getSurname(),
                host.getCountry().getName()
        );
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<DisplayHostDto> create(CreateHostDto dto) {
        Country country = countryService.findById(dto.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));

        Host host = new Host(dto.getName(), dto.getSurname(), country);
        return Optional.of(toDto(hostService.save(host)));
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto dto) {
        Host host = hostService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        Country country = countryService.findById(dto.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));

        host.setName(dto.getName());
        host.setSurname(dto.getSurname());
        host.setCountry(country);

        return Optional.of(toDto(hostService.save(host)));
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
    }
}