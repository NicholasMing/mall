package com.ming.service;

import com.ming.util.DbUtil;
import com.ming.util.FreeMarkerUtil;
import com.ming.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicholas on 2017/1/21.
 */
public class Generator {
    public void createFile(String propertiesName) {
        //加载配置文件
        PropertiesUtil.getProperties(propertiesName);

        //从数据库中获取表字段
        List columnList = DbUtil.getTableColumnList();

        //需要生成的模块
        List<String> switchList = getSwitchList();

        System.out.println("=========================开始生成========================");
        for (String module : switchList) {
            //准备数据
            Map<String, Object> dataModel = DataModel.getDataModel(module, columnList);

            FreeMarkerUtil.processTemplate(dataModel, columnList);
        }
        System.out.println("=========================生成结束========================");
    }

    /**
     * 需要生成的代码
     *
     * @return
     */
    public List<String> getSwitchList() {
        List<String> switchList = new ArrayList();
        Map map = PropertiesUtil.getMap();
        Iterator keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if (key.contains("switch.") && map.get(key).equals("true")) {
                switchList.add(key.substring(7, key.length()));
            }
        }
        return switchList;
    }
}
