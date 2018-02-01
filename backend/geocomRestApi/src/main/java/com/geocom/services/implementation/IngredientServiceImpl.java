package com.geocom.services.implementation;

import com.geocom.dtos.IngredientDTO;
import com.geocom.repositories.IngredientRepository;
import com.geocom.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(final IngredientRepository ingredientRepository, final ConversionService conversionService) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        return this.ingredientRepository.findAllIngredients();
    }
}
