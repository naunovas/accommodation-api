package mk.ukim.finki.accommodationapi.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.accommodationapi.model.enums.Category;

@Getter
@Setter
public class CreateAccommodationDto {

    @NotBlank
    private String name;

    @NotNull
    private Category category;

    @NotNull
    private Long hostId;

    @NotNull
    @Min(1)
    private Integer numRooms;
}