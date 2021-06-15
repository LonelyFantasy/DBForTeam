package com.main.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月11日 下午9:19:35
 * 类说明
 */
public class ReadProperties {

    private static ReadProperties rp;
    public String dbUrl;
    public String dbUsername;
    public String dbPassword;

    private ReadProperties() {
        loadProperties();
    }

    public static ReadProperties initial() {//防止数据库重复连接
        if (rp == null)
            rp = new ReadProperties();
        return rp;
    }

    private void loadProperties() {
        InputStream ips = getClass().getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(ips);
            this.dbUrl = properties.getProperty("dburl");
            this.dbUsername = properties.getProperty("username");
            this.dbPassword = properties.getProperty("password");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
