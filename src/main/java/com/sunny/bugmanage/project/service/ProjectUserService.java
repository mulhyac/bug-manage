package com.sunny.bugmanage.project.service;

import com.sunny.bugmanage.common.exception.BugManageException;
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
     *
     * @param form
     */
    void addProjectUser(ProjectUserForm form) throws BugManageException;

    /**
     * 自动添加项目成员
     * @param proUuId
     * @throws BugManageException
     */
    void addProjectUserBySelf(String proUuId) throws BugManageException;

    /**
     * 根据项目uuid获取人员总数
     * @param proUuId
     * @param name
     * @return
     */
    Integer getProUserCountByProUuId(String proUuId,String name);
}
