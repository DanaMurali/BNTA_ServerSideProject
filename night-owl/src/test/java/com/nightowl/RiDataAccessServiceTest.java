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

@SpringBootTest
class RiDataAccessServiceTest {


    private JdbcTemplate jdbcTemplate;
    private RiDataAccessService riDataAccessService;

    @Autowired
    public RiDataAccessServiceTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        riDataAccessService = new RiDataAccessService(jdbcTemplate);
    }

    @Test
    void shouldFilterRecipesByAllergy() {
        User user = new User();
        List<RiTwo> filteredRecipes = riDataAccessService.selectRiTwo(user);
        assertEquals(28, filteredRecipes.size());

    }
}