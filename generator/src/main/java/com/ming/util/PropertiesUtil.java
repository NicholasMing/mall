package com.ming.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * properties解析
 */
public class PropertiesUtil {
    public static Map<String, String> map;

    public static String getConfig(String key) {
        return map.get(key);
    }

    public static Map getMap() {
        return map;
    }

    public static void getProperties(String propertiesName) {
        String rootPath = PropertiesUtil.class.getResource("/").getFile().toString();
        String propertiesPath = rootPath + "/properties/" + propertiesName;
        if (!propertiesPath.toLowerCase().endsWith(".properties")) {
            propertiesPath += ".properties";
        }
        Properties prop = new Properties();
        Map<String, String> pros = new HashMap();
        try {
            //读取属性文件*.properties
            InputStream in = new BufferedInputStream(new FileInputStream(propertiesPath));
            prop.load(in);     ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                pros.put(key, prop.getProperty(key));
            }
            map = pros;
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
