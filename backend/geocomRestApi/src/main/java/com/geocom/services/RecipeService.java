package com.geocom.services;

import com.geocom.dtos.RecipeDTO;

import java.util.List;

public interface RecipeService {

    RecipeDTO createRecipe(final RecipeDTO recipeDTO);
    RecipeDTO updateRecipe(final RecipeDTO recipeDTO);
    List<RecipeDTO> getAllRecipes();
    RecipeDTO getRecipeById(final Long id);
}
