package com.geocom.converters;


import com.geocom.dtos.IngredientDTO;
import com.geocom.models.Ingredient;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class IngredientDTOConverter implements Converter< IngredientDTO,Ingredient> {

    @Nullable
    @Override
    public Ingredient convert(final IngredientDTO  ingredientDTO) {
        return Ingredient.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .amount(ingredientDTO.getAmount())
                .recipe(ingredientDTO.getRecipe())
                .build();
    }
}
