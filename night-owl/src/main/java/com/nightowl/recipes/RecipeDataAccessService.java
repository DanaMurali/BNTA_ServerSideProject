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
    public int insertRecipe(Recipe recipes) {
        String sql = """
                INSERT INTO recipes(name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time, instructions) 
                VALUES (?, ?::cuisine, ?, ?, ?, ?, ?::meal_type, ?::spice_rating, ?, ?);
                """;

        //CAST(? AS animal_type)
                   //?::animal_type

       return jdbcTemplate.update(
               sql,
               recipes.name(),
               recipes.cuisine(),
               recipes.vegetarian(),
               recipes.vegan(),
               recipes.meatOnly(),
               recipes.pescatarian(),
               recipes.mealType(),
               recipes.spiceRating(),
               recipes.cookingTime(),
               recipes.instructions()
       );
       // return jdbcTemplate.update(sql, dog.name, dog.age, dog.breed, dog.favouriteToy);


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
