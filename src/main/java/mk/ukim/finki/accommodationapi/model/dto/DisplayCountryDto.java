package mk.ukim.finki.accommodationapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DisplayCountryDto {
    private Long id;
    private String name;
    private String continent;
}