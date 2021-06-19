package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.model.Teacher;

/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月19日 下午1:03:28
* 类说明
*/
public class TeacherDao extends BasicDao{

	//老师登录方法
	public Teacher selectTeacher(String name, String password) {
        String sqlInfoStr = "SELECT * FROM s_teacher WHERE name = ? AND password = ?";
        Teacher teacher = null;
        try {
            this.pStatement = this.con.prepareStatement(sqlInfoStr);
            this.pStatement.setString(1, name);
            this.pStatement.setString(2, password);

            ResultSet executeQuery = this.pStatement.executeQuery();//查询结果集合
            if(executeQuery.next()) {
            	System.out.println(executeQuery.getInt(1));
            	System.out.println(executeQuery.getString(2));
            	System.out.println(executeQuery.getString(3));
            	 System.out.println(executeQuery.getString(4));
                teacher = new Teacher(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3), executeQuery.getString(4));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }
        return teacher;
    }
}
