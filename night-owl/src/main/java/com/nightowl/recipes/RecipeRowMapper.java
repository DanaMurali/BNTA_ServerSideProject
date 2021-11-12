package com.nightowl.recipes;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeRowMapper implements RowMapper<Recipe> {
    @Override
    public Recipe mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Recipe(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                Cuisine.valueOf(resultSet.getString("cuisine")),
                Boolean.parseBoolean(resultSet.getString("vegetarian")),
                Boolean.parseBoolean(resultSet.getString("vegan")),
                Boolean.parseBoolean(resultSet.getString("meat_only")),
                Boolean.parseBoolean(resultSet.getString("pescatarian")),
                MealType.valueOf(resultSet.getString("meal_type")),
                SpiceRating.valueOf(resultSet.getString("spice_rating")),
                resultSet.getInt("cooking_time"),
                resultSet.getString("instructions")

        );

    }
}