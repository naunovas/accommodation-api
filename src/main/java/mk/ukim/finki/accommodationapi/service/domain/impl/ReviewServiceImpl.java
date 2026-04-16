package mk.ukim.finki.accommodationapi.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.domain.Accommodation;
import mk.ukim.finki.accommodationapi.model.domain.Review;
import mk.ukim.finki.accommodationapi.model.dto.CreateReviewDto;
import mk.ukim.finki.accommodationapi.repository.AccommodationRepository;
import mk.ukim.finki.accommodationapi.repository.ReviewRepository;
import mk.ukim.finki.accommodationapi.service.domain.ReviewService;
import mk.ukim.finki.accommodationapi.web.handler.ResourceNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
   private final ReviewRepository reviewRepository;
   private final AccommodationRepository accommodationRepository;


    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("review not found"));

    }

    @Override
    public Review save(CreateReviewDto dto) {
        Accommodation accommodation = accommodationRepository.findById(dto.getAccomendationId())
                .orElseThrow(() -> new ResourceNotFoundException("Accomendation not found"));

        Review review = new Review();
        review.setComment(dto.getComment());
        review.setRating(String.valueOf(dto.getRating()));
        review.getAccommodation(dto.getAccomendationId());

        return reviewRepository.save(review);
    }

    @Override
    public Double findAverageRatingByAccomendationId(Long accomendationId) {
        Double avg = reviewRepository.findAverageRatingByAccommodationId(accomendationId);
        return avg != null ? avg : 0.0;
    }
}
