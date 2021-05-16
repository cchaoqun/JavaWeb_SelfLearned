package com.AtGuiGu.utils;

import jakarta.servlet.http.Cookie;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-18:06
 */

public class CookieUtils {
    /**
     * 查找指定名称的cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies){
        if(name==null || cookies==null || cookies.length==0){
            return null;
        }
        for(Cookie cookie:cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
