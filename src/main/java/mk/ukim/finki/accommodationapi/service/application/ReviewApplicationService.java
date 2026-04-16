package mk.ukim.finki.accommodationapi.service.application;

import mk.ukim.finki.accommodationapi.model.dto.CreateReviewDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayReviewDto;

import java.util.List;

public interface ReviewApplicationService {
    List<DisplayReviewDto> findAll();
    DisplayReviewDto findById(Long id);
    DisplayReviewDto save(CreateReviewDto dto);
    Double findAverageRatingByAccomendationId(Long  accomendationId);

}
