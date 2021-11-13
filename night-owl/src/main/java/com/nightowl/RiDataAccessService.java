package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientRowMapper;
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
    public List<Ri> selectRi() {
        String sql = """               
                SELECT id, recipe_id, ingredient_id
                FROM recipes_ingredients
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RiRowMapper()) ;
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


}
