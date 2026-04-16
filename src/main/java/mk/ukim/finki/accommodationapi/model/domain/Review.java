package mk.ukim.finki.accommodationapi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private String rating;

    @ManyToOne
    private Accommodation accommodation;

    public Accommodation getAccommodation(Long accomendationId) {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
