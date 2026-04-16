package mk.ukim.finki.accommodationapi.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import mk.ukim.finki.accommodationapi.model.enums.Category;
import mk.ukim.finki.accommodationapi.model.enums.State;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Host host;

    @Column(name = "num_rooms")
    private Integer numRooms;

    @Enumerated(EnumType.STRING)
    private State state;

    public Accommodation(@NotBlank String name, Category category, Host host, @NotNull @Min(1) Integer numRooms, State state) {
    }



    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}