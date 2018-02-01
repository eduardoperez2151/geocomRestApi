package com.geocom.converters;


import com.geocom.dtos.IngredientDTO;
import com.geocom.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class IngredientConverter implements Converter<Ingredient, IngredientDTO> {



    @Nullable
    @Override
    public IngredientDTO convert(final Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .amount(ingredient.getAmount())
                .recipe(ingredient.getRecipe())
                .build();
    }
}
