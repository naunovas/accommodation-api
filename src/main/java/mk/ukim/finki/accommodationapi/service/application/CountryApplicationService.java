package mk.ukim.finki.accommodationapi.service.application;

import mk.ukim.finki.accommodationapi.model.dto.CreateCountryDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> create(CreateCountryDto dto);
    Optional<DisplayCountryDto> update(Long id, CreateCountryDto dto);
    void deleteById(Long id);
}