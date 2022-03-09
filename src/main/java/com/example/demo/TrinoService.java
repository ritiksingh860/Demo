package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TrinoService {

    @Autowired
    @Qualifier("trinoTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<ResultSet> checkTrinoStatus(String query){
        try {
            List<ResultSet> resultSets =  jdbcTemplate.query(query, new RowMapper<ResultSet>() {
                        public ResultSet mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return rs;
                        }
                    }
            );
            JSONObject obj = convertResultSet(resultSets.get(0));
            return resultSets;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public JSONObject convertResultSet(ResultSet resultSet) {
        try {
            JSONObject obj = new JSONObject();
            JSONArray header = new JSONArray();
            JSONArray row = new JSONArray();
            int l = 0;
            while (resultSet.next()) {
                int total_rows = resultSet.getMetaData().getColumnCount();
                JSONArray row1 = new JSONArray();
                for(int j=0; j < total_rows; j++){
                    String column_type = resultSet.getMetaData().getColumnTypeName(j+1);
                    System.out.println("Column Type while data formate : {}"+column_type);
                    String hdr = resultSet.getMetaData().getColumnName(j+1);
                    if(resultSet.getMetaData().getColumnType(j+1) == 93){
                        String date = resultSet.getString(j+1);
                        row1.put(date);
                    }else if(column_type.equalsIgnoreCase("SMALLINT") || column_type.equalsIgnoreCase("FLOAT") || column_type.equalsIgnoreCase("NUMERIC") || column_type.equalsIgnoreCase("TINYINT") ||
                            column_type.equalsIgnoreCase("INTEGER") || column_type.equalsIgnoreCase("INT") ||
                            column_type.equalsIgnoreCase("BIGINT") || column_type.equalsIgnoreCase("DOUBLE")){
                        Integer data = convertDataType(column_type, resultSet.getString(j+1));
                        System.out.println("data 1 ==> :{} "+data);
                        row1.put(data);
                    }else {
                        String data = resultSet.getString(j+1);
                        row1.put(data);
                    }
                    if(l < total_rows) {
                        header.put(hdr);
                        l++;
                    }
                }
                row.put(row1);
            }
            obj.put("header",header);
            obj.put("row",row);
            return obj;
        } catch (Exception ex) {
            System.out.println("exception occure while convert result set in json format");
            return null;
        }
    }

    //convert Data Type
    public static Integer convertDataType(String type, String data){
        Integer value = 0;
        try{
            if(type.equalsIgnoreCase("SMALLINT") || type.equalsIgnoreCase("NUMERIC") ||type.equalsIgnoreCase("TINYINT") ||
                    type.equalsIgnoreCase("INTEGER") || type.equalsIgnoreCase("INT") || type.equalsIgnoreCase("BIGINT")){
                value = Integer.valueOf(data);
            }
            if(type.equalsIgnoreCase("DOUBLE")){
                Double d1 = Double.valueOf(data);
                value = d1.intValue();
            }
            if(type.equalsIgnoreCase("FLOAT")){
                Float d1 = Float.valueOf(data);
                value = d1.intValue();
            }
        }catch (Exception ex){
            System.out.println("exception occuer while convert dataType");
        }
        return value;
    }
}
