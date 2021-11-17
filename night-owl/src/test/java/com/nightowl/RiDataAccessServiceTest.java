package com.nightowl;

import com.nightowl.recipes.Recipe;
import com.nightowl.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class RiDataAccessServiceTest {


    private JdbcTemplate jdbcTemplate;
    @MockBean
    private RiDataAccessService riDataAccessService;


    public RiDataAccessServiceTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        riDataAccessService = new RiDataAccessService(jdbcTemplate);
    }

    @Test
    void shouldFilterRecipesByAllergy() {
        List<RiTwo> recipes = List.of(new RiTwo("pasta", "flour", Cuisine.AMERICAN, true,
                true, true, true, MealType.LUNCH, SpiceRating.MILD, 20, "cook"),
                new RiTwo("fried egg", "egg", Cuisine.BRITISH, false, false,
                        false, false, MealType.BREAKFAST, SpiceRating.HOT, 15,
                        "cook"));
//        String allergy = new String();
//        recipes.get(0)
        User user = new User();
        user.setAllergy("lactose");

        when(riDataAccessService.selectRiTwo(user)).thenReturn((List<RiTwo>) recipes.get(1));

        //List<RiTwo> filteredRecipes = riDataAccessService.selectRiTwo(user);
        assertEquals(1, riDataAccessService.selectRiTwo(user).size());

    }

//    @Override
//    public void setUp() throws Exception {
//
//        MockConnection connection = new MockConnection();
//
//        this.tableName = "table1";
//        MockTable table = new MockTable(tableName);
//
//        String columnName = "column1";
//        ColumnType columnType = ColumnType.NUMBER;
//        int columnSize = 50;
//        MockColumn column = new MockColumn(columnName, columnType, columnSize);
//        table.addColumn(column);
//
//        for (int i = 0; i < 20; i++) {
//            HashMap<MockColumn, Object> fields = new HashMap<MockColumn, Object>();
//            fields.put(column, i);
//            table.addRow(fields);
//        }
//
//        this.connection = connection;
//    }
//
//    @Test
//    public void testGatherStatistics() throws Exception {
//
//        DBMonitor monitor = new DBMonitor(connection);
//        monitor.gatherStatistics();
//        assertEquals(((MockConnection) connection).getNumberOfRows(tableName),
//                monitor.getNumberOfRows(tableName));
//    }
//
//    String tableName;
//    Connection connection;

}