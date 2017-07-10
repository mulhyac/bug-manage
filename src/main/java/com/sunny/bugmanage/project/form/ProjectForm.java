package com.sunny.bugmanage.project.form;

import com.sunny.bugmanage.common.form.BaseForm;
import com.sunny.bugmanage.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.form.ProjectForm
 * @date 2017-07-10 13:45
 * @description:
 */
public class ProjectForm extends BaseForm<String> {
    private static final long serialVersionUID = -1006338745768588114L;
    /**
     * 项目名称
     */
    @NotNull(message = "请输入项目名称", groups = {InsertGroup.class})
    @Length(message ="项目名称3-50个字符",groups = {InsertGroup.class})
    private String name;

    private String orgUuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgUuid() {
        return orgUuid;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }
}
