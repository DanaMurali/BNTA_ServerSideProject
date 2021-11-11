package com.nightowl.recipes;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeDataAccessService implements RecipeDAO {
    @Override
    public List<Recipe> selectRecipes() {

        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int insertRecipe(Recipe recipe) {

        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int deleteRecipe(int id) {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public Optional<Recipe> selectRecipeById(int id) {
        throw new UnsupportedOperationException("not implemented");
    }

}
