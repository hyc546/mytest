package com.SZ.utils.JDBCUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCUtils {
    @Autowired
    private DataSource dataSource;
    private static ThreadLocal<Connection> TL = new ThreadLocal<>();

    public static ThreadLocal<Connection> getTL() {
        return TL;
    }

    public  Connection getConnection(){
        Connection conn = null;
        try {
            conn = TL.get();
            if(conn == null) {
                conn = dataSource.getConnection();
                TL.set(conn);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
