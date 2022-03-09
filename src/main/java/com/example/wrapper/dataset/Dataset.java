package com.example.wrapper.dataset;

import java.util.List;
import java.util.Set;

public class Dataset {
    Set<BoxInfo> boxInfo;
    List<Connection> connections;
    String boxId;

    public Set<BoxInfo> getBoxInfo() {
        return boxInfo;
    }

    public void setBoxInfo(Set<BoxInfo> boxInfo) {
        this.boxInfo = boxInfo;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "boxInfo=" + boxInfo +
                ", connections=" + connections +
                ", boxId='" + boxId + '\'' +
                '}';
    }
}
