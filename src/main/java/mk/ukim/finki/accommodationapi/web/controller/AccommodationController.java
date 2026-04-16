package mk.ukim.finki.accommodationapi.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.dto.CreateAccommodationDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.accommodationapi.service.application.AccommodationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationApplicationService accommodationApplicationService;

    @GetMapping
    public List<DisplayAccommodationDto> findAll() {
        return accommodationApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisplayAccommodationDto> create(@Valid @RequestBody CreateAccommodationDto dto) {
        return accommodationApplicationService.create(dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> update(@PathVariable Long id,
                                                          @Valid @RequestBody CreateAccommodationDto dto) {
        return accommodationApplicationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accommodationApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<DisplayAccommodationDto> rent(@PathVariable Long id) {
        return accommodationApplicationService.rent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}