package com.geocom.repositories;

import com.geocom.dtos.IngredientDTO;
import com.geocom.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {


    @Query(value="SELECT new com.geocom.dtos.IngredientDTO(i.name,sum(i.amount)) FROM Ingredient i GROUP BY i.name")
    List<IngredientDTO> findAllIngredients();
}
