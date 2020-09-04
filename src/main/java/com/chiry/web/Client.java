package com.chiry.web;

import com.chiry.factory.BeanFactory;
import com.chiry.service.AccountService;
import com.chiry.service.impl.AccountServiceImpl;

/**
 * @program: jdbc_demo2
 * @description: client
 * @author: Chiry
 * @create: 2020-09-04 16:51
 **/
public class Client {
    public static void main(String[] args) {
//        AccountService accountService =new AccountServiceImpl();
        for (int i=0;i<5;i++){
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        System.out.println(accountService);
        accountService.save();
        }
    }
}
