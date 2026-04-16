package mk.ukim.finki.accommodationapi.service.application;

import mk.ukim.finki.accommodationapi.model.dto.CreateAccommodationDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto> findById(Long id);
    Optional<DisplayAccommodationDto> create(CreateAccommodationDto dto);
    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto dto);
    void deleteById(Long id);
    Optional<DisplayAccommodationDto> rent(Long id);
}