package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.org.form.OrgUserForm;
import com.sunny.bugmanage.org.model.OrganizationUser;
import com.sunny.bugmanage.org.model.vo.OrganizationUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationUserMapper extends BaseMapper<OrganizationUser,Long> {
    
    /**
     * 根据用户uuid获取组织成员
     *
     * @param orgUuId
     * @param userUuId
     * @return
     */
    OrganizationUser selectOrganizationUserByUserUuId(@Param("orgUuid") String orgUuId, @Param("userUuid") String userUuId);

    /**
     * 根据组织的uuid更新组织成员状态
     *
     * @param orgUser
     */
    void updateOrgUserByOrgUUId(OrganizationUser orgUser);

    /**
     * 根据组织uuid获取组织成员
     *
     * @param form
     * @return
     */
    List<OrganizationUserVo> selectOrgUserByOrgUUId(OrgUserForm form);

    /**
     * 根据组织uuid获取组织成员总数
     *
     * @param orgUuId
     * @return
     */
    int selectOrgUserCountByOrgUuId(String orgUuId);

    /**
     * 根据组织uuiid和userUuid获取人员角色(永远不会返回null，默认返回0)
     * @param orgUuId
     * @param userUuId
     * @return
     */
    Byte selectRoleByIdAndUserUuId(@Param("orgUuid") String orgUuId, @Param("userUuid")String userUuId);
}
