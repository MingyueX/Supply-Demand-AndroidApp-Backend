package org.practice.service.impl;

import org.practice.dao.AccountDao;
import org.practice.model.Account;
import org.practice.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LoginService")
public class HelloServiceImpl implements LoginService {

    @Resource
    public AccountDao accountDao;

    public Account getById(Integer id) {return accountDao.getById(id);}

    public Account HelloService(String username) {
        return accountDao.getByName(username);
    }

    public void HelloSave(Account account) {
        accountDao.add(account);
    }

    public void updateAvatarByPrimaryKey(Account account) {
        accountDao.updateAvatarByPrimaryKey(account);
    }

    public void updateUsernameByPrimaryKey(Account account) {
        accountDao.updateUsernameByPrimaryKey(account);
    }
}
