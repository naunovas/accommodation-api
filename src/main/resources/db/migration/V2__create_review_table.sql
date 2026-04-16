CREATE TABLE review (
                        id BIGSERIAL PRIMARY KEY,
                        comment VARCHAR(500) NOT NULL,
                        rating INT NOT NULL CHECK (rating >= 1 AND rating <= 5),
                        accommodation_id BIGINT NOT NULL REFERENCES accommodation(id) ON DELETE CASCADE
);