package com.main.model;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月10日 下午1:40:29
 * 类说明
 */
public enum UserType {

    ADMIN("系统管理员", 0);
    private String name;
    private int index;

    UserType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return name;
    }

}
