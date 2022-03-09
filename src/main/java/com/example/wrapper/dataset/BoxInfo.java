package com.example.wrapper.dataset;

public class BoxInfo{
    public String id;
    public String name;
    public String displayName;
    public String status;
    public String type;
    public String icon;
    public String color;
    public double x;
    public double y;
    public boolean allowInput;
    public boolean allowOutput;
    public boolean disableSettings;
    public boolean disableExecute;
    public String viewId;
    public boolean isViewRequired;
    public Options options;
    public boolean onHover;
    public boolean selected;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isAllowInput() {
        return allowInput;
    }

    public void setAllowInput(boolean allowInput) {
        this.allowInput = allowInput;
    }

    public boolean isAllowOutput() {
        return allowOutput;
    }

    public void setAllowOutput(boolean allowOutput) {
        this.allowOutput = allowOutput;
    }

    public boolean isDisableSettings() {
        return disableSettings;
    }

    public void setDisableSettings(boolean disableSettings) {
        this.disableSettings = disableSettings;
    }

    public boolean isDisableExecute() {
        return disableExecute;
    }

    public void setDisableExecute(boolean disableExecute) {
        this.disableExecute = disableExecute;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public boolean isOnHover() {
        return onHover;
    }

    public void setOnHover(boolean onHover) {
        this.onHover = onHover;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public boolean isViewRequired() {
        return isViewRequired;
    }

    public void setViewRequired(boolean viewRequired) {
        isViewRequired = viewRequired;
    }

    @Override
    public String toString() {
        return "BoxInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", allowInput=" + allowInput +
                ", allowOutput=" + allowOutput +
                ", disableSettings=" + disableSettings +
                ", disableExecute=" + disableExecute +
                ", viewId='" + viewId + '\'' +
                ", isViewRequired=" + isViewRequired +
                ", options=" + options +
                ", onHover=" + onHover +
                ", selected=" + selected +
                '}';
    }
}
