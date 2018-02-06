package com.geocom.models;


import com.geocom.models.abstracts.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Ingredient extends AbstractBaseEntity<Long> {

    private Double amount;

    @Column(name="recipe_id")
    private Long recipe;

    @Builder
    public Ingredient(final Long id, final String name, final Double amount, final Long recipe) {
        super(id, name);
        this.amount = amount;
        this.recipe = recipe;
    }

}
