package com.daotoan.dao;

import com.daotoan.entity.UserDB;

import java.util.List;

public interface UserDao {
    public void addUser(UserDB user);

    public void updateUser(UserDB user);

    public void deleteUser(int userId);

    public UserDB getUser(int userId);

    public List<UserDB> getAllUser();
}
