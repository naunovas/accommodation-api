package mk.ukim.finki.accommodationapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCountryDto {

    @NotBlank
    private String name;

    @NotBlank
    private String continent;
}