package mk.ukim.finki.accommodationapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.ukim.finki.accommodationapi.model.enums.Category;
import mk.ukim.finki.accommodationapi.model.enums.State;
import mk.ukim.finki.accommodationapi.model.enums.Category;
import mk.ukim.finki.accommodationapi.model.enums.State;

@Getter
@AllArgsConstructor
public class DisplayAccommodationDto {
    private Long id;
    private String name;
    private Category category;
    private String hostFullName;
    private Integer numRooms;
    private State state;


}