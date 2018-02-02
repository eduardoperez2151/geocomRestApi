package com.geocom.controllers;


import com.geocom.dtos.RecipeDTO;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<ResponseAPI> getAllRecipes() {
        final List<RecipeDTO> allRecipes = this.recipeService.getAllRecipes();
        final ResponseAPI responseAPI = ResponseAPI.ok(allRecipes);
        return ResponseEntity.ok(responseAPI);
    }

    @PostMapping
    public ResponseEntity<ResponseAPI> createRecipe(@RequestBody final RecipeDTO recipeDTO) {
        final RecipeDTO recipe = this.recipeService.createRecipe(recipeDTO);
        final ResponseAPI responseAPI = ResponseAPI.ok(recipe);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseAPI);
    }

    @PatchMapping
    public ResponseEntity<ResponseAPI> UpdateRecipe(@RequestBody final RecipeDTO recipeDTO) {
        final RecipeDTO recipe = this.recipeService.updateRecipe(recipeDTO);
        final ResponseAPI responseAPI = ResponseAPI.ok(recipe);
        return ResponseEntity.ok(responseAPI);
    }

}
