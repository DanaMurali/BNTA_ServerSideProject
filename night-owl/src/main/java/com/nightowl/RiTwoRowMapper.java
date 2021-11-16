package com.nightowl;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RiTwoRowMapper implements RowMapper<RiTwo> {

    //purpose - just to map the output of the inner join table for us to see the recipe name etc...
    @Override
    public RiTwo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new RiTwo(


                resultSet.getString("rname"),
                resultSet.getString("iname"),
                Cuisine.valueOf(resultSet.getString("cuisine")),
                Boolean.parseBoolean(resultSet.getString("vegetarian")),
                Boolean.parseBoolean(resultSet.getString("vegan")),
                Boolean.parseBoolean(resultSet.getString("meat_only")),
                Boolean.parseBoolean(resultSet.getString("pescatarian")),
                MealType.valueOf(resultSet.getString("meal_type")),
                SpiceRating.valueOf(resultSet.getString("spice_rating")),
                resultSet.getInt("cooking_time_mins"),
                resultSet.getString("instructions")
        );
    }
}


