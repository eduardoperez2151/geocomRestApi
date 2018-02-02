package com.geocom.converters;


import com.geocom.dtos.IngredientDTO;
import com.geocom.dtos.RecipeDTO;
import com.geocom.models.Ingredient;
import com.geocom.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationPropertiesBinding
public class RecipeConverter implements Converter<Recipe, RecipeDTO> {


    private ConversionService conversionService;

    @Autowired
    @Lazy
    public RecipeConverter(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Nullable
    @Override
    public RecipeDTO convert(final Recipe recipe) {


        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Ingredient.class));
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(IngredientDTO.class));

        return RecipeDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .imagePath(recipe.getImagePath())
                .description(recipe.getDescription())
                .ingredients((List<IngredientDTO>) conversionService.convert(recipe.getIngredients(), sourceType, targetType))
                .build();
    }
}
