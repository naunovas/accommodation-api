package mk.ukim.finki.accommodationapi.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.dto.CreateHostDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayHostDto;
import mk.ukim.finki.accommodationapi.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@RequiredArgsConstructor
public class HostController {

    private final HostApplicationService hostApplicationService;

    @GetMapping
    public List<DisplayHostDto> findAll() {
        return hostApplicationService.findAll();
    }

    @PostMapping
    public ResponseEntity<DisplayHostDto> create(@Valid @RequestBody CreateHostDto dto) {
        return hostApplicationService.create(dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id,
                                                 @Valid @RequestBody CreateHostDto dto) {
        return hostApplicationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hostApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}