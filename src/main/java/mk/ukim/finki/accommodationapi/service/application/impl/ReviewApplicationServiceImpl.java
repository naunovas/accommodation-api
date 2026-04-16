package mk.ukim.finki.accommodationapi.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Review;
import mk.ukim.finki.accommodationapi.model.dto.CreateReviewDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayReviewDto;
import mk.ukim.finki.accommodationapi.service.application.ReviewApplicationService;
import mk.ukim.finki.accommodationapi.service.domain.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewApplicationServiceImpl implements ReviewApplicationService {
 private final ReviewService reviewService;
 private DisplayReviewDto toDto(Review review){
     return new DisplayReviewDto(
       review.getId(),
       review.getComment(),
       review.getRating(),
       review.getAccommodation().getId()
     );
 }

    @Override
    public List<DisplayReviewDto> findAll() {
        {
            return reviewService.findAll().stream().map(this::toDto).toList();
        }
    }

    @Override
    public DisplayReviewDto findById(Long id) {
        return toDto(reviewService.findById(id));
    }

    @Override
    public DisplayReviewDto save(CreateReviewDto dto) {
        return toDto(reviewService.save(dto));
    }

    @Override
    public Double findAverageRatingByAccomendationId(Long accomendationId) {
        return reviewService.findAverageRatingByAccomendationId(accomendationId);
    }
}
