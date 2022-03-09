package com.example.wrapper.dataset;

import java.util.List;

public class Root{
    public List<BoxInfo> boxInfo;

    public List<BoxInfo> getBoxInfo() {
        return boxInfo;
    }

    public void setBoxInfo(List<BoxInfo> boxInfo) {
        this.boxInfo = boxInfo;
    }

    @Override
    public String toString() {
        return "Root{" +
                "boxInfo=" + boxInfo +
                '}';
    }
}
