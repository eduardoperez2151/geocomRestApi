package com.geocom.controllers;

import com.geocom.dtos.IngredientDTO;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.IngredientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "GeoCom Ingredient services", produces = "application/json")
public class IngredientController {


    private IngredientService ingredientService;

    @Autowired
    public IngredientController(final IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @ApiOperation(value = "Get all ingredient service", notes = "Ingredient Service", nickname = "getAllIngredients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping
    public ResponseEntity<ResponseAPI> getAllIngredients() {
        final List<IngredientDTO> ingredients = this.ingredientService.getAllIngredients();
        final ResponseAPI responseAPI = ResponseAPI.ok(ingredients);
        return ResponseEntity.ok(responseAPI);
    }

}
