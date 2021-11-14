package com.nightowl.recipes;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO {
    List<Recipe> selectRecipes();
    int insertRecipe(Recipe recipe);
    int deleteRecipe(int id);
    Optional<Recipe> selectRecipeById(int id);
    int updateRecipe( Recipe recipe, Integer id);

}
