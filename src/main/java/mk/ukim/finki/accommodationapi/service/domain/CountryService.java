package mk.ukim.finki.accommodationapi.service.domain;

import mk.ukim.finki.accommodationapi.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void deleteById(Long id);
}