package mk.ukim.finki.accommodationapi.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Accommodation;
import mk.ukim.finki.accommodationapi.repository.AccommodationRepository;
import mk.ukim.finki.accommodationapi.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}