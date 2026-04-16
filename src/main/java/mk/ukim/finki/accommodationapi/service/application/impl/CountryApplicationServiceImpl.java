package mk.ukim.finki.accommodationapi.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Country;
import mk.ukim.finki.accommodationapi.model.dto.CreateCountryDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayCountryDto;
import mk.ukim.finki.accommodationapi.service.application.CountryApplicationService;
import mk.ukim.finki.accommodationapi.service.domain.CountryService;
import mk.ukim.finki.accommodationapi.web.handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    private DisplayCountryDto toDto(Country country) {
        return new DisplayCountryDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<DisplayCountryDto> create(CreateCountryDto dto) {
        Country country = new Country(dto.getName(), dto.getContinent());
        return Optional.of(toDto(countryService.save(country)));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto dto) {
        Country country = countryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));

        country.setName(dto.getName());
        country.setContinent(dto.getContinent());

        return Optional.of(toDto(countryService.save(country)));
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }
}