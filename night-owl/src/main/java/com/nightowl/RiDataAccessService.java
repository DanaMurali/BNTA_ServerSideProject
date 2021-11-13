package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientRowMapper;
import com.nightowl.recipes.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RiDataAccessService implements RiDAO {

    private final JdbcTemplate jdbcTemplate;

    public RiDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //selecting every column we want to the table to return
    //naming which table from
    //limiting how many rows we want to see
    //final line returns the table defined in class RecipeRowMapper
    public List<RiTwo> selectRiTwo() {
        String sql = """   
                SELECT recipes.rname, ingredients.iname
                FROM recipes
                INNER JOIN recipes_ingredients 
                	ON recipes_ingredients.recipe_id = recipes.id
                INNER JOIN ingredients 
                	ON recipes_ingredients.ingredient_id = ingredients.id;
                """;
        return jdbcTemplate.query(sql, new RiTwoRowMapper());
    }

    @Override
    public int insertRi(Ri ri) {
        String sql = """
                INSERT INTO recipes_ingredients(recipe_id, ingredient_id) 
                VALUES (?, ?);
                """;

        return jdbcTemplate.update(
                sql,
                ri.getRecipe_id(),
                ri.getIngredient_id()
        );
        // return jdbcTemplate.update(sql, dog.name, dog.age, dog.breed, dog.favouriteToy);


    }

    @Override
    public int deleteRi(int id) {
        String sql = """
                DELETE FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Ri> selectRiById(int id) {

        String sql = """
                SELECT id, recipe_id, ingredient_id
                FROM recipes_ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RiRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public void updateRi(Ri ri, Integer id) {
        String sql = """
                UPDATE recipes
                SET name = ?, cuisine = ?::cuisine, vegetarian = ?, vegan = ?, meat_only = ?, pescatarian = ?, meal_type = ?::meal_type, spice_rating = ?::spice_rating, cooking_time_mins = ?, instructions = ?
                WHERE id = ?
                """;


        jdbcTemplate.update(sql,
                ri.getRecipe_id(),
                ri.getIngredient_id(), id);
        System.out.println("Updated Record with ID = " + id + "with recipe name: " + ri);


        /*if (recipe.getName() != null && recipe.getName().length() >0 && !Objects.equals(recipe.getName(), name)){
            recipe.setName (name);
        }*/
    }


}
