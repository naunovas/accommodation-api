package mk.ukim.finki.accommodationapi.repository;

import mk.ukim.finki.accommodationapi.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}