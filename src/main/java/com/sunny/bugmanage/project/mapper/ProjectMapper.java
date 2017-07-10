package com.sunny.bugmanage.project.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.project.model.Project;

public interface ProjectMapper extends BaseMapper<Project, Long> {
    /**
     * 根据组织uuid获取项目个数
     *
     * @param orgUuId
     * @return
     */
    Integer selectProCountByOrgUuId(String orgUuId);
}
