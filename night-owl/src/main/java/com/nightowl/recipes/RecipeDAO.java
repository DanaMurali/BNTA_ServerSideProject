package com.nightowl.recipes;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO {
    List<Recipe> selectRecipes();
    int insertRecipe(Recipe movie);
    int deleteRecipe(int id);
    Optional<Recipe> selectRecipeById(int id);
//    public int updateRecipeById(int id, String name);

}
