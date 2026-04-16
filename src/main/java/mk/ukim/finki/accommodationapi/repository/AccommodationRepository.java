package mk.ukim.finki.accommodationapi.repository;

import mk.ukim.finki.accommodationapi.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}