package com.nightowl.recipes;
import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    public List<Recipe> getRecipes(){
        return List.of(
                new Recipe(
                        1,
                        "pasta",
                        Cuisine.ITALIAN,
                        true,
                        false,
                        false,
                        false,
                        MealType.DINNER,
                        SpiceRating.MILD,
                        20,
                        "cook food"
                )
        );
    }

}
