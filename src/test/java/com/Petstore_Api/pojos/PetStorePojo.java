package com.Petstore_Api.pojos;

import java.util.*;

public class PetStorePojo {
    private Integer id;
    private CategoryPojo category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<TagPojo> tags = new ArrayList<>();
    private String status;

    public Integer getId() {
        return id;
    }

    public PetStorePojo setId(Integer id) {
        this.id = id;
        return this;
    }

    public CategoryPojo getCategory() {
        return category;
    }

    public PetStorePojo setCategory(CategoryPojo category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetStorePojo setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public PetStorePojo setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public List<TagPojo> getTags() {
        return tags;
    }

    public PetStorePojo setTags(List<TagPojo> tags) {
        this.tags = tags;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PetStorePojo setStatus(String status) {
        this.status = status;
        return this;
    }

    public PetStorePojo(){

}

    public static PetStorePojo autoFill(){

        Map<Integer, String> tagData = new HashMap<>();
        tagData.put(1, "Gill");

        List<String>photoUrls = new ArrayList<>(Arrays.asList("https://images.app.goo.gl/mhH988H3YMaU1C9K7"));

        return new PetStorePojo().
                setId(2).
                setName("fish").
                setCategory(CategoryPojo.createCategoryModel(1,"sea creatures")).
                setTags(TagPojo.createTagModel(tagData)).
                setStatus("available").
                setPhotoUrls(photoUrls);
    }

    @Override
    public String toString() {
        return "PetStorePojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
