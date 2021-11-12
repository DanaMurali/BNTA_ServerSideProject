package com.nightowl.recipes;
//import javax.persistence.Entity;
import com.nightowl.Cuisine;
import com.nightowl.Cuisine;
import com.nightowl.MealType;
import com.nightowl.SpiceRating;




public class Recipe {
    private Integer id;
    private String name;
    private Cuisine cuisine;
    private boolean vegetarian;
    private boolean vegan;
    private boolean meatOnly;
    private boolean pescatarian;
    private MealType mealType;
    private SpiceRating spiceRating;
    private Integer cookingTime;
    private String instructions;

    public Recipe(Integer id, String name, Cuisine cuisine, boolean vegetarian, boolean vegan, boolean meatOnly, boolean pescatarian, MealType mealType, SpiceRating spiceRating, Integer cookingTime, String instructions) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.meatOnly = meatOnly;
        this.pescatarian = pescatarian;
        this.mealType = mealType;
        this.spiceRating = spiceRating;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isMeatOnly() {
        return meatOnly;
    }

    public void setMeatOnly(boolean meatOnly) {
        this.meatOnly = meatOnly;
    }

    public boolean isPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(boolean pescatarian) {
        this.pescatarian = pescatarian;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public SpiceRating getSpiceRating() {
        return spiceRating;
    }

    public void setSpiceRating(SpiceRating spiceRating) {
        this.spiceRating = spiceRating;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisine=" + cuisine +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", meatOnly=" + meatOnly +
                ", pescatarian=" + pescatarian +
                ", mealType=" + mealType +
                ", spiceRating=" + spiceRating +
                ", cookingTime=" + cookingTime +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
