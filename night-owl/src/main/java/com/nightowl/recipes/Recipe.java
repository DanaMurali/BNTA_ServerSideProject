package com.nightowl.recipes;
//import javax.persistence.Entity;
import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;




//public class Recipe {
//    private Integer id;
//    private String name;
//    private Cuisine cuisine;
//    private boolean vegetarian;
//    private boolean vegan;
//    private boolean meatOnly;
//    private boolean pescatarian;
//    private MealType mealType;
//    private SpiceRating spiceRating;
//    private Integer cookingTime;
//    private String instructions;



    public record Recipe(Integer id,
                         String name,
                         Cuisine cuisine,
                         boolean vegetarian,
                         boolean vegan,
                         boolean meatOnly,
                         boolean pescatarian,
                         MealType mealType,
                         SpiceRating spiceRating,
                         Integer cookingTime,
                         String instructions) {

    }

//}
