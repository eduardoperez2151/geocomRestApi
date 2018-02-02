package com.geocom.controllers;


import com.geocom.dtos.RecipeDTO;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.RecipeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "GeoCom Recipe services", produces = "application/json")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ApiOperation(value = "Get all recipes", notes = "Recipe Service", nickname = "getAllRecipes")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping
    public ResponseEntity<ResponseAPI> getAllRecipes() {
        final List<RecipeDTO> allRecipes = this.recipeService.getAllRecipes();
        final ResponseAPI responseAPI = ResponseAPI.ok(allRecipes);
        return ResponseEntity.ok(responseAPI);
    }

    @ApiOperation(value = "Create a Recipe", notes = "Recipe Service", nickname = "createRecipe")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public ResponseEntity<ResponseAPI> createRecipe(
            @ApiParam(name = "recipeDto", value = "Recipe to create") @RequestBody final RecipeDTO recipeDTO) {
        final RecipeDTO recipe = this.recipeService.createRecipe(recipeDTO);
        final ResponseAPI responseAPI = ResponseAPI.ok(recipe);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseAPI);
    }

    @ApiOperation(value = "Update a Recipe", notes = "Recipe Service", nickname = "updateRecipe")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PatchMapping
    public ResponseEntity<ResponseAPI> UpdateRecipe(
            @ApiParam(name = "recipeDto", value = "Recipe to update") @RequestBody final RecipeDTO recipeDTO) {
        final RecipeDTO recipe = this.recipeService.updateRecipe(recipeDTO);
        final ResponseAPI responseAPI = ResponseAPI.ok(recipe);
        return ResponseEntity.ok(responseAPI);
    }

}
