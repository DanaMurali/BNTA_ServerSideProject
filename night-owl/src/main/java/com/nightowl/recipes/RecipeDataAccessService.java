package com.nightowl.recipes;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RecipeDataAccessService implements RecipeDAO {

    private final JdbcTemplate jdbcTemplate;

    public RecipeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //selecting every column we want to the table to return
    //naming which table from
    //limiting how many rows we want to see
    //final line returns the table defined in class RecipeRowMapper
    public List<Recipe> selectRecipes() {
        String sql = """               
                SELECT id, name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions 
                FROM recipes
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RecipeRowMapper()) ;
    }

    @Override
    public int insertRecipe(Recipe recipes) {
        String sql = """
                INSERT INTO recipes(name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions) 
                VALUES (?, ?::cuisine, ?, ?, ?, ?, ?::meal_type, ?::spice_rating, ?, ?) ON CONFLICT ON CONSTRAINT recipes_name_key DO NOTHING;
                """;


       return jdbcTemplate.update(
               sql,
               recipes.getName(),
               recipes.getCuisine().toString(),
               recipes.isVegetarian(),
               recipes.isVegan(),
               recipes.isMeatOnly(),
               recipes.isPescatarian(),
               recipes.getMealType().toString(),
               recipes.getSpiceRating().toString(),
               recipes.getCookingTime(),
               recipes.getInstructions()
       );
       // return jdbcTemplate.update(sql, dog.name, dog.age, dog.breed, dog.favouriteToy);


    }

    @Override
    public int deleteRecipe(int id) {
        String sql = """
                DELETE FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Recipe> selectRecipeById(int id) {

        String sql = """
                SELECT id, name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions 
                FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RecipeRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public void updateRecipe(Recipe recipe, Integer id) {
        String sql = """
                UPDATE recipes
                SET name = ?, cuisine = ?::cuisine, vegetarian = ?, vegan = ?, meat_only = ?, pescatarian = ?, meal_type = ?::meal_type, spice_rating = ?::spice_rating, cooking_time_mins = ?, instructions = ?
                WHERE id = ?
                """;


        jdbcTemplate.update(sql,
                recipe.getName(),
                recipe.getCuisine().toString(),
                recipe.isVegetarian(),
                recipe.isVegan(),
                recipe.isMeatOnly(),
                recipe.isPescatarian(),
                recipe.getMealType().toString(),
                recipe.getSpiceRating().toString(),
                recipe.getCookingTime(),
                recipe.getInstructions(), id);
        System.out.println("Updated Record with ID = " + id + "with recipe name: " + recipe);


        /*if (recipe.getName() != null && recipe.getName().length() >0 && !Objects.equals(recipe.getName(), name)){
            recipe.setName (name);
        }*/
    }

}
