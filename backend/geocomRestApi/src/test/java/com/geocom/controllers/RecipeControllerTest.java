package com.geocom.controllers;

import com.geocom.dtos.IngredientDTO;
import com.geocom.dtos.RecipeDTO;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;


    @Test
    public void testRecipeControllerTest() throws Exception {


        final IngredientDTO ingredient1 = getIngredient(1l,2d,"onion");
        final IngredientDTO ingredient2 = getIngredient(2l,3d,"lettuce");
        final List<IngredientDTO> ingredientList = Stream.of(ingredient1, ingredient2).collect(Collectors.toList());

        final RecipeDTO recipe = getRecipeDTO(1l,"mom recipe","imagePath",ingredientList);
        final RecipeDTO recipe2 = getRecipeDTO(2l,"mom recipe","imagePath",ingredientList);
        final List<RecipeDTO> recipeList = Stream.of(recipe, recipe2).collect(Collectors.toList());

        when(this.recipeService.getAllRecipes()).thenReturn(recipeList);

        mockMvc.perform(get("/recipes")
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(ResponseAPI.SUCCESS_CODE)))
                .andExpect(jsonPath("$.message", is(ResponseAPI.SUCCESS_MESSAGE)))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].id", is(1)))
                .andExpect(jsonPath("$.data[0].ingredients", hasSize(2)))
                .andExpect(jsonPath("$.data[0].ingredients[1].name", is("lettuce")));
    }

    private RecipeDTO getRecipeDTO(final Long id, final String name, final String imagePath, final List<IngredientDTO> ingredientList) {
        return RecipeDTO.builder()
                    .id(id)
                    .description(name)
                    .imagePath(imagePath)
                    .ingredients(ingredientList)
                    .build();
    }

    private IngredientDTO getIngredient(final Long id, final Double amount, final String name) {
        return IngredientDTO.builder()
                .id(id)
                .amount(amount)
                .name(name)
                .build();
    }
}
