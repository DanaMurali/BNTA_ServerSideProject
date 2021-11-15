package com.nightowl.recipes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RecipeDataAccessServiceTest {

    @Mock
    private RecipeDataAccessService underTest;
    private RecipeDAO recipeDAO;
    private JdbcTemplate mockj;

    @BeforeEach
            void setUp() {
        RecipeDAO rdao = mock(RecipeDAO.class);
        underTest = new RecipeDataAccessService(mockj);

    }



    @Test
    void selectRecipes() {

        underTest.selectRecipes();

        verify(Re)

    }

    @Test
    void insertRecipe() {
    }

    @Test
    void deleteRecipe() {
    }

    @Test
    void selectRecipeById() {
    }

    @Test
    void updateRecipe() {
    }
}