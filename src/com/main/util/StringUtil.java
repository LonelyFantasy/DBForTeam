package com.main.util;
/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月12日 下午11:21:52
 * 类说明
 */
public class StringUtil {

    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        if("".equals(str) || str == null)
            return true;
        return false;
    }

    //判断两个密码是否输入相同
    public static boolean isSame(String str, String strcheck) {
        return str.equals(strcheck);
    }
}
