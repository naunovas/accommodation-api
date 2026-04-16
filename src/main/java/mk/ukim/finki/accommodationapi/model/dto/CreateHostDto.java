package mk.ukim.finki.accommodationapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateHostDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    private Long countryId;
}