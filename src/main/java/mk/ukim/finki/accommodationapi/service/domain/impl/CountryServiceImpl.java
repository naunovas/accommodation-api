package mk.ukim.finki.accommodationapi.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Country;
import mk.ukim.finki.accommodationapi.repository.CountryRepository;
import mk.ukim.finki.accommodationapi.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}