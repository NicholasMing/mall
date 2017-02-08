package com.ming.entity;

import com.ming.util.PropertiesUtil;
import com.ming.util.StringUtil;

/**
 * 表字段相关信息
 */
public class Table {
    private String columnName;//列名（转驼峰）
    private String nativeColumnName;//列名
    private String dataType;//数据类型
    private String comment;//注释
    private String jdbcType;

    public String getColumnName() {
        return columnName;
    }

    public Table(String columnName, String dataType, String comment) {
        this.columnName = StringUtil.underlineToCamel(columnName, false);
        this.nativeColumnName = columnName;
        this.dataType = StringUtil.underlineToCamel(dataType, false);
        this.comment = comment;
        this.jdbcType = PropertiesUtil.getConfig(dataType);
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNativeColumnName() {
        return nativeColumnName;
    }

    public void setNativeColumnName(String nativeColumnName) {
        this.nativeColumnName = nativeColumnName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }
}
