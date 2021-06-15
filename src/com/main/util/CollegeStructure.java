package com.main.util;
/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月13日 上午12:21:58
 * 类说明
 */
public enum CollegeStructure {
    NO1("机电工程学院",0),
    NO2("信息与通信学院",1),
    NO3("计算机与信息安全学院",2),
    NO4("艺术与设计学院",3),
    NO5("商学院",4),
    NO6("外国语学院",5),
    NO7("数学与计算科学学院",6),
    NO8("电子工程与自动化学院",7);


    private String name;
    private int index;

    private CollegeStructure(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //院系下专业
    public static final String [][] major = {
            {"电子封装技术","车辆工程","电气工程及其自动化","机械电子工程"},
            {"通信工程","电子信息工程","电子科学与技术","导航工程","微电子科学与工程"},
            {"计算机科学技术","软件工程","智能科学技术","信息安全","物联网","网络空间安全"},
            {"服装与服饰设计","视觉传达设计","环境设计","动画专业","数字媒体技术"},
            {"会计学","财务管理","金融工程","信息管理与信息系统","电子商务","工商管理"},
            {"日语专业","英语专业","汉语国际教育专业"},
            {"数学与应用数学专业","统计学专业","信息与计算科学专业"},
            {"自动化","测控技术与仪器","光电信息科学与工程"}
    };

    //院系下专业代码
    public static final String [][] majorId = {
            {"101","102","103","104"},
            {"201","202","203","204","205"},
            {"301","302","303","304","305","306"},
            {"401","402","403","404","405"},
            {"501","502","503","504","505","506"},
            {"601","602","603"},
            {"701","702","703"},
            {"801","802","803"}
    };


    public static final String [] secondaryString = {
            NO1.getName(),
            NO2.getName(),
            NO3.getName(),
            NO4.getName(),
            NO5.getName(),
            NO6.getName(),
            NO7.getName(),
            NO8.getName()
    };

    public static final String [] gradeString = {//年级
            "2018","2019","2020"
    };

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }





}
