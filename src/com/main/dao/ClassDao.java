package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.model.StudentClass;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月14日 下午3:40:45
 * 类说明
 */
public class ClassDao extends BasicDao{

    //添加班级
    public String addClass(StudentClass tempClass) {
        String resultString = "添加失败";
        String sqlStr1 = "SELECT COUNT(*) FROM s_class WHERE id LIKE '"+tempClass.getId() + "%'";
        String sqlStr2 = "SELECT * FROM s_class WHERE id = ?";
        String sqlStr3 = "INSERT INTO s_class VALUES(?,?,?,?,?,?)";
        try {
            System.out.println(tempClass.getId());
            this.pStatement = this.con.prepareStatement(sqlStr1);
            ResultSet executeQuery = this.pStatement.executeQuery();
            int count = -1;
            if(executeQuery.next()) {//对当前院系专业的班级数量进行查询统计，用于自动生成班级ID
                count = executeQuery.getInt(1);
            }
            System.out.println(count);
            if(count == -1) {//查询发生错误
                return resultString;
            }

            //寻找键值是否重复，重复则count自增并继续判断直到为未使用键值为止
            this.pStatement = this.con.prepareStatement(sqlStr2);
            this.pStatement.setString(1, tempClass.getId() + ++count);
            while(executeQuery.next()) {
                this.pStatement.setString(1, tempClass.getId() + ++count);
                executeQuery = this.pStatement.executeQuery();
            }
            tempClass.setId(tempClass.getId() + count);

            //插入记录
            this.pStatement = this.con.prepareStatement(sqlStr3);
            this.pStatement.setString(1, tempClass.getId());
            this.pStatement.setString(2, tempClass.getName());
            this.pStatement.setString(3, tempClass.getGrade());
            this.pStatement.setString(4, tempClass.getSecondary());
            this.pStatement.setString(5, tempClass.getMajor());
            this.pStatement.setString(6, tempClass.getInfo());
            if(this.pStatement.executeUpdate() > 0) {
                resultString = "添加成功";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }

        return resultString;
    }

    //获取s_class表信息
    public ArrayList <StudentClass> queryAllClass() {
        ArrayList <StudentClass> array = new ArrayList<StudentClass>();
        String sqlString = "SELECT * FROM s_class";
        try {
            this.pStatement = this.con.prepareStatement(sqlString);
            ResultSet executeQuery = this.pStatement.executeQuery();
            while(executeQuery.next()) {//获取数据库返回的数据
                StudentClass tempClass = new StudentClass();
                tempClass.setId(executeQuery.getString(1));
                tempClass.setGrade(executeQuery.getString(2));
                tempClass.setName(executeQuery.getString(3));
                tempClass.setSecondary(executeQuery.getString(4));
                tempClass.setMajor(executeQuery.getString(5));
                tempClass.setInfo(executeQuery.getString(6));
                array.add(tempClass);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }

        return array;
    }

    //按条件查询班级
    public ArrayList <StudentClass> querySomeClass(StudentClass tempClass){
        ArrayList<StudentClass> arrays = new ArrayList<StudentClass>();

        //SQL查询语句，使用了模糊匹配以及任意条件搜索
        String sqlStr = "SELECT * FROM s_class WHERE name LIKE '%" + tempClass.getName() + "%' AND grade LIKE '%" + tempClass.getGrade() + "%' AND secondary LIKE '%" + tempClass.getSecondary() + "%' AND major LIKE '%" + tempClass.getMajor() + "%' AND info LIKE '%" + tempClass.getInfo() + "%'";

        try {
            this.pStatement = this.con.prepareStatement(sqlStr);
            ResultSet executeQuery = this.pStatement.executeQuery();
            while(executeQuery.next()) {
                StudentClass tempClass2 = new StudentClass();
                tempClass2.setId(executeQuery.getString(1));
                tempClass2.setGrade(executeQuery.getString(2));
                tempClass2.setName(executeQuery.getString(3));
                tempClass2.setSecondary(executeQuery.getString(4));
                tempClass2.setMajor(executeQuery.getString(5));
                tempClass2.setInfo(executeQuery.getString(6));

                arrays.add(tempClass2);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }


        return arrays;
    }

    //删除班级
    public String deleteClass(String id) {
    	String resultString = "删除失败";
    	String sqlString = "DELETE FROM s_class WHERE id = ?";
    	
    	try {
			this.pStatement = this.con.prepareStatement(sqlString);
			this.pStatement.setString(1, id);
			if(this.pStatement.executeUpdate() > 0) {
				resultString = "删除成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
    	return resultString;
    }
    
    //根据年级，学院，专业进行班级查找
    public ArrayList <StudentClass> querySomeClass(String grade, String secondary, String major){
    	ArrayList<StudentClass> tempArrayList = new ArrayList<StudentClass>();
    	String sqlString = "SELECT id, name FROM s_class WHERE grade = ? AND secondary = ? AND major = ?";
    	
    	try {
			this.pStatement = this.con.prepareStatement(sqlString);
			this.pStatement.setString(1, grade);//把占位符替换成需要的东西
			this.pStatement.setString(2, secondary);
			this.pStatement.setString(3, major);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				StudentClass tempClass = new StudentClass();
				tempClass.setId(executeQuery.getString("id"));
				tempClass.setName(executeQuery.getString("name"));
				tempArrayList.add(tempClass);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
    	return  tempArrayList;
    	
    }
    
    //根据班级编号对班级进行查找，查找成功返回bool值
    public boolean querySomeClass(String classId) {
    	boolean result = false;
    	String sqlString = "SELECT name FROM s_class WHERE id = " + classId;
    	
    	try {
			this.pStatement = this.con.prepareStatement(sqlString);
			ResultSet executeQuery = this.pStatement.executeQuery();
			if(executeQuery.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
    	
    	return result;
    	
    }
}
