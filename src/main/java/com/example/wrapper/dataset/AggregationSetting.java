package com.example.wrapper.dataset;

public class AggregationSetting {
    public NewColName newColName;
    public Operation operation;
    public Column column;

    public NewColName getNewColName() {
        return newColName;
    }

    public void setNewColName(NewColName newColName) {
        this.newColName = newColName;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "AggregationSetting{" +
                "newColName=" + newColName +
                ", operation=" + operation +
                ", column=" + column +
                '}';
    }
}
