package com.daotoan.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "user")
public class UserDB implements Serializable {
   private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private int phone;
    @Column(name = "imageURL")
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
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

    public UserDB(int id, String name, int phone,String imageURL) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageURL=imageURL;
    }

    public UserDB() {
    }
}

