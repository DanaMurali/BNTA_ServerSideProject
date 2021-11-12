package com.nightowl.ingredients;

import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeRowMapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientDataAccessService implements IngredientDAO {

    private final JdbcTemplate jdbcTemplate;

    public IngredientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //selecting every column we want to the table to return
    //naming which table from
    //limiting how many rows we want to see
    //final line returns the table defined in class RecipeRowMapper
    public List<Ingredient> selectIngredients() {
        String sql = """               
                SELECT id, ingredient_name, allergy_category
                FROM ingredients
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new IngredientRowMapper()) ;
    }

    @Override
    public int insertIngredient(Ingredient ingredients) {
        String sql = """
                INSERT INTO ingredients (ingredient_name,allergy_category) 
                VALUES (?,?);
                """;

        //CAST(? AS animal_type)
        //?::animal_type

        return jdbcTemplate.update(
                sql,
                ingredients.getName(),
                ingredients.getAllergyCategory()
        );


    }

    @Override
    public int deleteIngredient(int id) {
        String sql = """
                DELETE FROM ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Ingredient> selectIngredientById(int id) {

        String sql = """
                SELECT id, ingredient_name, allergy_category
                FROM ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new IngredientRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public void updateIngredient(Ingredient ingredient, Integer id) {
        String sql = """
                UPDATE ingredients
                SET ingredient_name = ?, allergy_category = ?
                WHERE id = ?
                """;


        jdbcTemplate.update(sql,
                ingredient.getName(),
                ingredient.getAllergyCategory(),
                id);
        System.out.println("Updated Record with ID = " + id + "with ingredient name: " + ingredient);


        /*if (recipe.getName() != null && recipe.getName().length() >0 && !Objects.equals(recipe.getName(), name)){
            recipe.setName (name);
        }*/
    }
}
