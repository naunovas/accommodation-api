package mk.ukim.finki.accommodationapi.model.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class DisplayReviewDto {
    
    private Long id;
    private String comment;
    private Integer rating;
    private Long accomendtaionId;

    public DisplayReviewDto(Long id, String comment, String rating, Long id1) {
    }
}
