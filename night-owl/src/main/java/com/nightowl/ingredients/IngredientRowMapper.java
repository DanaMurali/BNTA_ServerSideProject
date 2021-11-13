package com.nightowl.ingredients;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import com.nightowl.recipes.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("allergy_category")

        );

    }
}
