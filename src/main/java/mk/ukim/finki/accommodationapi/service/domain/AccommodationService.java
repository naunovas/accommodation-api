package mk.ukim.finki.accommodationapi.service.domain;

import mk.ukim.finki.accommodationapi.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Accommodation save(Accommodation accommodation);
    void deleteById(Long id);
}