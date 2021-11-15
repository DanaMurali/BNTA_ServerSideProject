package com.nightowl.recipes;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDAOTest {

    @Autowired
    private RecipeDAO underTest;

    @Test
    void selectRecipes() {
        //given
        //Recipe recipe = new Recipe(1, "pasta", Cuisine.AMERICAN, true, true, false, false, MealType.DINNER, SpiceRating.SWEET, 20, "cook");

    }

    @Test
    void insertRecipe() {
    }

    @Test
    void deleteRecipe() {
    }

    @Test
    void selectRecipeById() {
    }

    @Test
    void updateRecipe() {
    }
}