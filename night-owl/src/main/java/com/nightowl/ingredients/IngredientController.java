package com.nightowl.ingredients;

import com.nightowl.recipes.Recipe;
import com.nightowl.recipes.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ingredient")
public class IngredientController {

    private IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> listIngredient() {
        return ingredientService.getIngredient();
    }

    @GetMapping("{id}")
    public Ingredient getIngredientId(@PathVariable("id") Integer id) {
        return ingredientService.getIngredient(id);
    }

    @PostMapping
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addNewIngredient(ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") Integer id) {
        ingredientService.deleteIngredient(id);
    }

    @PutMapping("{id}")
    public void updateIngredient( @RequestBody Ingredient ingredient, @PathVariable("id") Integer id) { ingredientService.updateIngredient(ingredient,id);}
}


