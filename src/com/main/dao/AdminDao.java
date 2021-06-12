package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月12日 下午7:28:33
 * 类说明
 */
public class AdminDao extends BasicDao{

    public boolean selectAdmin(String name, String password) {
        String sqlInfoStr = "SELECT * FROM s_admin WHERE name = ? AND password = ?";
        try {
            this.pStatement = this.con.prepareStatement(sqlInfoStr);
            this.pStatement.setString(1, name);
            this.pStatement.setString(2, password);

            ResultSet executeQuery = this.pStatement.executeQuery();//查询结果集合
            if(executeQuery.next()) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }
}
