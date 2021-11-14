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
                resultSet.getString("iname")
        );
    }
}
