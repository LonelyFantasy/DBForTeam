package com.main.util;
/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月11日 下午9:04:32
 * 类说明
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";//使用新版本的数据库连接方法，旧版本部分功能会报错
    private static ReadProperties rp = ReadProperties.initial();

    public static Connection getConnection() {
        try {
            //加载数据库驱动
            Class.forName(jdbcDriver);
            //执行数据库连接
            Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUsername, rp.dbPassword);
            return connection;//返回连接数据

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
