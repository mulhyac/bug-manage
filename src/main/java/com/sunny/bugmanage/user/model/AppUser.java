package com.sunny.bugmanage.user.model;

import com.sunny.bugmanage.common.model.BaseModel;

import java.util.Date;

public class AppUser extends BaseModel<Long> {
    private String password;
    private String password2;
    private Byte source;
    private Byte status;
    private Date passwordDate;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2 == null ? null : password2.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getPasswordDate() {
        return passwordDate==null?new Date():passwordDate;
    }

    public void setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
    }

   
}