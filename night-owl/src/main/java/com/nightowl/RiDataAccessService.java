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
    //From recipes table we want to inner join to recipe_ingredients and making connection between recipe_id
    // from recipes_ingredients to recipes.id.
    //The output from above we will inner join with ingredients table and making connection between
    // ingredients_id from recipes_ingredient to ingredients.id.
    //Once inner join is complete we are selecting the name for recipes rname and ingredients iname from r_i table
    //Using RiTwo Row Mapper because we want to output a combined table showing recipe name and ingredient names.
    public List<RiTwo> selectRiTwo() {
        String sql = """   
                SELECT recipes.rname, ingredients.iname
                FROM recipes
                INNER JOIN recipes_ingredients 
                	ON recipes_ingredients.recipe_id = recipes.id
                INNER JOIN ingredients 
                	ON recipes_ingredients.ingredient_id = ingredients.id;
                	
                	
                	SELECT id, i.title AS item_title, t.tag_array
                 FROM   items      i
                 JOIN  (  -- or LEFT JOIN ?
                    SELECT it.item_id AS id, array_agg(t.title) AS tag_array
                    FROM   items_tags it
                    JOIN   tags       t  ON t.id = it.tag_id
                    GROUP  BY it.item_id
                    ) t USING (id);
                """;
        return jdbcTemplate.query(sql, new RiTwoRowMapper());

        /*public String getFKeyData(String tableName, int i) throws SQLException {
            DatabaseMetaData dm = connection.getMetaData();
            ResultSet rs = dm.getImportedKeys(null, null, tableName);
            while (rs.next()) {
                fkTableData = rs.getString(i);
            }
            return fkTableData;
        }*/
        // adding ingredient foreign keys to array

    }

    @Override
    // same as we did in recipes but for third table recipes_ingredients
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
                DELETE FROM recipes_ingredients 
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
                UPDATE recipes_ingredients
                SET recipe_id = ?, ingredient_id = ?
                WHERE id = ?
                """;


        jdbcTemplate.update(sql,
                ri.getRecipe_id(),
                ri.getIngredient_id(), id);
        System.out.println("Updated Record with ID = " + id + "with recipe name: " + ri);

    }


}
