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
public class RecipeDTOConverter implements Converter<RecipeDTO,Recipe> {

    private ConversionService conversionService;

    @Autowired
    @Lazy
    public RecipeDTOConverter(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Nullable
    @Override
    public Recipe convert(final RecipeDTO recipeDTO) {


        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(IngredientDTO.class));
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Ingredient.class));

        return Recipe.builder()
                .id(recipeDTO.getId())
                .name(recipeDTO.getName())
                .imagePath(recipeDTO.getImagePath())
                .description(recipeDTO.getDescription())
                .ingredients((List<Ingredient>) conversionService.convert(recipeDTO.getIngredients(), sourceType, targetType))
                .build();
    }
}
