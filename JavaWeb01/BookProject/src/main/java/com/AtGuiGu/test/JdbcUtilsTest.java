package com.AtGuiGu.test;


import com.AtGuiGu.utils.JdbcUtils;
import org.junit.Test;


import java.sql.Connection;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-14:57
 */

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
    }
}
