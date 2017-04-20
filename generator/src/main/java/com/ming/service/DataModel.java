package com.ming.service;

import com.ming.util.DbUtil;
import com.ming.util.PropertiesUtil;
import com.ming.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicholas on 2017/1/18.
 */
public class DataModel {
    public static Map<String, Object> getDataModel(String module, List columnList) {
        Map<String, Object> model = new HashMap<>();

        model.put("templateName", PropertiesUtil.getConfig(module + ".templateName"));
        model.put("packageName", PropertiesUtil.getConfig(module + ".packageName"));
        model.put("extName", PropertiesUtil.getConfig(module + ".extName"));

        String extName = PropertiesUtil.getConfig(module + ".extName");
        String classLastName = extName.substring(0, extName.indexOf("."));
        model.put("classLastName", classLastName);

        model.put("tableName", PropertiesUtil.getConfig("tableName"));
        model.put("className", PropertiesUtil.getConfig("tableName").replace(PropertiesUtil.getConfig("prefix"), ""));
        model.put("ClassName", StringUtil.underlineToCamel(PropertiesUtil.getConfig("tableName").replace(PropertiesUtil.getConfig("prefix"), ""), true));
        model.put("primaryKey", DbUtil.primaryKey());
        model.put("PrimaryKey", StringUtil.underlineToCamel(DbUtil.primaryKey(), true));
        model.put("columnList", columnList);
        model.put("entityPackageName", PropertiesUtil.getConfig("entity.packageName"));
        model.put("mapperPackageName", PropertiesUtil.getConfig("mapper.packageName"));
        return model;
    }
}
