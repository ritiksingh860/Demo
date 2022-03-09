package com.example.wrapper.dataset;

import java.util.Arrays;

public class Category {

    /**
     * The description.
     */
    private String id, name, description;

    /**
     * The columns.
     */
    private Columns[] columns = new Columns[0];


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Columns[] getColumns() {
        return columns;
    }

    public void setColumns(Columns[] columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", columns=" + Arrays.toString(columns) +
                '}';
    }
}
