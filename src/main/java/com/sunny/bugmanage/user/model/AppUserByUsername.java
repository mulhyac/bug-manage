package com.sunny.bugmanage.user.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class AppUserByUsername extends BaseModel<String> {
    private String userName;

    private Long userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
