package com.geocom.models;

import com.geocom.models.abstracts.AbstractBaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="recipe")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Recipe extends AbstractBaseEntity<Long> {

    private String imagePath;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id", referencedColumnName="id")
    List<Ingredient> ingredients;


    @Builder
    public Recipe(final Long id, final String name, final String imagePath, final String description, final List<Ingredient> ingredients) {
        super(id, name);
        this.imagePath = imagePath;
        this.description = description;
        this.ingredients = ingredients;
    }
}
