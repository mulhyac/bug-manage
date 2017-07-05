package com.sunny.bugmanage.user.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sunny.bugmanage.user.model.AppUser;

import java.util.Date;

/**
 * Created by sunny on 2017/6/6.
 */

public class AppUserVo extends AppUser {
    private String userName;

    private String nickName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String iconUrl;

    private String summary;

    private String dept;

    private String position;

    private Byte age;

    private String address;

    private Integer likes;

    private Integer follow;

    private String pin;

    private Date birthdate;

    private String city;

    private String cityId;
    /**
     * session缓存时间
     */
    private Integer sessionMaxInactiveInterval;

    private String sessionId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public int getSessionMaxInactiveInterval() {
        return sessionMaxInactiveInterval == null ? 0 : sessionMaxInactiveInterval;
    }

    public void setSessionMaxInactiveInterval(Integer sessionMaxInactiveInterval) {
        this.sessionMaxInactiveInterval = sessionMaxInactiveInterval;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
