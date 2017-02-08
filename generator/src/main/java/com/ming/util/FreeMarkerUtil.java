package com.ming.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class FreeMarkerUtil {
    /**
     * 数据和模板合成
     *
     * @param preDataMap 模板中需要的数据
     */
    public static void processTemplate(Map<String, Object> preDataMap, List list) {
        try {
            String extName = (String) preDataMap.get("extName");
            String tableName = (String) preDataMap.get("ClassName");

            String direct = mkDir((String) preDataMap.get("packageName"));
            Template tpl = getTemplet((String) preDataMap.get("templateName"));

            File file = new File(direct + tableName + extName);
            Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

            //生成文件
            tpl.process(preDataMap, out);
            System.out.println("完成：" + direct + tableName + extName);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹
     *
     * @param packagePath 包名
     */
    public static String mkDir(String packagePath) {
        String basePath = PropertiesUtil.getConfig("basePath");
        String direct = basePath + packagePath.replaceAll("\\.", "/") + "/";
        File fi = new File(direct);
        if (!fi.exists()) {
            fi.mkdir();
        }
        return direct;
    }

    /**
     * 获取模板
     *
     * @param name 模板名
     */
    public static Template getTemplet(String name) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(PropertiesUtil.getConfig("templatePath")));
        Template tpl = cfg.getTemplate(name);
        return tpl;
    }

}
