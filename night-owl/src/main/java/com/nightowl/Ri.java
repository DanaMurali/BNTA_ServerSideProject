package com.nightowl;


import java.util.Objects;

public class Ri {
    
    private Integer id;
    private Integer recipe_id;
    private Integer ingredients_id;

    public Ri(Integer id, Integer recipe_id, Integer ingredients_id) {
        this.id = id;
        this.recipe_id = recipe_id;
        this.ingredients_id = ingredients_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public Integer getIngredients_id() {
        return ingredients_id;
    }

    public void setIngredients_id(Integer ingredients_id) {
        this.ingredients_id = ingredients_id;
    }

    @Override
    public String toString() {
        return "Ri{" +
                "id=" + id +
                ", recipe_id=" + recipe_id +
                ", ingredients_id=" + ingredients_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ri ri = (Ri) o;
        return Objects.equals(id, ri.id) && Objects.equals(recipe_id, ri.recipe_id) && Objects.equals(ingredients_id, ri.ingredients_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe_id, ingredients_id);
    }
}
