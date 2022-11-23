package com.example.swaggerguide.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.swaggerguide.model.Pet} entity
 */
public class PetBasicDto implements Serializable {
    private final Long id;
    private final Long userId;
    private final String name;

    public PetBasicDto(Long id,
                       Long userId,
                       String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public Long getId() {return id;}

    public Long getUserId() {return userId;}

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PetBasicDto entity = (PetBasicDto) o;
        return Objects.equals(this.id, entity.id) && Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id = " + id + ", " + "userId = " + userId + ";";
    }
}