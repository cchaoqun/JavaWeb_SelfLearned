package com.AtGuiGu.dao.impl;

import com.AtGuiGu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-15:09
 */
//复用代码类 一般为抽象类
public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法执行: Insert/Update/Delete语句
     * return 如果返回-1表示执行失败 返回其他表示影响的行数
     */
    public int update(String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn,sql, args );
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回对象的类型
     * @param sql  执行的SQL语句
     * @param args  SQL对应的参数
     * @param <T>   返回类型的泛型
     * @return
     */
    public <T>T queryForOne(Class<T> type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回对象的类型
     * @param sql  执行的SQL语句
     * @param args  SQL对应的参数
     * @param <T>   返回类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的SQL语句
     * @param sql       执行的sql语句
     * @param args      执行SQL对应的参数
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(sql, new ScalarHandler<>(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
