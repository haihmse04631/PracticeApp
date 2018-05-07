package com.example.macbookpro.practiceapp.Model;

import java.io.Serializable;

/**
 * Created by MacbookPro on 4/30/18.
 */

public class User implements Serializable {
    private String id;
    private String name;
    private String email;
    private String avatar;
    private String birthday;

    public User(String id, String name, String email, String avatar, String birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String gender) {
        this.avatar = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
