package com.example.demo;

import com.example.wrapper.dataset.Category;
import com.example.wrapper.dataset.Columns;
import com.example.wrapper.dataset.MetaDataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;


public class MetaModel {

    public static void main(String[] args) throws JSONException {
//        String str = "{\"header\":[\"Column\",\"Type\",\"Extra\",\"Comment\"],\"row\":[[\"connector_id\",\"varchar\",\"\",\"\"],[\"connector_name\",\"varchar\",\"\",\"\"]]}";

        String domainId = "test.xmi";
        String datasetName = "test";
        String viewId = "rendomgenerator";
        JSONObject obj = getJSON();
        System.out.println("obj ==> "+getJSON());
        MetaDataModel metaDataModel = new MetaDataModel();
        metaDataModel.setId("MODEL_1");
        metaDataModel.setName(datasetName);
        metaDataModel.setDomainId(domainId);
        metaDataModel.setCategories(getCategoryByJson(obj,domainId,viewId,datasetName));
        System.out.println("metaDataModel : "+metaDataModel.toString());
    }

    public static Category[] getCategoryByJson(JSONObject obj, String domainId, String viewId, String datasetName) throws JSONException {
        JSONArray row = obj.getJSONArray("row");
        Category[] cat = new Category[1];
        Category category = new Category();
        category.setId(viewId);
        category.setName(viewId);
        category.setDescription("This is the data model for "+datasetName);
        Columns[] column = new Columns[row.length()];
        for(int i=0; i<row.length(); i++){
            Columns col = new Columns();
            col.setAggTypes(getAggType((String) row.getJSONArray(i).get(1)));
            col.setCategory(viewId);
            col.setDescription("");
            col.setDisplayName(row.getJSONArray(i).get(0).toString());
            col.setId("LC_"+viewId+"_"+row.getJSONArray(i).get(0).toString());
            col.setName(row.getJSONArray(i).get(0).toString());
            col.setSelectedAggType("NONE");
            col.setGetHorizontalAlignment("LEFT");
            col.setType(((String) row.getJSONArray(i).get(1)).toUpperCase());
            col.setActive(true);
            column[i] = col;
        }
        category.setColumns(column);
        cat[0] = category;
        return cat;
    }

    public static JSONObject getJSON() throws JSONException {
        JSONArray ar = new JSONArray();
        ar.put("Column");
        ar.put("Type");
        ar.put("Extra");
        ar.put("Comment");
        JSONArray ar1 = new JSONArray();
        ar1.put("connector_id");
        ar1.put("varchar");
        ar1.put("");
        ar1.put("");
        JSONArray ar2 = new JSONArray();
        ar2.put("connector_name");
        ar2.put("varchar");
        ar2.put("");
        ar2.put("");
        JSONArray ar3 = new JSONArray();
        ar3.put(ar1);
        ar3.put(ar2);
        JSONObject obj = new JSONObject();
        obj.put("header",ar);
        obj.put("row",ar3);
        return obj;
    }

    public static List<String> getAggType(String type){
        List<String> str = new ArrayList<>();
        switch (type) {
            case "int":
                str.add("NONE");
                str.add("COUNT");
                str.add("COUNT_DISTINCT");
                str.add("AVERAGE");
                str.add("SUM");
                str.add("MINIMUM");
                str.add("MAXIMUM");
                return str;
            default:
                str.add("NONE");
                str.add("COUNT");
                str.add("COUNT_DISTINCT");
                return str;
        }
    }
}


