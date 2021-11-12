package com.nightowl.ingredients;

public class Ingredient {
    private Integer id;
    private String name;
    private String allergyCategory;

    public Ingredient(Integer id, String name, String allergyCategory) {
        this.id = id;
        this.name = name;
        this.allergyCategory = allergyCategory;
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

    public String getAllergyCategory() {
        return allergyCategory;
    }

    public void setAllergyCategory(String allergyCategory) {
        this.allergyCategory = allergyCategory;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", allergyCategory='" + allergyCategory + '\'' +
                '}';
    }
}
