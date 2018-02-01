package com.geocom.dtos;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Long id;
    private String name;
    private Double amount;
    private Long recipe;

    public IngredientDTO(final String name, final Double amount) {
        this.name = name;
        this.amount = amount;
    }
}
