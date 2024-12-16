package com.Petstore_Api.pojos;

public class CategoryPojo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public CategoryPojo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryPojo setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryPojo() {
    }

    public CategoryPojo(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public static CategoryPojo createCategoryModel(int categoryID, String categoryName) {
        return new CategoryPojo().setId(categoryID).setName(categoryName);
    }
    @Override
    public String toString() {
        return "CategoryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
