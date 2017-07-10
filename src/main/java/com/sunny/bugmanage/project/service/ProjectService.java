package com.sunny.bugmanage.project.service;

import com.sunny.bugmanage.project.form.ProjectForm;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.service.ProjectService
 * @date 2017-07-10 13:33
 * @description:
 */
public interface ProjectService {
    /**
     * 添加项目
     * @param form
     */
    void addProject(ProjectForm form);

    /**
     * 根据组织uuid获取项目个数
     * @param orgUuId
     * @return
     */
    Integer getProCountByOrgUuId(String orgUuId);

    /***
     * 根据项目uuid获取项目人员限制
     * @param proUuId
     * @return
     */
    Integer getPeopleLimitByProUuId(String proUuId);
}
