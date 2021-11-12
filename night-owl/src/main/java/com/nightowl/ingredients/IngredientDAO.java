package com.nightowl.ingredients;

import com.nightowl.recipes.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IngredientDAO {

    List<Ingredient> selectIngredients();
    int insertIngredient(Ingredient movie);
    int deleteIngredient(int id);
    Optional<Ingredient> selectIngredientById(int id);
    void updateIngredient( Ingredient ingredient, Integer id);
}
