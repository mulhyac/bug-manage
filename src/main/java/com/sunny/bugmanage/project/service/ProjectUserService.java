package com.sunny.bugmanage.project.service;

import com.sunny.bugmanage.project.form.ProjectUserForm;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.service.ProjectUserService
 * @date 2017-07-10 14:12
 * @description:
 */
public interface ProjectUserService {
    /**
     * 添加项目成员
     * @param form
     */
    void addProjectUser(ProjectUserForm form);
}
