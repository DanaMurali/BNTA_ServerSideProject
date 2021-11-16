package com.nightowl;

import java.util.Objects;

public class RiTwo {

    private String rname;
    private String iname;
    private Cuisine cuisine;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean meat_only;
    private Boolean pescatarian;
    private MealType meal_type;
    private SpiceRating spice_rating;
    private Integer cooking_time_mins;
    private String instructions;


    public RiTwo(String rname, String iname, Cuisine cuisine, Boolean vegetarian, Boolean vegan, Boolean meat_only, Boolean pescatarian, MealType meal_type, SpiceRating spice_rating, Integer cooking_time_mins, String instructions) {
        this.rname = rname;
        this.iname = iname;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.meat_only = meat_only;
        this.pescatarian = pescatarian;
        this.meal_type = meal_type;
        this.spice_rating = spice_rating;
        this.cooking_time_mins = cooking_time_mins;
        this.instructions = instructions;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getArray_agg() {
        return array_agg;
    }

    public void setArray_agg(String array_agg) {
        this.array_agg = array_agg;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getMeat_only() {
        return meat_only;
    }

    public void setMeat_only(Boolean meat_only) {
        this.meat_only = meat_only;
    }

    public Boolean getPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(Boolean pescatarian) {
        this.pescatarian = pescatarian;
    }

    public MealType getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(MealType meal_type) {
        this.meal_type = meal_type;
    }

    public SpiceRating getSpice_rating() {
        return spice_rating;
    }

    public void setSpice_rating(SpiceRating spice_rating) {
        this.spice_rating = spice_rating;
    }

    public Integer getCooking_time_mins() {
        return cooking_time_mins;
    }

    public void setCooking_time_mins(Integer cooking_time_mins) {
        this.cooking_time_mins = cooking_time_mins;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getMeat_only() {
        return meat_only;
    }

    public void setMeat_only(Boolean meat_only) {
        this.meat_only = meat_only;
    }

    public Boolean getPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(Boolean pescatarian) {
        this.pescatarian = pescatarian;
    }

    public MealType getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(MealType meal_type) {
        this.meal_type = meal_type;
    }

    public SpiceRating getSpice_rating() {
        return spice_rating;
    }

    public void setSpice_rating(SpiceRating spice_rating) {
        this.spice_rating = spice_rating;
    }

    public Integer getCooking_time_mins() {
        return cooking_time_mins;
    }

    public void setCooking_time_mins(Integer cooking_time_mins) {
        this.cooking_time_mins = cooking_time_mins;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "RiTwo{" +
                "rname='" + rname + '\'' +
                ", array_agg='" + iname + '\'' +
                ", cuisine=" + cuisine +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", meat_only=" + meat_only +
                ", pescatarian=" + pescatarian +
                ", meal_type=" + meal_type +
                ", spice_rating=" + spice_rating +
                ", cooking_time_mins=" + cooking_time_mins +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiTwo riTwo = (RiTwo) o;
        return Objects.equals(rname, riTwo.rname) && Objects.equals(iname, riTwo.iname) && cuisine == riTwo.cuisine && Objects.equals(vegetarian, riTwo.vegetarian) && Objects.equals(vegan, riTwo.vegan) && Objects.equals(meat_only, riTwo.meat_only) && Objects.equals(pescatarian, riTwo.pescatarian) && meal_type == riTwo.meal_type && spice_rating == riTwo.spice_rating && Objects.equals(cooking_time_mins, riTwo.cooking_time_mins) && Objects.equals(instructions, riTwo.instructions);

    }

    @Override
    public int hashCode() {

        return Objects.hash(rname, iname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions);

    }
}

