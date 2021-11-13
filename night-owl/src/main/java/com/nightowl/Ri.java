package com.nightowl;


import java.util.Objects;

public class Ri {
    private Integer id;
    private Integer recipe_id;
    private Integer ingredient_id;

    public Ri(Integer id, Integer recipe_id, Integer ingredient_id) {
        this.id = id;
        this.recipe_id = recipe_id;
        this.ingredient_id = ingredient_id;
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

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    @Override
    public String toString() {
        return "Ri{" +
                "id=" + id +
                ", recipe_id=" + recipe_id +
                ", ingredient_id=" + ingredient_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ri ri = (Ri) o;
        return Objects.equals(id, ri.id) && Objects.equals(recipe_id, ri.recipe_id) && Objects.equals(ingredient_id, ri.ingredient_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe_id, ingredient_id);
    }


}
