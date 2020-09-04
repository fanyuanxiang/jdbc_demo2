package com.chiry.service.impl;

import com.chiry.dao.AccountDao;
import com.chiry.dao.impl.AccountDaoImpl;
import com.chiry.service.AccountService;

/**
 * @program: jdbc_demo2
 * @description: serviceImpl
 * @author: Chiry
 * @create: 2020-09-04 17:16
 **/
public class AccountServiceImpl implements AccountService{
    AccountDao account =new AccountDaoImpl();
    public void save() {
        account.saveAccount();
    }
}
