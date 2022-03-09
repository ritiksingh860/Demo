package com.example.wrapper.dataset;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetColumnsResponseRow {

    private String name;
    private String type;

    public GetColumnsResponseRow(Map<String, Object> row) {
        this.name = (String) row.get("Column");
        this.type = (String) row.get("Type");

    }


}
