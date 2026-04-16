package mk.ukim.finki.accommodationapi.repository;

import mk.ukim.finki.accommodationapi.model.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByAccommodation_Id(Long id);
    Double findAverageRatingByAccommodationId(Long accomendationId);
}
