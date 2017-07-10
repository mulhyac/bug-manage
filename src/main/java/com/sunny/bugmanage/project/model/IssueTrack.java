package com.sunny.bugmanage.project.model;

import com.sunny.bugmanage.common.model.BaseModel;

public class IssueTrack extends BaseModel<Long> {

    private String issueUuid;

    private String userUuid;

    private String content;

    private Boolean action;
    
    public String getIssueUuid() {
        return issueUuid;
    }

    public void setIssueUuid(String issueUuid) {
        this.issueUuid = issueUuid == null ? null : issueUuid.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

}
