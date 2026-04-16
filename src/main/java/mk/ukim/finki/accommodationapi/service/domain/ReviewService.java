package mk.ukim.finki.accommodationapi.service.domain;

import mk.ukim.finki.accommodationapi.model.domain.Review;
import mk.ukim.finki.accommodationapi.model.dto.CreateReviewDto;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findById(Long id);
    Review save(CreateReviewDto dto);

    Double findAverageRatingByAccomendationId(Long accomendationId);

}
