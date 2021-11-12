package com.nightowl.recipes;
import com.nightowl.exceptions.Exceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeDAO recipeDAO;

    public RecipeService(RecipeDAO recipeDao) {
        this.recipeDAO = recipeDao;
    }

    public List<Recipe> getRecipe() {
        return recipeDAO.selectRecipes();
    }

    public void addNewRecipe(Recipe recipe) {
        // TODO: check if recipe exists
        int result = recipeDAO.insertRecipe(recipe);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void deleteRecipe(Integer id) {
        Optional<Recipe> recipes = recipeDAO.selectRecipeById(id);
        recipes.ifPresentOrElse(recipe -> {
            int result = recipeDAO.deleteRecipe(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete recipe");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id %s not found", id));
        });
    }


    public Recipe getRecipe(int id) {
        return recipeDAO.selectRecipeById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id %s not found", id)));
    }

//    public int updateRecipe(Integer id, String name) {
//        int result = recipeDAO.deleteRecipe(id);
//        if (result != 1) {
//            throw new IllegalStateException("oops something went wrong");
//        }
//        return 1;
//    }
}
