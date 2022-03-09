package com.example.demo;

import com.example.wrapper.dataset.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.*;

public class CloneDatasetTest {

    public static void main(String[] args) throws JsonProcessingException, JSONException {
//        String str = "{\"boxInfo\":[{\"id\":\"1\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}]},\"selected\":true,\"onHover\":false},{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}],\"connections\":[{\"from\":\"2\",\"to\":\"1\",\"id\":\"k66ni4ljbcrwu259dxzh88\"}]}";
        //connection
//        String str = "{\"boxInfo\":[{\"id\":\"1\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}]},\"selected\":true,\"onHover\":false},{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}],\"connections\":[{\"from\":\"4\",\"to\":\"5\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"3\",\"to\":\"4\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"1\",\"to\":\"4\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"2\",\"to\":\"3\",\"id\":\"k66ni4ljbcrwu259dxzh88\"}]}";
        //multibox
        String str = "{\"boxInfo\":[{\"id\":\"2\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"selected\":true,\"onHover\":false},{\"id\":\"3\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}]},\"selected\":true,\"onHover\":false},{\"id\":\"4\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"1\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true},{\"id\":\"3\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}]},\"selected\":true,\"onHover\":false},{\"id\":\"5\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":486,\"y\":223.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"4\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}]},\"selected\":true,\"onHover\":false},{\"id\":\"1\",\"name\":\"Database\",\"displayName\":\"TestRcpAdvanceBI\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":491,\"y\":7,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestRcpAdvanceBI\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"system\",\"catalogsNames\":\"system\"},\"configuration\":{\"dataSourceType\":\"sqlQuery\",\"sqlQuery\":\"select * from catalogs\",\"schema\":\"metadata\",\"table\":\"\"}},\"viewId\":\"cvhuehllrsjctcknyzdpcjfv\",\"onHover\":false,\"selected\":true}],\"connections\":[{\"from\":\"4\",\"to\":\"5\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"3\",\"to\":\"4\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"1\",\"to\":\"4\",\"id\":\"k66ni4ljbcrwu259dxzh88\"},{\"from\":\"2\",\"to\":\"3\",\"id\":\"k66ni4ljbcrwu259dxzh88\"}]}";

        Gson g = new Gson();
        Dataset d = g.fromJson(str,Dataset.class);

        Set<String> parentNode = new HashSet<>();
        Set<String> childNode = new HashSet<>();
//        Map<String,Set<String>> parentMap = new HashMap<>();
//        getParentMap(d, parentMap, parentNode, childNode);
        for(BoxInfo b : d.getBoxInfo()){
            parentNode.add(b.getId());
        }
        Map<String,String> finalViewMap = new HashMap<>();
        Set<String> tempList = new HashSet<>();
        tempList.addAll(parentNode);

        iterateBox(d,finalViewMap,tempList);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(d);
        JSONObject json = new JSONObject(jsonStr);
//        System.out.println("final Dataset before setting up  : "+json);
        System.out.println("finalMap : "+finalViewMap);
        System.out.println("templist : "+tempList);

        getOutputUUID(d);

    }

    public static void getNewDataSetConfig(Dataset d, Map<String,String> finalViewMap){
        for(BoxInfo b : d.getBoxInfo()){
            b.setViewId(finalViewMap.get(b.getId()));
            if(b.getOptions().getInputList() != null && !b.getOptions().getInputList().isEmpty()){
                for(InputList in : b.getOptions().getInputList()){
                    in.setViewId(finalViewMap.get(in.getId()));
                }
            }
        }
    }

    public static void iterateBox(Dataset d, Map<String,String> finalViewMap, Set<String> tempList) throws JSONException {
        for (BoxInfo b : d.getBoxInfo()) {
            if(!finalViewMap.containsKey(b.getId())){
                if(b.getOptions().getInputList() == null) {
                    createDataSetView(b,d,finalViewMap,tempList);
                } else{
                    boolean flag = false;
                    for(InputList in : b.getOptions().getInputList()){
                        if(finalViewMap.containsKey(in.getId())) {
                            flag = true;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        createDataSetView(b,d,finalViewMap,tempList);
                    }
                }
            }
        }
        System.out.println("templist 1 : "+tempList);
        if(!tempList.isEmpty()){
            iterateBox(d,finalViewMap,tempList);
        }
    }

    public static void createDataSetView(BoxInfo b, Dataset d, Map<String,String> finalViewMap, Set<String> tempList) throws JSONException {
        tempList.remove(b.getId());
        d.setBoxId(b.getId());
        JSONObject obj = createView(d);
        finalViewMap.put(b.getId(), (String) obj.get("viewId"));
        getNewDataSetConfig(d,finalViewMap);
    }

    public static JSONObject createView(Dataset d) throws JSONException {
        System.out.println("box Id : "+d.getBoxId());
        JSONObject obj = new JSONObject();
        obj.put("status", "VIEW_CREATED_SUCCESSFULLY");
        obj.put("viewId", UUID.randomUUID().toString());
        return obj;
    }

    //to child from parent
    public static void getChildMap(Dataset d){
        Map<String,Set<String>> childMap = new HashMap<>();
        for(Connection c : d.getConnections()){
            for(Connection c1 : d.getConnections()){
                Set<String> s = new HashSet<>();
                if(c.getTo().equalsIgnoreCase(c1.getTo())){
                    if(!childMap.isEmpty() && childMap.containsKey(c.getTo())){
                        Set<String> s1 = childMap.get(c.getTo());
                        s1.add(c.getFrom());
                        childMap.replace(c.getTo(),childMap.get(c.getTo()),s1);
                    }else {
                        s.add(c.getFrom());
                        childMap.put(c.getTo(), s);
                    }
                }
            }
        }
        System.out.println("childMap : "+childMap);
    }

    //to child from parent
    public static void getParentMap(Dataset d, Map<String,Set<String>> parentMap, Set<String> parentNode, Set<String> childNode){
        for(Connection c : d.getConnections()){
            for(Connection c1 : d.getConnections()){
                Set<String> s = new HashSet<>();
                if(c.getFrom().equalsIgnoreCase(c1.getFrom())){
                    if(!parentMap.isEmpty() && parentMap.containsKey(c.getFrom())){
                        Set<String> s1 = parentMap.get(c.getFrom());
                        s1.add(c.getTo());
                        parentMap.replace(c.getFrom(),parentMap.get(c.getFrom()),s1);
                    }else {
                        s.add(c.getTo());
                        parentMap.put(c.getFrom(), s);
                    }
                }
            }
        }
        System.out.println("parentMap : "+parentMap);
        getChildList(parentMap);
        getParentList(parentMap,parentNode);
    }

    public static void getParentList(Map<String,Set<String>> parentMap, Set<String> parentList ){
        for(Map.Entry<String,Set<String>> m : parentMap.entrySet()){
            parentList.add(m.getKey());
        }
        System.out.println("parent List : "+parentList);
    }

    public static void getChildList(Map<String,Set<String>> parentMap ){
        Set<String> childList = new HashSet<>();
        for(Map.Entry<String,Set<String>> m : parentMap.entrySet()){
            childList.addAll(m.getValue());
        }
        System.out.println("childList List : "+childList);
    }

    public static void getOutputUUID(Dataset d) {
        System.out.println("final Dataset before setting up  : "+d.toString());
        String outputViewId = null;
        for(BoxInfo b : d.getBoxInfo()){
            if(b.getType().equalsIgnoreCase("output")){
                System.out.println("box Type : "+b.getType()+ "  boxId : "+b.getId());
                outputViewId = b.getViewId();
            }
        }
        System.out.println("final outputView id : "+outputViewId);
    }
}
