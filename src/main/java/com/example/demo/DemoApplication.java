package com.example.demo;

import com.datastax.oss.driver.api.querybuilder.select.SelectFrom;
import com.datastax.oss.driver.api.querybuilder.term.Term;
import com.example.wrapper.dataset.Columns;
import org.hibernate.sql.Select;
import org.jooq.Condition;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import java.util.stream.Collectors;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom;
import static org.jooq.impl.DSL.name;


@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {


	@Autowired
	@Qualifier("trinoTemplate")
	private static JdbcTemplate jdbcTemplate;
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, SQLException, JSONException {
//		SpringApplication.run(DemoApplication.class, args);

//		Name viewName = name("mysql", "bi", "AnalyticsRepository");
//		String query = " show catalogs";
//		String query = " show tables from mysql.bi";
//		String query = " show schemas from mysql";
//		String query = "desc mysql.bi.analyticsrepository";
//		String query = "desc "+viewName;
//		String query = "show schemas from system";
//		String query = "desc system.metadata.catalogs";
//		String query = "select system.metadata.catalogs.connector_id,system.metadata.catalogs.connector_name,system.metadata.catalogs.catalog_name from system.metadata.catalogs";
//		String query = "select count(system.metadata.catalogs.connector_id) as connection_id from system.metadata.catalogs";
//		String query = "select system.metadata.catalogs.connector_id from system.metadata.catalogs";
		String query = "select distinct(system.metadata.catalogs.connector_id) as connector_id from system.metadata.catalogs where connector_id like '%my%'";
//		String query = "select count(connector_id) as \"connection_id\" , catalog_name  from system.metadata.catalogs group by (catalog_name)";
//		String query = "select * from system.metadata.catalogs";
//		String query = "select distinct(repositorytype) from mysql.bi.AnalyticsRepository limit 5";
//		String query = "select distinct(repositorytype) from mysql.bi.AnalyticsRepository";
		JSONObject obj = new JSONObject();
		 execute(query, obj);
//		 getColumn(obj);
//		 getColumnMeta(obj);
		System.out.println("obje ==> "+obj);
		System.out.println("resultset fetched : successfully");
	}


	public static void execute(String query, JSONObject obj) throws InvocationTargetException, IllegalAccessException, InstantiationException, SQLException {
		TrinoCofing trinoCofing = new TrinoCofing();
		JdbcTemplate jdbcTemplate = trinoCofing.trinoTemplate();
		try {
			List<Map<String, Object>> result = jdbcTemplate.queryForList(query, (Object[]) null);
			getJSONObjectFromMap(result,obj);
			System.out.println("list : "+obj);
//			jdbcTemplate.query(query, new RowCallbackHandler() {
//				public void processRow(ResultSet resultSet) throws SQLException {
//					System.out.println("get Row : "+resultSet.getFetchSize());
//					convertResultSet(resultSet,obj);
//				}
//			});
		}catch (Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public static JSONObject convertResultSet(ResultSet resultSet, JSONObject obj1) {
		try {
//			System.out.println("inside trino json object testing :"+resultSet.getMetaData().getColumnCount());
			JSONArray header = new JSONArray();
			JSONArray row = new JSONArray();
			JSONArray meta = new JSONArray();
			int l = 0;
			int totalRows = resultSet.getMetaData().getColumnCount();
			System.out.println("result set : "+resultSet.next());
			System.out.println("total number : {} "+ totalRows);
			while (resultSet.next()) {
				JSONArray row1 = new JSONArray();
				for (int j = 0; j < totalRows; j++) {
					String columnType = resultSet.getMetaData().getColumnTypeName(j + 1);
//					logger.info("Column Type while data formate : {} ", columnType);
					String hdr = resultSet.getMetaData().getColumnName(j + 1);
					System.out.println("hdr : "+hdr);
					JSONObject type = new JSONObject();
					type.put("columnName",hdr);
					if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.ARRAY) {
						row1.put(resultSet.getArray(hdr));
						type.put("columnType","LIST");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.BIGINT) {
//                        row1.put(resultSet.getInt(hdr));
                        row1.put(resultSet.getInt(j+1));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.BOOLEAN) {
                        row1.put(resultSet.getBoolean(hdr));
						type.put("columnType","BOOLEAN");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.BLOB) {
                        row1.put(resultSet.getBlob(hdr));
						type.put("columnType","BLOB");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.DOUBLE) {
                        row1.put(resultSet.getDouble(hdr));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.FLOAT) {
                        row1.put(resultSet.getFloat(hdr));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.INTEGER) {
                        row1.put(resultSet.getInt(hdr));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.NVARCHAR) {
                        row1.put(resultSet.getNString(hdr));
						type.put("columnType","STRING");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.VARCHAR) {
                        row1.put(resultSet.getString(hdr));
						type.put("columnType","STRING");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.TINYINT) {
                        row1.put(resultSet.getInt(hdr));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.SMALLINT) {
                        row1.put(resultSet.getInt(hdr));
						type.put("columnType","NUMERIC");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.DATE) {
                        row1.put(resultSet.getDate(hdr));
						type.put("columnType","DATE");
					} else if (resultSet.getMetaData().getColumnType(j+1) == java.sql.Types.TIMESTAMP) {
                        row1.put(resultSet.getTimestamp(hdr));
						type.put("columnType","DATE");
					} else if (resultSet.getMetaData().getColumnType(j+1) == Types.TIME_WITH_TIMEZONE) {
                        row1.put(resultSet.getTimestamp(hdr));
						type.put("columnType","DATE");
					} else {
                        row1.put(resultSet.getString(hdr));
						type.put("columnType","STRING");
					}

					if (l < totalRows) {
						header.put(hdr);
						meta.put(type);
						l++;
					}
				}
				row.put(row1);
			}
			obj1.put("header", header);
			obj1.put("row", row);
			obj1.put("meta",meta);
			System.out.println("final json object in Trino : ===>  {}"+ obj1);
			return obj1;
		} catch (Exception ex) {
			ex.printStackTrace();
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


	public static void getColumn(JSONObject obj) throws JSONException {
		JSONArray row = obj.getJSONArray("row");
		Columns[] column = new Columns[row.length()];
		for (int i = 0; i < row.length(); i++) {
			Columns col = new Columns();
			col.setAggTypes(getAggType((String) row.getJSONArray(i).get(1)));
//			col.setCategory("LC_"+info.getOutputUUID());
			col.setCategory("LC_"+ UUID.randomUUID().toString());
			col.setDescription("");
			col.setDisplayName(row.getJSONArray(i).get(0).toString());
			col.setDefaultAggType("NONE");
			col.setId(row.getJSONArray(i).get(0).toString());
			col.setName(row.getJSONArray(i).get(0).toString());
			col.setSelectedAggType("NONE");
			col.setGetHorizontalAlignment("LEFT");
			col.setType(getFieldTypeByType(((String) row.getJSONArray(i).get(1)).toLowerCase()));
			col.setActive(true);
			col.setFieldType(getFieldTypeByType(((String) row.getJSONArray(i).get(1)).toLowerCase()));
			column[i] = col;
		}
		for(int i=0; i<column.length; i++){
			System.out.println("column : "+column[i]);
		}
	}

	public static void getColumnMeta(JSONObject obj) throws JSONException {
		JSONArray meta = obj.getJSONArray("meta");
		Columns[] column = new Columns[meta.length()];
		for (int i = 0; i < meta.length(); i++) {
			Columns col = new Columns();
			col.setAggTypes(getAggType(meta.getJSONObject(i).getString("columnType")));
//			col.setCategory("LC_"+info.getOutputUUID());
			col.setCategory("LC_"+ UUID.randomUUID().toString());
			col.setDescription("");
			col.setDisplayName(meta.getJSONObject(i).getString("columnName"));
			col.setDefaultAggType("NONE");
			col.setId(meta.getJSONObject(i).getString("columnName"));
			col.setName(meta.getJSONObject(i).getString("columnName"));
			col.setSelectedAggType("NONE");
			col.setGetHorizontalAlignment("LEFT");
			col.setType(getFieldTypeByType(meta.getJSONObject(i).getString("columnName").toLowerCase()));
			col.setActive(true);
			col.setFieldType(getFieldTypeByType(meta.getJSONObject(i).getString("columnName").toLowerCase()));
			column[i] = col;
		}
		for(int i=0; i<column.length; i++){
			System.out.println("columnMeta : "+column[i]);
		}
	}

	public static String getFieldTypeByType(String type){
		switch (type) {
			case "int":
				return "NUMERIC";
			case "tinyint":
				return "BOOLEAN";
			case "json":
				return "JSON";
			case "datetime":
				return "DATE";
			default:
				return "STRING";
		}
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

	public static void getJSONObjectFromMap(List<Map<String,Object>> result, JSONObject obj1) throws JSONException {
		try {
			JSONArray header = new JSONArray();
			JSONArray meta = new JSONArray();
			JSONArray row1 = new JSONArray();
			int l = 0;
			for (Map<String, Object> map : result) {
				JSONArray row = new JSONArray();
				int totalRows = map.size();
				for (Map.Entry<String, Object> m : map.entrySet()) {
					JSONObject type = new JSONObject();
					row.put(m.getValue());
					String hdr = m.getKey();
					type.put("columnName", hdr);
					try {
						type.put("columnType", m.getValue().getClass().getName().replace(m.getValue().getClass().getPackageName() + ".", "").toUpperCase());
					} catch (Exception ex) {
						type.put("columnType", "STRING");
					}
					if (l < totalRows) {
						header.put(hdr);
						meta.put(type);
						l++;
					}
				}
				row1.put(row);
			}
			obj1.put("header", header);
			obj1.put("row", row1);
			obj1.put("meta", meta);
		}catch (JSONException ex){
			throw new JSONException(ex.getMessage());
		}
	}

	public void getSql(){

//		selectFrom("AnalyticsRepository").column("reposiotrytype").whereColumn("repositorytype").like(Term.appendTo("'%m%'"));
//		DSL.selectFrom("AnalyticsRepository").where(Condition.);
	}

}
