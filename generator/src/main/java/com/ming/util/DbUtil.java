package com.ming.util;

import com.ming.entity.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DbUtil {
    /**
     * 数据库连接
     */
    public static Connection getCon() throws Exception {

        String driverName = "com.mysql.jdbc.Driver";

        String dbURL = PropertiesUtil.getConfig("db_url");

        String username = PropertiesUtil.getConfig("db_username");

        String password = PropertiesUtil.getConfig("db_password");

        Connection dbConn;

        Class.forName(driverName);

        dbConn = DriverManager.getConnection(dbURL, username, password);
        return dbConn;

    }

    /**
     * 加载字段
     */
    public static List getTableColumnList() {
        List<Table> columnList = new ArrayList<>();
        try {
            Connection con = DbUtil.getCon();
            String sql = "select COLUMN_NAME as columnName,DATA_TYPE as dataType,column_comment as comment from information_schema.columns where TABLE_NAME=? and table_schema=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, PropertiesUtil.getConfig("tableName"));
            pstm.setString(2, PropertiesUtil.getConfig("dataBaseName"));
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String columnName = rs.getString("columnName");
                String dataType = rs.getString("dataType");
                String comment = rs.getString("comment");
                columnList.add(new Table(columnName, dataType, comment));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnList;
    }
    /**
     * 主键id
     */
    public static String primaryKey() {
        String primarKey = "";
        try {
            Connection con = DbUtil.getCon();
            String sql = "select COLUMN_NAME as columnName from information_schema.columns where TABLE_NAME=? and table_schema=? and column_key='PRI'";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, PropertiesUtil.getConfig("tableName"));
            pstm.setString(2, PropertiesUtil.getConfig("dataBaseName"));
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                primarKey = rs.getString("columnName");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return primarKey;
    }
}
