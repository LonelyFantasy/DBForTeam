package com.main.dao;
/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月17日 下午5:18:44
* 类说明
*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.main.model.Student;
import com.main.model.StudentClass;

public class StudentDao extends BasicDao{
	
	
	//新增加学生信息方法
	public String addStudentInfo(Student tempStudent) {
		String resultString = "添加失败";
		String sqlStr1 = "SELECT COUNT(*) FROM s_student WHERE id LIKE '"+tempStudent.getId() + "%'";
        String sqlStr2 = "SELECT * FROM s_student WHERE id = ?";
        String sqlStr3 = "INSERT INTO s_student VALUES(?,?,?,?,?,?,?,?,?)";
		
        try {
        	//生成学生ID
			this.pStatement = this.con.prepareStatement(sqlStr1);
			ResultSet executeQuery = this.pStatement.executeQuery();
            int count = -1;
            if(executeQuery.next()) {//对当前院系专业的学生数量进行查询统计，用于自动生成学生ID
                count = executeQuery.getInt(1);
            }
            System.out.println(count);
            if(count == -1) {//查询发生错误
                return resultString;
            }
            //寻找键值是否重复，重复则count自增并继续判断直到为未使用键值为止
            this.pStatement = this.con.prepareStatement(sqlStr2);
            this.pStatement.setString(1, tempStudent.getId()  + ++count);
            while(executeQuery.next()) {
                this.pStatement.setString(1, tempStudent.getId() + ++count);
                executeQuery = this.pStatement.executeQuery();
            }
            tempStudent.setId(tempStudent.getId() + count);
            
            
            //插入记录
            this.pStatement = this.con.prepareStatement(sqlStr3);
            //0-10的学生，保证学号编号为10位
            String tempString = tempStudent.getId();
            
            if(tempString.length() == 1) {
            	
            }
            System.out.println(tempString);
            tempStudent.setId(tempString);
            this.pStatement.setString(1, tempStudent.getId());
            this.pStatement.setString(2, tempStudent.getName());
            this.pStatement.setString(3, tempStudent.getSex());
            this.pStatement.setInt(4, tempStudent.getAge());
            this.pStatement.setString(5, tempStudent.getGrade());
            this.pStatement.setString(6, tempStudent.getClassId());
            this.pStatement.setString(7, tempStudent.getClassName());
            this.pStatement.setString(8, tempStudent.getSecondary());
            this.pStatement.setString(9, tempStudent.getMajor());
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
	
	//获取s_student表信息
	public ArrayList<Student> quaryAllstudent(){
        ArrayList <Student> array = new ArrayList<Student>();
        String sqlString = "SELECT * FROM s_student";
        try {
            this.pStatement = this.con.prepareStatement(sqlString);
            ResultSet executeQuery = this.pStatement.executeQuery();
            while(executeQuery.next()) {//获取数据库返回的数据
                Student tempStudent = new Student();
                tempStudent.setId(executeQuery.getString(1));
                tempStudent.setName(executeQuery.getString(2));
                tempStudent.setSex(executeQuery.getString(3));
                tempStudent.setAge(executeQuery.getInt(4));
                tempStudent.setGrade(executeQuery.getString(5));
                tempStudent.setClassId(executeQuery.getString(6));
                tempStudent.setClassName(executeQuery.getString(7));
                tempStudent.setSecondary(executeQuery.getString(8));
                tempStudent.setMajor(executeQuery.getString(9));
                
                array.add(tempStudent);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.close();
        }

        return array;
	}

	
	//按条件查询学生
	public ArrayList<Student> querySomeStudent(Student student){
		ArrayList<Student> arrayStudent = new ArrayList<Student>();
		
		//有年龄的查询
		String sqlString = "SELECT * FROM s_student WHERE id LIKE '%" + student.getId()
		+ "%' AND name like'%" + student.getName()
		+ "%' AND age LIKE '%" + student.getAge()
		+ "%' AND sex LIKE '%" + student.getSex()
		+ "%' AND grade LIKE '%" + student.getGrade()
		+ "%' AND classname LIKE '%" + student.getClassName()
		+ "%' AND secondary LIKE '%" + student.getSecondary()
		+ "%' AND major LIKE '%" + student.getMajor() + "%'";
		
		//无年龄的查询
		String sqlString2 = "SELECT * FROM s_student WHERE id LIKE '%" + student.getId()
		+ "%' AND name like'%" + student.getName()
		+ "%' AND sex LIKE '%" + student.getSex()
		+ "%' AND grade LIKE '%" + student.getGrade()
		+ "%' AND classname LIKE '%" + student.getClassName()
		+ "%' AND secondary LIKE '%" + student.getSecondary()
		+ "%' AND major LIKE '%" + student.getMajor() + "%'";
		

		if(student.getAge() == -1) {//有无年龄判断
			System.out.println(sqlString2);
			try {
				this.pStatement = this.con.prepareStatement(sqlString2);
				ResultSet executeQuery = this.pStatement.executeQuery();
				
	            while(executeQuery.next()) {//获取数据库返回的数据
	                Student tempStudent = new Student();
	                tempStudent.setId(executeQuery.getString(1));
	                tempStudent.setName(executeQuery.getString(2));
	                tempStudent.setSex(executeQuery.getString(3));
	                tempStudent.setAge(executeQuery.getInt(4));
	                tempStudent.setGrade(executeQuery.getString(5));
	                tempStudent.setClassId(executeQuery.getString(6));
	                tempStudent.setClassName(executeQuery.getString(7));
	                tempStudent.setSecondary(executeQuery.getString(8));
	                tempStudent.setMajor(executeQuery.getString(9));
	                
	                arrayStudent.add(tempStudent);
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.close();
			}
		}
		else {
			System.out.println(sqlString);
			try {
				this.pStatement = this.con.prepareStatement(sqlString);
				ResultSet executeQuery = this.pStatement.executeQuery();
				
	            while(executeQuery.next()) {//获取数据库返回的数据
	                Student tempStudent = new Student();
	                tempStudent.setId(executeQuery.getString(1));
	                tempStudent.setName(executeQuery.getString(2));
	                tempStudent.setSex(executeQuery.getString(3));
	                tempStudent.setAge(executeQuery.getInt(4));
	                tempStudent.setGrade(executeQuery.getString(5));
	                tempStudent.setClassId(executeQuery.getString(6));
	                tempStudent.setClassName(executeQuery.getString(7));
	                tempStudent.setSecondary(executeQuery.getString(8));
	                tempStudent.setMajor(executeQuery.getString(9));
	                arrayStudent.add(tempStudent);
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.close();
			}
		}

		return arrayStudent;
		
		
	}
	
	
}