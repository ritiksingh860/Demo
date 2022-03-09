package com.example.wrapper.dataset;

import java.util.List;

public class Options {
    public SelectDatabase selectDatabase;
    public Configuration configuration;
    public List<InputList> inputList;
    public String grpByName;
    public List<ColToGrpByList> colToGrpByList;
    public List<AggregationSetting> aggregationSettings;

    public SelectDatabase getSelectDatabase() {
        return selectDatabase;
    }

    public void setSelectDatabase(SelectDatabase selectDatabase) {
        this.selectDatabase = selectDatabase;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<InputList> getInputList() {
        return inputList;
    }

    public void setInputList(List<InputList> inputList) {
        this.inputList = inputList;
    }

    public String getGrpByName() {
        return grpByName;
    }

    public void setGrpByName(String grpByName) {
        this.grpByName = grpByName;
    }

    public List<ColToGrpByList> getColToGrpByList() {
        return colToGrpByList;
    }

    public void setColToGrpByList(List<ColToGrpByList> colToGrpByList) {
        this.colToGrpByList = colToGrpByList;
    }

    public List<AggregationSetting> getAggregationSettings() {
        return aggregationSettings;
    }

    public void setAggregationSettings(List<AggregationSetting> aggregationSettings) {
        this.aggregationSettings = aggregationSettings;
    }

    @Override
    public String toString() {
        return "Options{" +
                "selectDatabase=" + selectDatabase +
                ", configuration=" + configuration +
                ", inputList=" + inputList +
                ", grpByName='" + grpByName + '\'' +
                ", colToGrpByList=" + colToGrpByList +
                ", aggregationSettings=" + aggregationSettings +
                '}';
    }
}
