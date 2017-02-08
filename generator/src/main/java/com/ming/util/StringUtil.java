package com.ming.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final char UNDERLINE = '_';

    /**
     * 下划线格式字符串转换为驼峰格式字符串,首字母大写
     *
     * @param param
     */
    public static String underlineToCamel(String param, boolean isUp) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);

        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        param = sb.toString();
        if (isUp) param = param.substring(0, 1).toUpperCase() + param.substring(1);
        return param;
    }
}
