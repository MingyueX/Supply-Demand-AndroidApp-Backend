package org.practice.service;

import org.practice.model.Account;

public interface LoginService {
    public Account getById(Integer id);

    public Account HelloService(String username);

    public void HelloSave(Account account);

    public void updateAvatarByPrimaryKey(Account account);

    public void updateUsernameByPrimaryKey(Account account);
}
