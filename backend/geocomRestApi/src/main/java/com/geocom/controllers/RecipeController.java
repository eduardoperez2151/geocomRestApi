package com.geocom.controllers;


import com.geocom.dtos.RecipeDTO;
import com.geocom.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeDTO>>  getAllRecipes(){
        return ResponseEntity.ok(this.recipeService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody final RecipeDTO recipeDTO){
        return ResponseEntity.ok(this.recipeService.createRecipe(recipeDTO));
    }

    @PatchMapping
    public ResponseEntity<RecipeDTO> UpdateRecipe(@RequestBody final RecipeDTO recipeDTO){
        return ResponseEntity.ok(this.recipeService.updateRecipe(recipeDTO));
    }

}
