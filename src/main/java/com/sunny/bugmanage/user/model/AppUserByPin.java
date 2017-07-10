package com.sunny.bugmanage.user.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class AppUserByPin extends BaseModel<String> {
    private String pin;

    private Long userId;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
