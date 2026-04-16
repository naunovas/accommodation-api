package mk.ukim.finki.accommodationapi.repository;

import mk.ukim.finki.accommodationapi.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}