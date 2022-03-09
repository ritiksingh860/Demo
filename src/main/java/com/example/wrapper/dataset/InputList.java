package com.example.wrapper.dataset;

public class InputList{
    public String id;
    public String name;
    public String displayName;
    public String type;
    public String status;
    public String icon;
    public int x;
    public int y;
    public boolean allowInput;
    public boolean allowOutput;
    public boolean disableSettings;
    public boolean disableExecute;
    public String viewId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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

    @Override
    public String toString() {
        return "InputList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", icon='" + icon + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", allowInput=" + allowInput +
                ", allowOutput=" + allowOutput +
                ", disableSettings=" + disableSettings +
                ", disableExecute=" + disableExecute +
                ", viewId='" + viewId + '\'' +
                ", options=" + options +
                ", onHover=" + onHover +
                ", selected=" + selected +
                '}';
    }
}
