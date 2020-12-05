package com.SZ.utils;

import com.SZ.utils.JDBCUtils.JDBCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransactionManager {
    @Autowired
    JDBCUtils jdbcUtils;
    public  void begin(){
        try {
            jdbcUtils.getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  void rollBack() {
        try {
            jdbcUtils.getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  void comit() {
        try {
            jdbcUtils.getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void release(){
        try {
            jdbcUtils.getConnection().close();
            JDBCUtils.getTL().remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
