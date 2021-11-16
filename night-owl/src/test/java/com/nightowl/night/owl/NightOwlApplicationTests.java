package com.nightowl.night.owl;

import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import com.nightowl.ingredients.Ingredient;
import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeDAO;
import com.nightowl.recipes.RecipeService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class NightOwlApplicationTests {

	//Recipe Class Tests

	@Autowired
	//injecting our service class
	private RecipeService recipeService;

	@MockBean
	//injecting our interface/repository which is what we want to mock.
	private RecipeDAO recipeDAO;

	@Test
	public void getRecipesTest() {

		//when I call the method then return the data I put in, in a list.
		when(recipeDAO.selectRecipes()).thenReturn(Stream.of(new Recipe(1,"Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water."), (new Recipe(2,"Fried Egg", Cuisine.ITALIAN,
				true, false, false, false, MealType.BREAKFAST, SpiceRating.MILD,
				5, "Fry in Pan."))).collect(Collectors.toList()));

		//Comparing the amount of objects in list using method.
		assertEquals(2, recipeService.getRecipe().size());

	}

	@Test
	public void getRecipeByIdTest () {

		//given
		List<Recipe> recipes = List.of(new Recipe(1, "Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water."));


		//mocking RecipeDAO - teaching our mock what to do basically
		when(recipeDAO.selectRecipeById(1)).thenReturn(Optional.of(new Recipe(1, "Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water.")));

		//when - because in PersonDAO get person by ID is listed as optional
		Optional<Recipe> actual = recipeDAO.selectRecipeById(1);

		//then
		assertThat(actual).isEqualTo(Optional.of(recipes.get(0)));
	}

	@Test
	public void updateTest () {

		//given
//
		Recipe recipe = new Recipe(1,"Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water.");

		assertThat(recipe).isNotNull();
		//mocking RecipeDAO
		when(recipeDAO.updateRecipe(recipe, 1)).thenReturn(1);

		assertEquals(1, recipeDAO.updateRecipe(recipe, 1));

	}



	@Test
	public void shouldThrowErrorIfUpdateIsNotSuccessfulTest () {

		//given
//
		Recipe recipe = new Recipe(1,"Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water.");


		when(recipeDAO.updateRecipe(recipe, 1)).thenReturn(0);



		assertThatThrownBy(() -> recipeDAO.updateRecipe(recipe, 1))
				.hasMessageContaining("Oops! Cannot update your scrumptious recipe!")
				.isInstanceOf(IllegalStateException.class);



	}

//	@Test
//	public void canInsertRecipe(){
//		//given
//		Recipe Recipe = new Recipe(3,"Plov", Cuisine.UZBEK,
//				false, false, true, true, MealType.DINNER, SpiceRating.MILD,
//				20, "1)Prepare the ingredients by washing and soaking the rice, chopping the lamb into small chunks and dicing the onion and carrots \n 2)Fry the meat, onion and carrots in oil \n 3) Cook until ready.”\n");
//
//		//when
//		when(RecipeDAO);
//
//		//then
//		assertEquals(1, recipeDAO.insertRecipe(recipeDAO, 3));
//
//
//}

	@Test
	public void deleteRecipeByIdTest() {
		// delete recipe method:
		// Optional<Recipe> recipes = recipeDAO.selectRecipeById(id);
		// if recipe exists: int result = recipeDAO.deleteRecipe(id);
		// if result != 1 (if delete does not work) throw illegal state exception
		// if recipe does not exist: throw new exception

		// given
		List<Recipe> recipes = List.of(new Recipe(1, "Pasta", Cuisine.ITALIAN,
				true, true, false, false, MealType.LUNCH, SpiceRating.MILD,
				20, "Boil in water."));

		// when
		when(recipeDAO.deleteRecipe(1)).thenReturn(1);


		// then
		assertThat(recipeDAO.deleteRecipe(1)).isEqualTo(1);
	}
}
