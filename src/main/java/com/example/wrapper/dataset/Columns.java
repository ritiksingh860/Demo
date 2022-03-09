package com.example.wrapper.dataset;

import java.util.ArrayList;
import java.util.List;

public class Columns {

    /**
     * The id.
     */
    private String id;

    /**
     * The name.
     */
    private String name;

    /**
     * The description.
     */
    private String description;

    /**
     * The type.
     */
    private String type;

    /**
     * The agg types.
     */
    private List<String> aggTypes = new ArrayList<String>();

    /**
     * The default agg type.
     */
    private String defaultAggType;

    /**
     * The selected agg type.
     */
    private String selectedAggType;

    /**
     * The field type.
     */
    private String fieldType;

    /**
     * The category.
     */
    private String category;

    /**
     * The get horizontal alignment.
     */
    private String getHorizontalAlignment;

    /**
     * The format mask.
     */
    private String formatMask;


    /**
     * The display name.
     */
    private String displayName;

    /**
     * The isHidden.
     */
    private Boolean isHidden;

    private Boolean isActive;

    private String date;

    private String dateFormate;

    private String nameFirstIndex;

    private String defualtValue;

    private String value;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAggTypes() {
        return aggTypes;
    }

    public void setAggTypes(List<String> aggTypes) {
        this.aggTypes = aggTypes;
    }

    public String getDefaultAggType() {
        return defaultAggType;
    }

    public void setDefaultAggType(String defaultAggType) {
        this.defaultAggType = defaultAggType;
    }

    public String getSelectedAggType() {
        return selectedAggType;
    }

    public void setSelectedAggType(String selectedAggType) {
        this.selectedAggType = selectedAggType;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGetHorizontalAlignment() {
        return getHorizontalAlignment;
    }

    public void setGetHorizontalAlignment(String getHorizontalAlignment) {
        this.getHorizontalAlignment = getHorizontalAlignment;
    }

    public String getFormatMask() {
        return formatMask;
    }

    public void setFormatMask(String formatMask) {
        this.formatMask = formatMask;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateFormate() {
        return dateFormate;
    }

    public void setDateFormate(String dateFormate) {
        this.dateFormate = dateFormate;
    }

    public String getNameFirstIndex() {
        return nameFirstIndex;
    }

    public void setNameFirstIndex(String nameFirstIndex) {
        this.nameFirstIndex = nameFirstIndex;
    }

    public String getDefualtValue() {
        return defualtValue;
    }

    public void setDefualtValue(String defualtValue) {
        this.defualtValue = defualtValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Columns{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", aggTypes=" + aggTypes +
                ", defaultAggType='" + defaultAggType + '\'' +
                ", selectedAggType='" + selectedAggType + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", category='" + category + '\'' +
                ", getHorizontalAlignment='" + getHorizontalAlignment + '\'' +
                ", formatMask='" + formatMask + '\'' +
                ", displayName='" + displayName + '\'' +
                ", isHidden=" + isHidden +
                ", isActive=" + isActive +
                ", date='" + date + '\'' +
                ", dateFormate='" + dateFormate + '\'' +
                ", nameFirstIndex='" + nameFirstIndex + '\'' +
                ", defualtValue='" + defualtValue + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
