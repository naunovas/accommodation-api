package mk.ukim.finki.accommodationapi.service.application;

import mk.ukim.finki.accommodationapi.model.dto.CreateHostDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> create(CreateHostDto dto);
    Optional<DisplayHostDto> update(Long id, CreateHostDto dto);
    void deleteById(Long id);
}