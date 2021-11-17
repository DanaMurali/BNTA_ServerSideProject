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

        //if (resultSet.g)

        return new Recipe(
                resultSet.getInt("id"),
                resultSet.getString("rname"),
                Cuisine.valueOf(resultSet.getString("cuisine")),
                resultSet.getBoolean("vegetarian"),
                resultSet.getBoolean("vegan"),
                resultSet.getBoolean("meat_only"),
                resultSet.getBoolean("pescatarian"),
                MealType.valueOf(resultSet.getString("meal_type")),
                SpiceRating.valueOf(resultSet.getString("spice_rating")),
                resultSet.getInt("cooking_time_mins"),
                resultSet.getString("instructions")

        );

    }
}
