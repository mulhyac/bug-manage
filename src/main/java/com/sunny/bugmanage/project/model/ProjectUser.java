package com.sunny.bugmanage.project.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class ProjectUser extends BaseModel<Long> {
    
    private String proUuid;

    private String userUuid;

    private Byte role;

    private String name;

    private Byte status;

    private String position;
    
    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid == null ? null : proUuid.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
    
}
