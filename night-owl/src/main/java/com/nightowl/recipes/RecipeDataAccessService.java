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
    public List<Recipe> selectRecipes() {
        String sql = """
                SELECT id, name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time, instructions 
                FROM recipes
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RecipeRowMapper()) ;
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
                SELECT id, name, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time, instructions 
                FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RecipeRowMapper(), id)
                .stream()
                .findFirst();

    }

//    @Override
//    public int updateRecipeById(int id, String name) {
//        String sql = """
//                UPDATE recipes
//                SET name = ?
//                WHERE id = ?
//                """;
//
//
//        return jdbcTemplate.update(sql, new RecipeRowMapper());
//
//
//        /*if (recipe.getName() != null && recipe.getName().length() >0 && !Objects.equals(recipe.getName(), name)){
//            recipe.setName (name);
//        }*/
//    }

}
