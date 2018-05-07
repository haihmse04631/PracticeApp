package com.example.macbookpro.practiceapp.EventBus;

import com.example.macbookpro.practiceapp.Model.User;

/**
 * Created by MacbookPro on 4/30/18.
 */

public class OnLoginSuccess {
    private User user;

    public OnLoginSuccess(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
