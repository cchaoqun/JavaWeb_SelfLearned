package com.AtGuiGu.i18n;


import org.junit.Test;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-18:44
 */

public class i18nTest {

    @Test
    public void testLocale(){
        //获取系统默认的语言, 国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);
//
//        for(Locale l : Locale.getAvailableLocales()){
//            System.out.println(l);
//        }
//
//        //获取中英文常量的Locale对象
//        System.out.println(Locale.CHINA);
//        System.out.println(Locale.US);
    }

    @Test
    public void test(){

        //得到需要的Locale对象
        Locale us = Locale.US;
        // 通过指定的 basename 和 Locale 对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", us);

        System.out.println("username: "+ bundle.getString("username"));
        System.out.println("password: "+ bundle.getString("password"));
        System.out.println("sex: "+ bundle.getString("sex"));
        System.out.println("age: "+ bundle.getString("age"));
    }
}
