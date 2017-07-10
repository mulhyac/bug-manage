package com.sunny.bugmanage.project.form;

import com.sunny.bugmanage.common.form.BaseForm;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.form.ProjectUserForm
 * @date 2017-07-10 14:14
 * @description:
 */
public class ProjectUserForm extends BaseForm<String> {
    private static final long serialVersionUID = 8949893043227739063L;

    private String proUuid;

    private String userUuid;

    private Byte role;

    private String name;

    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
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
        this.name = name;
    }
}
