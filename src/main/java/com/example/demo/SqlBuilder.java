package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class SqlBuilder {

    public static void main(String args[]) {
    }

    public static String getDataFormatInSelection(String format) {
        Map<String, String> map = getDateFormatMap();
        String sqlFormat = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (format.equals(entry.getKey())) {
                sqlFormat = entry.getValue();
            }
        }
        sqlFormat = sqlFormat == null || sqlFormat.equals("") ? null : sqlFormat.replace("_", "%");
        return sqlFormat;
    }

    public static Map<String, String> getDateFormatMap() {
        Map<String, String> dateFormat = new HashMap<>();
        dateFormat.put("hh am/pm", "_h _p");
        dateFormat.put("HH", "_H");
        dateFormat.put("ww", "_V");
        dateFormat.put("MMM", "_b");
        dateFormat.put("ddd", "_d");
        dateFormat.put("D", "_j");
        dateFormat.put("MM/yyyy", "_d/_Y");
        dateFormat.put("MM-yyyy", "_d-_Y");
        dateFormat.put("dd/MM/yyyy", "_d/_c/_Y");
        dateFormat.put("MMM-dd-yyyy", "_b-_d-_Y");
        dateFormat.put("MM-dd-yy", "_c-_d-_y");
        dateFormat.put("yyyy-MMM-dd", "_Y-_b-_d");
        dateFormat.put("yyyy-MM-dd", "_Y-_c-_d");
        dateFormat.put("yy-MM-dd", "_y-_c-_d");
        dateFormat.put("dd.MM.yyyy", "_d._c._Y");
        dateFormat.put("dd-MMM-yyyy", "_d-_b-_Y");
        dateFormat.put("dd-MMM-yy", "_d-_b-_y");
        dateFormat.put("dd MMM", "_d _b");
        dateFormat.put("MM-yyyy hh:mm am/pm", "_c-_Y _h:_i _p");
        dateFormat.put("yyyy-MM-dd hh:mm am/pm", "_Y-_c-_d _h:_i _p");
        dateFormat.put("dd/MM/yyyy hh:mm am/pm", "_d/_c/_Y _h:_i _p");
        dateFormat.put("yy-MM-dd hh:mm am/pm", "_d-_c-_Y _h:_i _p");
        dateFormat.put("MM-yyyy HH:mm", "_c-_Y _H:_i");
        dateFormat.put("yyyy-MM-dd HH:mm", "_Y-_c-_d _h:_i");
        dateFormat.put("dd/MM/yyyy HH:mm", "_d/_c/_Y _h:_i");
        dateFormat.put("yy-MM-dd HH:mm", "_d-_c-_Y _h:_i");
        return dateFormat;
    }
}
