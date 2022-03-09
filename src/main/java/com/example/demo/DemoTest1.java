package com.example.demo;

import com.example.wrapper.dataset.BoxInfo;
import com.example.wrapper.dataset.Connection;
import com.example.wrapper.dataset.Dataset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import netscape.javascript.JSObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;



public class DemoTest1 {

    public static void main(String[] args) throws JsonProcessingException, JSONException {
//        SpringApplication.run(DemoApplication.class, args);
//
//        String str = "{\"boxInfo\":[{\"id\":\"1\",\"viewId\":\"abc\"},{\"id\":\"2\",\"viewId\":\"xyz\"},{\"id\":\"3\",\"viewId\":\"pqr\"},{\"id\":\"4\",\"viewId\":\"pqr\"}],\"connections\":[{\"to\":\"1\",\"from\":\"3\",\"id\":\"skjd\"},{\"to\":\"2\",\"from\":\"3\",\"id\":\"skjd\"},{\"to\":\"3\",\"from\":\"4\",\"id\":\"skjd\"}],\"viewId\":\"pqr\"}";
        String str = "{\"boxInfo\":[{\"id\":\"1\",\"name\":\"Output\",\"displayName\":\"Output\",\"status\":\"valid\",\"type\":\"output\",\"icon\":\"Database\",\"color\":\"\",\"x\":416,\"y\":251.26041412353516,\"allowInput\":false,\"allowOutput\":false,\"disableSettings\":true,\"disableExecute\":false,\"options\":{\"inputList\":[{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestConnectionbicreatetest\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":401,\"y\":40,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestConnectionbicreatetest\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"tpcds\"},\"configuration\":{\"dataSourceType\":\"databaseTables\",\"sqlQuery\":\"\",\"schema\":\"sf1\",\"table\":\"catalog_returns\"}},\"viewId\":\"catalog_returns\",\"onHover\":false,\"selected\":true}]},\"onHover\":false,\"selected\":true},{\"id\":\"2\",\"name\":\"Database\",\"displayName\":\"TestConnectionbicreatetest\",\"type\":\"dataSources\",\"status\":\"valid\",\"icon\":\"Database\",\"x\":401,\"y\":40,\"allowInput\":false,\"allowOutput\":true,\"disableSettings\":false,\"disableExecute\":false,\"options\":{\"selectDatabase\":{\"connectionName\":\"TestConnectionbicreatetest\",\"connectionType\":\"MYSQL\",\"uniqueId\":\"tpcds\"},\"configuration\":{\"dataSourceType\":\"databaseTables\",\"sqlQuery\":\"\",\"schema\":\"sf1\",\"table\":\"catalog_returns\"}},\"viewId\":\"catalog_returns\",\"onHover\":false,\"selected\":true}],\"connections\":[{\"from\":\"2\",\"to\":\"1\",\"id\":\"pw40xlujkh76e57v65c6ej\"}]}";
        Gson g = new Gson();
        Dataset d = g.fromJson(str,Dataset.class);
        System.out.println("box : "+d.toString());
        Set<BoxInfo> b = new HashSet<>();

        Map<String,Set<String>> childMap = new HashMap<>();
        Map<String,Set<String>> parentMap = new HashMap<>();

        // child Map
        for(Connection c : d.getConnections()){
            Set<String> toList = new HashSet<>();
            toList.add(c.getTo());
            if(!childMap.isEmpty()){
                for(Map.Entry<String,Set<String>> m : childMap.entrySet()){
                    if(m.getKey().equalsIgnoreCase(c.getFrom())){
                        Set<String> fromList = m.getValue();
                        fromList.add(c.getTo());
                        childMap.replace(m.getKey(),m.getValue(),fromList);
                    }else{
                        childMap.put(c.getFrom(),toList);
                    }
                }
            }else{
                childMap.put(c.getFrom(),toList);
            }
        }
        System.out.println("child Map : "+childMap);

        Set<BoxInfo> boxList = getBoxList(d,childMap);
        d.setBoxInfo(boxList);
        System.out.println("boxList 3  "+boxList.toString());

    }

    public static Set<BoxInfo> getBoxList(Dataset d, Map<String,Set<String>> childMap){
        Set<BoxInfo> boxList = new HashSet<>();
        String lastBoxId = null;
        for(Map.Entry<String,Set<String>> m : childMap.entrySet()){
            System.out.println("inside Map "+m.getKey());
            Set<String> parentList = m.getValue();
            lastBoxId = m.getKey();
            for(String s : parentList){
                for(BoxInfo box : d.getBoxInfo()){
                    if(box.getId().equalsIgnoreCase(s)){
                        // TODO update view as per parent box
                        box = setParentViewId(d, box, childMap.get(box.getId()), boxList);
                        String viewId = generateView(box);
                        box.setViewId(viewId);
                        boxList.add(box);
                    }
                }
            }
        }
        for(BoxInfo box : d.getBoxInfo()){
            for(BoxInfo b : boxList){
                if(box.getId().equalsIgnoreCase(lastBoxId) && lastBoxId != null && !b.getId().equalsIgnoreCase(lastBoxId)){
                    // TODO update view as per parent box
                    box = setParentViewId(d, box, childMap.get(box.getId()), boxList);
                    String viewId = generateView(box);
                    box.setViewId(viewId);
                    boxList.add(box);
                    break;
                }
            }
        }
        return boxList;
    }

    public static BoxInfo setParentViewId(Dataset d , BoxInfo b, Set<String> parentBoxIds, Set<BoxInfo> finalBoxList){
        // TODO setChildBox info as per there parent ViewId get parent boxInfo from finalBoxList
        System.out.println("parenBox list : "+parentBoxIds+ "   boxId "+b.getId());
        for(Connection c : d.getConnections()){
            if(c.getFrom().equalsIgnoreCase(b.getId())){
                for(BoxInfo box : d.getBoxInfo()){
                    if(box.getId().equalsIgnoreCase(c.getTo())){
                        System.out.println("childBox : "+b.getId()+"   parentBoxId : "+box.getId());
                        b.setViewId(box.getViewId());
                    }
                }
            }
        }
        return b;
    }

    public static String generateView(BoxInfo b){
        String viewId = RandomStringUtils.randomAlphabetic(24).toLowerCase();
        System.out.println("viewId : "+viewId+"   boxId : "+b.getId());
        return viewId;
    }


    public static Dataset getDatasetInfo(){
        String str ="{\n" +
                "  \"boxInfo\": [\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"Output\",\n" +
                "      \"displayName\": \"Output\",\n" +
                "      \"status\": \"normal\",\n" +
                "      \"type\": \"output\",\n" +
                "      \"icon\": \"Database\",\n" +
                "      \"color\": \"\",\n" +
                "      \"x\": 20,\n" +
                "      \"y\": 350,\n" +
                "      \"allowInput\": true,\n" +
                "      \"allowOutput\": false,\n" +
                "      \"disableSettings\": true,\n" +
                "      \"disableExecute\": true,\n" +
                "      \"viewId\": null,\n" +
                "      \"isViewAtRequired\": true,\n" +
                "      \"options\": {\n" +
                "        \"inputList\": []\n" +
                "      },\n" +
                "      \"selected\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"Database\",\n" +
                "      \"displayName\": \"Database\",\n" +
                "      \"type\": \"dataSources\",\n" +
                "      \"status\": \"valid\",\n" +
                "      \"icon\": \"Database\",\n" +
                "      \"x\": 325,\n" +
                "      \"y\": 53,\n" +
                "      \"allowInput\": false,\n" +
                "      \"allowOutput\": true,\n" +
                "      \"disableSettings\": false,\n" +
                "      \"disableExecute\": false,\n" +
                "      \"viewId\": \"xyz\",\n" +
                "      \"isViewRequired\": true,\n" +
                "      \"options\": {\n" +
                "        \"selectDatabase\": {\n" +
                "          \"connectionName\": \"Database\",\n" +
                "          \"databaseType\": \"MySQL\",\n" +
                "          \"ipAddress\": \"\",\n" +
                "          \"portNumber\": \"\",\n" +
                "          \"sidOrServiceName\": \"\",\n" +
                "          \"databaseService\": \"\",\n" +
                "          \"username\": \"\",\n" +
                "          \"password\": \"\"\n" +
                "        },\n" +
                "        \"configuration\": {\n" +
                "          \"dataSourceType\": \"sqlQuery\",\n" +
                "          \"sqlQuery\": \"\",\n" +
                "          \"schema\": \"\",\n" +
                "          \"table\": \"\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"onHover\": false,\n" +
                "      \"selected\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"Join\",\n" +
                "      \"displayName\": \"Join\",\n" +
                "      \"type\": \"mergeData\",\n" +
                "      \"status\": \"normal\",\n" +
                "      \"icon\": \"file-Outline\",\n" +
                "      \"x\": 535,\n" +
                "      \"y\": 220,\n" +
                "      \"allowInput\": true,\n" +
                "      \"allowOutput\": false,\n" +
                "      \"disableSettings\": true,\n" +
                "      \"disableExecute\": true,\n" +
                "      \"viewId\": null,\n" +
                "      \"isViewAtRequired\": true,\n" +
                "      \"options\": {\n" +
                "        \"joinName\": \"Join\",\n" +
                "        \"source1\": {\n" +
                "          \"name\": \"\",\n" +
                "          \"rows\": 0,\n" +
                "          \"colList\": [\n" +
                "            \"State\",\n" +
                "            \"Date\",\n" +
                "            \"Forecast\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"source2\": {\n" +
                "          \"name\": \"\",\n" +
                "          \"rows\": 0,\n" +
                "          \"colList\": [\n" +
                "            \"State\",\n" +
                "            \"Date\",\n" +
                "            \"Forecast\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"selectedJoinType\": {\n" +
                "          \"name\": \"Inner\",\n" +
                "          \"icon\": \"inner\",\n" +
                "          \"selected\": true\n" +
                "        },\n" +
                "        \"joinRatioData\": {\n" +
                "          \"percent\": 25,\n" +
                "          \"color\": \"#F53A3A\"\n" +
                "        },\n" +
                "        \"joinMatchingList\": [\n" +
                "          {\n" +
                "            \"option1\": null,\n" +
                "            \"option2\": null,\n" +
                "            \"comparator\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"inputList\": [\n" +
                "          {\n" +
                "            \"id\": \"2\",\n" +
                "            \"name\": \"Database\",\n" +
                "            \"displayName\": \"Database\",\n" +
                "            \"type\": \"dataSources\",\n" +
                "            \"status\": \"valid\",\n" +
                "            \"icon\": \"Database\",\n" +
                "            \"x\": 325,\n" +
                "            \"y\": 53,\n" +
                "            \"allowInput\": false,\n" +
                "            \"allowOutput\": true,\n" +
                "            \"disableSettings\": false,\n" +
                "            \"disableExecute\": false,\n" +
                "            \"viewId\": null,\n" +
                "\t\t\t\"isViewAtRequired\": true,\n" +
                "            \"options\": {\n" +
                "              \"selectDatabase\": {\n" +
                "                \"connectionName\": \"Database\",\n" +
                "                \"databaseType\": \"MySQL\",\n" +
                "                \"ipAddress\": \"\",\n" +
                "                \"portNumber\": \"\",\n" +
                "                \"sidOrServiceName\": \"\",\n" +
                "                \"databaseService\": \"\",\n" +
                "                \"username\": \"\",\n" +
                "                \"password\": \"\"\n" +
                "              },\n" +
                "              \"configuration\": {\n" +
                "                \"dataSourceType\": \"sqlQuery\",\n" +
                "                \"sqlQuery\": \"\",\n" +
                "                \"schema\": \"\",\n" +
                "                \"table\": \"\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"onHover\": false,\n" +
                "            \"selected\": false\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"onHover\": false,\n" +
                "      \"selected\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"File\",\n" +
                "      \"displayName\": \"File\",\n" +
                "      \"type\": \"dataSources\",\n" +
                "      \"status\": \"invalid\",\n" +
                "      \"icon\": \"file-Outline\",\n" +
                "      \"x\": 227,\n" +
                "      \"y\": 99,\n" +
                "      \"allowInput\": false,\n" +
                "      \"allowOutput\": false,\n" +
                "      \"disableSettings\": false,\n" +
                "      \"disableExecute\": true,\n" +
                "      \"viewId\": null,\n" +
                "      \"isViewAtRequired\": true,\n" +
                "      \"options\": {\n" +
                "        \"selectFile\": {\n" +
                "          \"blockName\": \"File\",\n" +
                "          \"fileType\": {\n" +
                "            \"name\": \"\",\n" +
                "            \"value\": \"\"\n" +
                "          },\n" +
                "          \"uploadedFile\": {}\n" +
                "        },\n" +
                "        \"configuration\": {\n" +
                "          \"fileEncoding\": {},\n" +
                "          \"delimiter\": {},\n" +
                "          \"detectDataTypeUsing\": {},\n" +
                "          \"headingRow\": {}\n" +
                "        },\n" +
                "        \"colDef\": []\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"connections\": [\n" +
                "    {\n" +
                "      \"from\": \"2\",\n" +
                "      \"to\": \"1\",\n" +
                "      \"id\": \"95t8kn05vi9phml8hpnakg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"viewId\": \"1\"\n" +
                "}";

        Gson g = new Gson();
        Dataset d = g.fromJson(str,Dataset.class);
        System.out.println("data set : ==> "+d.toString());
        System.out.println("data set : ==> "+d.getBoxInfo().size());

        String toBoxId = null;
        String parentViewId= null;
        String fromBoxId = null;

        // here get to or from box id from connection object of particular box
        for(BoxInfo b : d.getBoxInfo()){
            System.out.println("box type ==>: "+b.getType());
            if(b.getType().equalsIgnoreCase("output")){
                for(Connection c : d.getConnections()){
                    if (b.getId().equalsIgnoreCase(c.getFrom())) {
                        toBoxId = c.getTo();
                        fromBoxId = b.getId();
                    }
                }
            }
        }

        // get parent viewId using toBoxId available in connection object
        for(BoxInfo b : d.getBoxInfo()){
            if(b.getId().equalsIgnoreCase(toBoxId)){
                parentViewId = b.getViewId();
            }
        }

        System.out.println("fromBoxId : "+fromBoxId+"  toBoxId : "+toBoxId+"  parentViewId : "+parentViewId);
        System.out.println("frombox list : {}"+ d.getBoxInfo());
        // here set parentViewId in output box using fromBoxId available in connection object
        Set<BoxInfo> boxList = new HashSet<>();
        for(BoxInfo b : d.getBoxInfo()){
            if(b.getId().equalsIgnoreCase(fromBoxId)){
                b.setViewId(parentViewId);
            }
            boxList.add(b);
        }

        System.out.println("final box list : "+boxList);
        d.setBoxInfo(boxList);
        System.out.println("final dataset object : "+d.toString());
        return d;
    }
}
