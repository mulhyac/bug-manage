package com.sunny.bugmanage.project.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.project.model.Project;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper extends BaseMapper<Project, Long> {
    /**
     * 根据组织uuid获取项目个数
     *
     * @param orgUuId
     * @return
     */
    Integer selectProCountByOrgUuId(@Param("orgUuid") String orgUuId);

    /**
     *  根据项目uuid获取人员上限
     * @param proUuId
     * @return
     */
    Integer selectPeopleLimitByProUuId(@Param("uuid") String proUuId);
}
