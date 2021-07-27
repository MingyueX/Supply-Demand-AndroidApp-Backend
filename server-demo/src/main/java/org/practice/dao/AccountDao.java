package org.practice.dao;

import org.practice.model.Account;

public interface AccountDao {

    public Account getById(Integer id);

    public Account getByName(String username);

    public void add(Account account);

    public void updateAvatarByPrimaryKey(Account account);

    public void updateUsernameByPrimaryKey(Account account);

}
