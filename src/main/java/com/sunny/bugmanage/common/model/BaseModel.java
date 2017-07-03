package com.sunny.bugmanage.common.model;

import com.sunny.bugmanage.common.UserContext.BugAppUser;
import com.sunny.bugmanage.common.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.model.BaseModel
 * @date 2017-06-09 17:01
 * @description:
 */
public class BaseModel<ID extends Serializable> implements Serializable {
    private ID id;

    private String uuid;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreator() {
        return StringUtils.isBlank(BugAppUser.userUUId()) ? "" : creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime == null ? new Date() : createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return StringUtils.isBlank(BugAppUser.userUUId()) ? "" : modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime == null ? new Date() : modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
