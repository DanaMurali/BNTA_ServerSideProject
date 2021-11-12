package com.nightowl.ingredients;

import com.nightowl.exceptions.Exceptions;
import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientDAO ingredientDAO;

    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public List<Ingredient> getIngredient() {
        return ingredientDAO.selectIngredients();
    }

    public void addNewIngredient(Ingredient ingredient) {
        //TODO: check if recipe exists
        int result = ingredientDAO.insertIngredient(ingredient);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void deleteIngredient(Integer id) {
        Optional<Ingredient> ingredients = ingredientDAO.selectIngredientById(id);
        ingredients.ifPresentOrElse(ingredient -> {
            int result = ingredientDAO.deleteIngredient(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete ingredient");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id %s not found", id));
        });
    }


    public Ingredient getIngredient(int id) {
        return ingredientDAO.selectIngredientById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id %s not found", id)));
    }

    public void updateIngredient( Ingredient ingredient, Integer id) {
        ingredientDAO.updateIngredient(ingredient, id);
//        if (result != 1) {
//            throw new IllegalStateException("oops something went wrong");
//        }

    }
}
