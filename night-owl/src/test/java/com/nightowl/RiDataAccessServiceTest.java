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

    //test attempted but not yet working


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

        User user = new User();
        user.setAllergy("lactose");

        when(riDataAccessService.selectRiTwo(user)).thenReturn((List<RiTwo>) recipes.get(1));


        assertEquals(1, riDataAccessService.selectRiTwo(user).size());

    }

}