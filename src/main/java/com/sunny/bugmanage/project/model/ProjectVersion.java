package com.sunny.bugmanage.project.model;

import com.sunny.bugmanage.common.model.BaseModel;
import java.util.Date;

public class ProjectVersion extends BaseModel<Long> {
    
    private String proUuid;

    private String name;

    private String description;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid == null ? null : proUuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
