package com.sunny.bugmanage.project.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class ProjectIssue extends BaseModel<Long> {
   
    private String title;

    private String proVUuid;

    private Byte priority;

    private String description;

    private String userUuid;

    private Boolean status;

    private Integer browse;

    private Integer follow;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProVUuid() {
        return proVUuid;
    }

    public void setProVUuid(String proVUuid) {
        this.proVUuid = proVUuid == null ? null : proVUuid.trim();
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

}
