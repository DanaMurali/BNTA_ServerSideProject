package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientRowMapper;
import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RiRowMapper implements RowMapper<Ri> {

    @Override
    public Ri mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ri(

                resultSet.getInt("id"),
                resultSet.getInt("recipe_id"),
                resultSet.getInt("ingredient_id")
        );
    }
}