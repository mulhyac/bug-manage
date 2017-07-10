package com.sunny.bugmanage.user.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class AppUserByEmail extends BaseModel<String> {
    private String email;

    private Long userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
