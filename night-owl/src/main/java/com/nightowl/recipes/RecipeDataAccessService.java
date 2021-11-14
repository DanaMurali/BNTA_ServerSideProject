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

    //instantiating our driver jdbc template
    private final JdbcTemplate jdbcTemplate;

    // constructor for above
    public RecipeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //selecting every column we want to the table to return
    //naming which table from
    //limiting how many rows we want to see
    //final line uses .query method associated with jdbcTemplate to take the sql defined and map to one row of the table using the rowmapper
    public List<Recipe> selectRecipes() {
        String sql = """               
                SELECT id, rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions 
                FROM recipes
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RecipeRowMapper()) ;
    }

    @Override
    //Specifying when column we want to insert our input into.
    //Had to specify values by leaving a ? as a placeholder for whatever input we'd put in. For enums we have to leave the placeholder ? and cast on it ?::column_name.
    //using jdbc template's update method - taking in sql and is allocating our input to corresponding property in recipe class. recipes.is for booleans.

    public int insertRecipe(Recipe recipes) {
        String sql = """
                INSERT INTO recipes(rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions) 
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
    //sql query is saying delete from recipes table where id = ? is a placeholder for our input.
    //jdbc carrying out sql query and giving back result of that.
    public int deleteRecipe(int id) {
        String sql = """
                DELETE FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    //sql query - selecting our column titles from recipe table where id = ? is a placeholder for our input.
    //jdbc template is our sql query to map everything into one row of our table.
    //.stream is turns what we put in into a stream of characters and returning the first output.
    public Optional<Recipe> selectRecipeById(int id) {

        String sql = """
                SELECT id, rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions 
                FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RecipeRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    //sql query - updating recipe table and specified column title by SET, where id = ? is a placeholder for our input.
    //jdbc driver template is just updating it and telling us which row was updated.
    public int updateRecipe(Recipe recipe, Integer id) {
        String sql = """
                UPDATE recipes
                SET rname = ?, cuisine = ?::cuisine, vegetarian = ?, vegan = ?, meat_only = ?, pescatarian = ?, meal_type = ?::meal_type, spice_rating = ?::spice_rating, cooking_time_mins = ?, instructions = ?
                WHERE id = ?
                """;



         return jdbcTemplate.update(sql,

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



        /*if (recipe.getName() != null && recipe.getName().length() >0 && !Objects.equals(recipe.getName(), name)){
            recipe.setName (name);
        }*/
    }

}
