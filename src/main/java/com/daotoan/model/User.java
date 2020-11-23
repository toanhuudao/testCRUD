package com.daotoan.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;


public class User {
    private int id;
    private String name;
    private int phone;
    private String imgURL;
    private MultipartFile avatar;

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }


    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public User() {
    }

    public User(int id, String name, int phone, String imgURL) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}