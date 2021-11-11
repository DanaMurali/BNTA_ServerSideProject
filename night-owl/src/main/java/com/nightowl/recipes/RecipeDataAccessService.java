package com.nightowl.recipes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeDataAccessService implements RecipeDAO {

    private final JdbcTemplate jdbcTemplate;

    public RecipeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipe> selectRecipes() {

        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int insertRecipe(Recipe recipe) {
        String sql = """
                INSERT INTO recipe(name, cuisine, vegetarian, vegan, meatOnly, pescatarian, mealType, spiceRating, cookingTime, instructions) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
       return jdbcTemplate.update(sql,
               recipe.name(),
               recipe.cuisine().toString(),
               recipe.vegetarian(),
               recipe.vegan(),
               recipe.meatOnly(),
               recipe.pescatarian(),
               recipe.mealType(),
               recipe.spiceRating(),
               recipe.cookingTime(), recipe.instructions() );


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
