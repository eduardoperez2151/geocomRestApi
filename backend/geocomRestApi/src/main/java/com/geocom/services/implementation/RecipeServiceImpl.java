package com.geocom.services.implementation;

import com.geocom.dtos.RecipeDTO;
import com.geocom.models.Recipe;
import com.geocom.repositories.RecipeRepository;
import com.geocom.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private ConversionService conversionService;

    @Autowired
    public RecipeServiceImpl(final RecipeRepository recipeRepository, final ConversionService conversionService) {
        this.recipeRepository = recipeRepository;
        this.conversionService = conversionService;
    }

    @Override
    public RecipeDTO createRecipe(final RecipeDTO recipeDTO) {
        final Recipe recipe = this.conversionService.convert(recipeDTO, Recipe.class);
        final Recipe persistedRecipe = this.recipeRepository.save(recipe);
        return conversionService.convert(persistedRecipe, RecipeDTO.class);
    }

    @Override
    public RecipeDTO updateRecipe(final RecipeDTO recipeDTO) {
        this.getRecipeById(recipeDTO.getId());
        final Recipe recipe = conversionService.convert(recipeDTO, Recipe.class);
        final Recipe updatedRecipe = this.recipeRepository.save(recipe);
        return conversionService.convert(updatedRecipe,RecipeDTO.class);
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Recipe.class));
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RecipeDTO.class));
        final List<Recipe> recipes = this.recipeRepository.findAll();
        return (List<RecipeDTO>) conversionService.convert(recipes, sourceType, targetType);
    }

    private Recipe getRecipeById(final Long id) {
        final Optional<Recipe> recipeOptional = this.recipeRepository.findById(id);
        return recipeOptional.orElseThrow(() -> new EntityNotFoundException(String.format("La receta con id %s no existe", id)));
    }

}
