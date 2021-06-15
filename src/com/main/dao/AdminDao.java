package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.model.SystemAdmin;
import com.main.view.IndexFrame;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月12日 下午7:28:33
 * 类说明
 */
public class AdminDao extends BasicDao{

    //管理员登录系统方法
    public SystemAdmin selectAdmin(String name, String password) {
        String sqlInfoStr = "SELECT * FROM s_admin WHERE name = ? AND password = ?";
        SystemAdmin admin = null;
        try {
            this.pStatement = this.con.prepareStatement(sqlInfoStr);
            this.pStatement.setString(1, name);
            this.pStatement.setString(2, password);

            ResultSet executeQuery = this.pStatement.executeQuery();//查询结果集合
            if(executeQuery.next()) {
                admin = new SystemAdmin(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }
        return admin;
    }

    //修改管理员密码
    public String resetPassword(SystemAdmin admin, String newPassword) {
        String resultString = "操作失败";
        String sqlString = "UPDATE s_admin SET password = ? WHERE name = ? AND password = ? AND id = ?";
        try {
            this.pStatement = this.con.prepareStatement(sqlString);
            this.pStatement.setString(1, newPassword);
            this.pStatement.setString(2, admin.getName());
            this.pStatement.setString(3, admin.getPassword());
            this.pStatement.setInt(4, admin.getId());
            if(this.pStatement.executeUpdate() > 0) {
                resultString = "操作成功！";
                IndexFrame.admin.setPassword(newPassword);//更新程序内保存的密码
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultString;
    }



}
