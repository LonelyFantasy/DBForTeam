package com.main.dao;
/*
  @author Lonely_Fantasy
 * @version 创建时间：2021年6月11日 下午9:34:39
 * 类说明：程序基础类，保存父类
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.util.DbUtil;

public abstract class BasicDao {
    protected Connection con = DbUtil.getConnection();

    protected PreparedStatement pStatement = null;

    protected void close() {//关闭数据库
        try {
            this.con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
