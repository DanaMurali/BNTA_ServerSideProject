package com.nightowl.night.owl;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeDAO;
import com.nightowl.recipes.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class NightOwlApplicationTests {

	@Autowired
	private RecipeService recipeService;

	@MockBean
	private RecipeDAO recipeDAO;

	@Test
	public void getRecipesTest() {

		when(recipeDAO.selectRecipes()).thenReturn(Stream.of(new Recipe(1,"Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water."), (new Recipe(2,"Fried Egg", Cuisine.ITALIAN,
				true, false, false, false, MealType.BREAKFAST, SpiceRating.MILD,
				5, "Fry in Pan."))).collect(Collectors.toList()));

		assertEquals(2, recipeService.getRecipe().size());

	}


}
