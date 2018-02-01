package com.geocom.dtos;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String name;
    private String imagePath;
    private String description;
    private List<IngredientDTO> ingredients;
}
