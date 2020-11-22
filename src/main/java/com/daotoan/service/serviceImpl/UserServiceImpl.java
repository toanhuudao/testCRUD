package com.daotoan.service.serviceImpl;

import com.daotoan.dao.UserDao;
import com.daotoan.entity.UserDB;
import com.daotoan.model.User;
import com.daotoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        UserDB userDB=new UserDB();
        userDB.setName(user.getName());
        userDB.setPhone(user.getPhone());
        userDao.addUser(userDB);
    }

    @Override
    public void updateUser(User user) {
        UserDB userDB=new UserDB();
        userDB.setId(user.getId());
        userDB.setPhone(user.getPhone());
        userDB.setName(user.getName());
        userDao.updateUser(userDB);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public User getUser(int userId) {

        UserDB userDB = userDao.getUser(userId);
        User user=new User();
        user.setId(userId);
        user.setPhone(userDB.getPhone());
        user.setName(userDB.getName());
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        List<UserDB> allUserDB = userDao.getAllUser();
        for (UserDB userDB : allUserDB
        ){
             User user =new User();
            user.setId(userDB.getId());
            user.setPhone(userDB.getPhone());
            user.setName(userDB.getName());
            userList.add(user);
        }
        return userList;
    }
}
