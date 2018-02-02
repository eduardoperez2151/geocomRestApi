package com.geocom.controllers;

import com.geocom.dtos.IngredientDTO;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IngredientController {


    private IngredientService ingredientService;

    @Autowired
    public IngredientController(final IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<ResponseAPI> getAllIngredients() {
        final List<IngredientDTO> ingredients = this.ingredientService.getAllIngredients();
        final ResponseAPI responseAPI = ResponseAPI.ok(ingredients);
        return ResponseEntity.ok(responseAPI);
    }

}
