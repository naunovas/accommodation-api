package mk.ukim.finki.accommodationapi.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Accommodation;
import mk.ukim.finki.accommodationapi.model.domain.Host;
import mk.ukim.finki.accommodationapi.model.enums.State;
import mk.ukim.finki.accommodationapi.model.dto.CreateAccommodationDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.accommodationapi.service.application.AccommodationApplicationService;
import mk.ukim.finki.accommodationapi.service.domain.AccommodationService;
import mk.ukim.finki.accommodationapi.service.domain.HostService;
import mk.ukim.finki.accommodationapi.web.handler.BadRequestException;
import mk.ukim.finki.accommodationapi.web.handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;

    private DisplayAccommodationDto toDto(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getName() + " " + accommodation.getHost().getSurname(),
                accommodation.getNumRooms(),
                accommodation.getState()
        );
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(this::toDto);
    }

    @Override
    public Optional<DisplayAccommodationDto> create(CreateAccommodationDto dto) {
        Host host = hostService.findById(dto.getHostId())
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        Accommodation accommodation = new Accommodation(
                dto.getName(),
                dto.getCategory(),
                host,
                dto.getNumRooms(),
                State.GOOD
        );

        return Optional.of(toDto(accommodationService.save(accommodation)));
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto dto) {
        Accommodation accommodation = accommodationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));

        Host host = hostService.findById(dto.getHostId())
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        accommodation.setName(dto.getName());
        accommodation.setCategory(dto.getCategory());
        accommodation.setHost(host);
        accommodation.setNumRooms(dto.getNumRooms());

        return Optional.of(toDto(accommodationService.save(accommodation)));
    }

    @Override
    public void deleteById(Long id) {
        Accommodation accommodation = accommodationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));

        if (accommodation.getState() != State.BAD) {
            throw new BadRequestException("Only BAD accommodations can be deleted");
        }

        accommodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> rent(Long id) {
        Accommodation accommodation = accommodationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));

        accommodation.setState(State.BAD);

        return Optional.of(toDto(accommodationService.save(accommodation)));
    }
}