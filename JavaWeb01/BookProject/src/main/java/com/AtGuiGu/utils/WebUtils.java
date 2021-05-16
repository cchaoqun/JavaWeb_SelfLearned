package com.AtGuiGu.utils;

import com.AtGuiGu.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/12-22:16
 */

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean){

        try {
            System.out.println("注入之前: "+bean);
            /**
             * 把所有请求的参数注入到user对象中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后: "+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue){

        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}