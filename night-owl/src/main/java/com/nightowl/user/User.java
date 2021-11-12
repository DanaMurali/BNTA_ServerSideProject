package com.nightowl.user;

import com.nightowl.Cuisine;
import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;

import java.util.List;

public record User (List<String> allergies,
                    Cuisine cuisine,
                    boolean vegetarian,
                    boolean vegan,
                    boolean meatOnly,
                    boolean pescatarian,
                    MealType mealType,
                    SpiceRating spiceRating,
                    Integer cookingTime){
}


