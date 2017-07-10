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

    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid;
    }
}
