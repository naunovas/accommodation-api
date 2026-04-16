package mk.ukim.finki.accommodationapi.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.accommodationapi.model.enums.Category;

@Data
public class UpdateAccommodationDto {

    @NotBlank
    private String name;

    @NotNull
    private Category category;

    @NotNull
    private Long hostId;

    @Min(1)
    private Integer numRooms;
}