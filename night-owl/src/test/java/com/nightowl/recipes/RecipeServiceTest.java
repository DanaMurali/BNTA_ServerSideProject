package com.nightowl.recipes;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @Mock
    private RecipeDAO recipeDAO;
    private RecipeService underTest;
    private RecipeDataAccessService recipeDataAccessService;

    private RecipeDataAccessService selectRecipe;
    private RecipeDataAccessService insertRecipe;
    private RecipeDataAccessService deleteRecipe;
    private RecipeDataAccessService SelectRecipeById;
    private RecipeDataAccessService updateRecipe;

    @BeforeEach
    void setUp() {

        // TODO: create a mock for personDAO
        // TODO: create an instance of underTest and pass personDAO into it

        RecipeDAO rDAOmock = mock(RecipeDAO.class);
        underTest = new RecipeService(rDAOmock);

    }

    @Test
    void getRecipesFromDatabase() {

//        //when
//        underTest.getRecipe();
//
//        //then
//        verify(RecipeDAO.class).selectRecipes();
}

    @Test
    void addNewRecipe() {
    }

    @Test
    void deleteRecipe() {
    }

    @Test
    void testGetRecipe() {
    }

    @Test
    void updateRecipe() {
    }
}