
package mk.ukim.finki.accommodationapi.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.dto.CreateCountryDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayCountryDto;
import mk.ukim.finki.accommodationapi.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    @GetMapping
    public List<DisplayCountryDto> findAll() {
        return countryApplicationService.findAll();
    }

    @PostMapping
    public ResponseEntity<DisplayCountryDto> create(@Valid @RequestBody CreateCountryDto dto) {
        return countryApplicationService.create(dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id,
                                                    @Valid @RequestBody CreateCountryDto dto) {
        return countryApplicationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}