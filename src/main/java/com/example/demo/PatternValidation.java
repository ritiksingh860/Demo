package com.example.demo;

import com.google.gson.Gson;
import org.jooq.JSON;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.el.EvaluationListener;
import java.util.*;

public class PatternValidation {


    public static void main(String[] args) throws JSONException {
        String str1 = "jdbc:mysql://address=(protocol=tcp)(host=240b:c0e0:103:544d:b472:2:1:0)(port=32711)/";
        String pattern = "^jdbc:mysql://[A-Za-z0-9=():? ]*$";
        System.out.println(str1.matches(pattern));

        String str = "{\"name\": \"MY_SQL\", \"type\": \"database\", \"value\": \"mysql\", \"disable\": false, \"iconName\": \"mysql\", \"selected\": false, \"description\": \"MY_SQL_DATA_BASE_CONNECTION\", \"pointerEvent\": \"auto\", \"propertyDetails\": [{\"key\": \"connector.name\", \"max\": null, \"min\": null, \"flex\": \"25\", \"label\": \"CONNECTOR_TYPE\", \"langKey\": \"ADS_CONNECTOR_NAME\", \"pattern\": null, \"customMsg\": {\"required\": \"CONNECTOR_TYPE_IS_REQUIRED\"}, \"inputType\": \"text\", \"maxlenght\": 50, \"isReadOnly\": true, \"isRequired\": true, \"description\": \"Connectortypeforselecteddatabase\", \"defaultValue\": \"mysql\"}, {\"key\": \"connection-url\", \"max\": null, \"min\": null, \"label\": \"CONNECTION_URL\", \"langKey\": \"ADS_CONNECTION_URL\", \"pattern\":\"jdbc:[mysql-mariadb]+://[A-Za-z0-9=():?.-]*\", \"customMsg\": {\"pattern\": \"JDBC_PATTERN_CAN_NOT_MATCHED\", \"required\": \"CONNECTION_URL_IS_REQUIRED\"}, \"inputType\": \"text\", \"maxlenght\": 100, \"isReadOnly\": false, \"isRequired\": true, \"description\": \"ConnectionURLforselecteddatabasetype.\"}, {\"key\": \"connection-user\", \"max\": null, \"min\": null, \"label\": \"CONNECTION_USER\", \"langKey\": \"ADS_CONNECTION_USER\", \"pattern\": null, \"customMsg\": {\"required\": \"CONNECTION_USER_IS_REQUIRED\"}, \"inputType\": \"text\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": true, \"description\": \"Databaseusername\"}, {\"key\": \"connection-password\", \"max\": null, \"min\": null, \"label\": \"CONNECTION_PASSWORD\", \"langKey\": \"ADS_CONNECTION_PASSWORD\", \"pattern\": null, \"customMsg\": {\"required\": \"CONNECTION_PASSWORD_IS_REQUIRED\"}, \"inputType\": \"password\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": true, \"description\": \"Databaseusername\"}, {\"key\": \"case-insensitive-name-matching\", \"max\": null, \"min\": null, \"label\": \"case-insensitive-name-matching\", \"langKey\": \"ADS_CASE_INSENSITIVE_NAME_MATCHING\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"boolean\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Supportcaseinsensitiveschemaandtablenames.\", \"defaultValue\": false}, {\"key\": \"case-insensitive-name-matching.cache-ttl\", \"max\": null, \"min\": null, \"label\": \"case-insensitive-name-matching.cache-ttl\", \"langKey\": \"ADS_CASE_INSENSITIVE_NAME_MATCHING\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"boolean\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Supportcaseinsensitiveschemaandtablenames.\", \"defaultValue\": false}, {\"key\": \"case-insensitive-name-matching.config-file\", \"max\": null, \"min\": null, \"label\": \"case-insensitive-name-matching.config-file\", \"langKey\": \"ADS_CI_NAME_MATCHING_CONFIG_FILE\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"text\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"PathtoanamemappingconfigurationfileinJSONformatthatallowsTrinotodisambiguatebetweenschemasandtableswithsimilarnamesindifferentcases.\", \"defaultValue\": null}, {\"key\": \"case-insensitive-name-matching.refresh-period\", \"max\": null, \"min\": 0, \"label\": \"case-insensitive-name-matching.refresh-period\", \"langKey\": \"ADS_CI_NAME_MATCHING_REFRESH_PERIOD\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"number\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"FrequencywithwhichTrinochecksthenamematchingconfigurationfileforchanges.\", \"defaultValue\": 0}, {\"key\": \"metadata.cache-ttl\", \"max\": null, \"min\": 0, \"label\": \"metadata.cache-ttl\", \"langKey\": \"ADS_METADATA_CACHE_TTL\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"number\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Durationforwhichmetadata,includingtableandcolumnstatistics,iscached.\", \"defaultValue\": 0}, {\"key\": \"metadata.cache-missing\", \"max\": null, \"min\": null, \"label\": \"metadata.cache-missing\", \"langKey\": \"ADS_METADATA_CACHE_MISSING\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"boolean\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Cachethefactthatmetadata,includingtableandcolumnstatistics,isnotavailable\", \"defaultValue\": false}, {\"key\": \"metadata.cache-maximum-size\", \"max\": null, \"min\": 0, \"label\": \"metadata.cache-maximum-size\", \"langKey\": \"ADS_METADATA_CACHE_MAXIMUM_SIZE\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"number\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Maximumnumberofobjectsstoredinthemetadatacache\", \"defaultValue\": 10000}, {\"key\": \"write.batch-size\", \"max\": 100, \"min\": 100, \"label\": \"write.batch-size\", \"langKey\": \"ADS_WRITE_BATCH_SIZE\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"number\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Maximumnumberofstatementsinabatchedexecution.Donotchangethissettingfromthedefault.Non-defaultvaluesmaynegativelyimpactperformance.\", \"defaultValue\": 100}, {\"key\": \"join-pushdown.enabled\", \"max\": null, \"min\": null, \"label\": \"join-pushdown.enabled\", \"langKey\": \"ADS_JOIN_PUSHDOWN_ENABLED\", \"pattern\": null, \"customMsg\": {\"pattern\": \"ONLY_NUMBER_ALLOWD\", \"required\": \"CONNECTION_NAME_IS_REQUIRED\"}, \"inputType\": \"boolean\", \"maxlenght\": 80, \"isReadOnly\": false, \"isRequired\": false, \"description\": \"Enablejoinpushdown.Equivalentcatalogsessionpropertyisjoin_pushdown_enabled.Enablingthismaynegativelyimpactperformanceforsomequeries.\", \"defaultValue\": false}]}";
        Gson g = new Gson();
        JSONObject obj = new JSONObject(str);
        System.out.println("pattrn json : "+obj);
        String configStr = "{\"connector.name\":\"mysql\",\"connection-url\":\"jdbc:mysql://address=(protocol=tcp)(host=240b:c0e0:103:544d:b472:2:1:0)(port=32711)\",\"connection-user\":\"miniku\",\"connection-password\":\"miniku@123\"}";
        JSONObject extraConfig = new JSONObject(configStr);
        System.out.println("extraconfig : "+extraConfig);
        validateDataSource(obj,extraConfig);
    }

    public static void validateDataSource(JSONObject config, JSONObject jsonObject) {
        System.out.println("Inside  @class :DataSourceServiceImpl @Method :validateDataSource @Param: dataSource: {} ");
        try {
            JSONObject response = new JSONObject();
            response.put("status", "failure");
            Map<String,String> map = new HashMap<>();
            Iterator<String> keysItr = jsonObject.keys();
            while(keysItr.hasNext()) {
                String key = keysItr.next();
                String value = jsonObject.getString(key);
                map.put(key, value);
            }
            for (Map.Entry<String,String> m : map.entrySet()) {
                String key = m.getKey();
                String value = m.getValue();
                JSONArray propertyDetails = config.getJSONArray("propertyDetails");
                for (int i = 0; i < propertyDetails.length(); i++) {
                    String inputType = propertyDetails.getJSONObject(i).getString("inputType");
                    String propertyKey = propertyDetails.getJSONObject(i).getString("key");
                    if (key.equalsIgnoreCase(propertyKey)) {
                        String pattern = propertyDetails.getJSONObject(i).getString("pattern") == null ? null : propertyDetails.getJSONObject(i).getString("pattern");
                        if(!pattern.equalsIgnoreCase("null") ) {
                            if (inputType.equals("text") && !value.matches(pattern)) {
                                throw new Exception("{\"status\":\"failure\",\"message\":\"Invalid value of "+propertyKey+"\"}");
                            }
                            if (inputType.equalsIgnoreCase("boolean")) {
                                if (!value.contains("true") || !value.contains("false")) {
                                    throw new Exception("{\"status\":\"failure\",\"message\":\"Invalid value of "+propertyKey+"\"}");
                                }
                            }
                            if (inputType.equalsIgnoreCase("number")) {
                                Integer max = propertyDetails.getJSONObject(i).getString("max") == null ? 0 : propertyDetails.getJSONObject(i).getInt("max");
                                Integer min = propertyDetails.getJSONObject(i).getString("min") == null ? 0 : propertyDetails.getJSONObject(i).getInt("min");
                                int values = Integer.parseInt(value);
                                if (values < min && values > max) {
                                    throw new Exception("{\"status\":\"failure\",\"message\":\"Invalid value of "+propertyKey+"\"}");
                                }
                            }
                            if(inputType.equalsIgnoreCase("password") || inputType.equalsIgnoreCase("text")){
                                Integer maxLength = propertyDetails.getJSONObject(i).getInt("maxlenght");
                                if(value.length() > maxLength){
                                    throw new Exception("{\"status\":\"failure\",\"message\":\"Invalid value length of "+propertyKey+"\"}");
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in validateDataSource  : {} "+ e);
        }
    }
}

