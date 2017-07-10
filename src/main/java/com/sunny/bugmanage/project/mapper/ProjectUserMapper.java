package com.sunny.bugmanage.project.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.project.model.ProjectUser;
import org.apache.ibatis.annotations.Param;

public interface ProjectUserMapper extends BaseMapper<ProjectUser, Long> {
    /**
     * 根据项目uuid和成员uuid获取项目成员
     *
     * @param proUuid
     * @param userUuid
     * @return
     */
    ProjectUser selectProjectUserByProUuIdAndUserUuId(@Param("proUuid") String proUuid, @Param("userUuid") String userUuid);

    /**
     * 根据项目uuid查询项目成员人数
     *
     * @param proUuId
     * @param name
     * @return
     */
    Integer selectProUserCountByProUuId(@Param("proUuid") String proUuId, @Param("key") String name);
}
