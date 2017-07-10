package com.sunny.bugmanage.user.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class AppUserByMobile extends BaseModel<String> {
    private String mobile;

    private Long userId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
