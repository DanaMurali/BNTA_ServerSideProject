package com.nightowl.recipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {

    private RecipeService recipeService;


    public RecipeController(RecipeService movieService) {
        this.recipeService = movieService;
    }

    @GetMapping
    public List<Recipe> listMovies() {
        return recipeService.getRecipe();
    }

    @GetMapping("{id}")
    public Recipe getRecipeId(@PathVariable("id") Integer id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addNewRecipe(recipe);
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable("id") Integer id) {
        recipeService.deleteRecipe(id);
    }
}
