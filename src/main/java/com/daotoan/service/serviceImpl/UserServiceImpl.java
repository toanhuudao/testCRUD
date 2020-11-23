package com.daotoan.service.serviceImpl;

import com.daotoan.dao.UserDao;
import com.daotoan.entity.UserDB;
import com.daotoan.model.User;
import com.daotoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        MultipartFile avatar=user.getAvatar();
        File newFile=new File("D:\\gitproject\\CRUD\\src\\main\\webapp\\resources\\img\\"+avatar.getOriginalFilename());
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            fileOutputStream.write(user.getAvatar().getBytes());
            fileOutputStream.close();
            user.setImgURL(avatar.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }


        UserDB userDB=new UserDB();
        userDB.setName(user.getName());
        userDB.setPhone(user.getPhone());
        userDB.setImageURL(user.getImgURL());
        userDao.addUser(userDB);
    }

    @Override
    public void updateUser(User user) {
        MultipartFile avatar=user.getAvatar();
        File newFile=new File("D:\\gitproject\\CRUD\\src\\main\\webapp\\resources\\img\\"+avatar.getOriginalFilename());
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            fileOutputStream.write(user.getAvatar().getBytes());
            fileOutputStream.close();
            user.setImgURL(avatar.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDB userDB=new UserDB();
        userDB.setId(user.getId());
        userDB.setPhone(user.getPhone());
        userDB.setName(user.getName());
        userDB.setImageURL(user.getImgURL());
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
        user.setImgURL(userDB.getImageURL());
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
            user.setImgURL(userDB.getImageURL());
            userList.add(user);
        }
        return userList;
    }
}
