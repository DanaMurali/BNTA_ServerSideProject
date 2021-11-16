package com.nightowl.recipes;
import com.nightowl.exceptions.Exceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    //Instantiating the RecipeDAO class in RecipeService.
    private final RecipeDAO recipeDAO;


    //constructor for above
    public RecipeService(RecipeDAO recipeDao) {
        this.recipeDAO = recipeDao;
    }

    //select Recipe method being called from interface.
    public List<Recipe> getRecipe() {
        return recipeDAO.selectRecipes();
    }

    //Calling the insert recipe method from interface and returning an int. If it returns 1 it works, if not it's not working and should be expecting our illegal state expression.
    public void addNewRecipe(Recipe recipe) {
        int result = recipeDAO.insertRecipe(recipe);
        if (result != 1) {
            throw new IllegalStateException("nah mate, no can do");
        }
    }

    //Calling select Recipe by id method from interface to find the recipe by id.
    //If recipe id exists we call delete method from interface and delete the corresponding recipe to id.
    //returning 1 if deletion was successful. If something goes wrong get the first error message with illegal state exception.
    //If recipe id does not exist, recipe is just not found will throw second exception message.
    public void deleteRecipe(Integer id) {
        Optional<Recipe> recipes = recipeDAO.selectRecipeById(id);
        recipes.ifPresentOrElse(recipe -> {
            int result = recipeDAO.deleteRecipe(id);
            if (result != 1) {
                throw new IllegalStateException("Oi! Why are you trying to delete something that doesn't exist mate?");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id %s not found", id));
        });
    }

    //calling select recipe by id from interface and will work if id exists, if not will throw recipe with id not found.
    public Recipe getRecipe(int id) {
        return recipeDAO.selectRecipeById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id %s not found", id)));
    }

    //Calling the update method from interface and updating recipe. If it works will return 1, if not will return the error.
    public void updateRecipe( Recipe recipe, Integer id) {
         int result = recipeDAO.updateRecipe(recipe, id);
        if (result != 1) {
            throw new IllegalStateException("Oops! Cannot update your scrumptious recipe!");
        }

    }
}
