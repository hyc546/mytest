package com.SZ.service.impl;

import com.SZ.dao.AccountDao;
import com.SZ.dao.impl.AccountDaoImpl;
import com.SZ.service.AccountService;
import com.SZ.utils.JDBCUtils.JDBCUtils;
import com.SZ.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
   @Autowired
   private AccountDao accountDao = new AccountDaoImpl();
@Autowired
   private TransactionManager tr;

   public void transfer(String from, String to, double money) {
       try {
           tr.begin();

           accountDao.updateMoney(from, -money);
           accountDao.updateMoney(to, money);
       }catch (Exception e){
           e.printStackTrace();
           tr.rollBack();

       }finally {
           tr.comit();
           tr.release();
       }


   }
}
