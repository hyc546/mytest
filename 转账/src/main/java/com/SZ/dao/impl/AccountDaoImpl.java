package com.SZ.dao.impl;

import com.SZ.dao.AccountDao;
import com.SZ.utils.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner qr;
    @Autowired
    private JDBCUtils jdbcUtils;

    public void updateMoney(String from, double money) {
        String sql = "update account set balance = balance + ? where username = ?";
        try {
            qr.update(jdbcUtils.getConnection(),sql, money, from);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
