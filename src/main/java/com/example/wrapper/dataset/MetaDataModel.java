package com.example.wrapper.dataset;

import java.util.Arrays;

public class MetaDataModel {
    /**
     * The categories.
     */
    private Category[] categories = new Category[0];

    /**
     * The id.
     */
    private String id;

    /**
     * The name.
     */
    private String name;

    /**
     * The domain id.
     */
    private String domainId;

    /**
     * The description.
     */
    private String description;

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MetaDataModel{" +
                "categories=" + Arrays.toString(categories) +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", domainId='" + domainId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
