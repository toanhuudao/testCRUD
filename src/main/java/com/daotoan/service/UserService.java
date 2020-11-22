package com.daotoan.service;

import com.daotoan.entity.UserDB;
import com.daotoan.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int userId);

    public List<User> getAllUser();
}
