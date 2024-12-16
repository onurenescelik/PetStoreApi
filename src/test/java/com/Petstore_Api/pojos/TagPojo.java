package com.Petstore_Api.pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TagPojo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public TagPojo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TagPojo setName(String name) {
        this.name = name;
        return this;
    }

    public TagPojo() {
    }


    public static List<TagPojo> createTagModel(Map<Integer, String> idAndNameMap) {
        List<TagPojo> tagList = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : idAndNameMap.entrySet()) {
            TagPojo tagPojo = new TagPojo();
            tagPojo.setId(entry.getKey());
            tagPojo.setName(entry.getValue());
            tagList.add(tagPojo);
        }

        return tagList;
    }
    public static List<TagPojo> createTagModel(int tagID, String tagName) {
        return Collections.singletonList(new TagPojo().setId(tagID).setName(tagName));
    }

    @Override
    public String toString() {
        return "TagPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
