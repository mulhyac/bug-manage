package com.sunny.bugmanage.org.service;

import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.org.form.OrgUserForm;
import com.sunny.bugmanage.org.model.OrganizationUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.service.OrganizationUserService
 * @date 2017-07-03 14:25
 * @description:
 */
public interface OrganizationUserService {
    /**
     * 创建组织时自动添加成员
     *
     * @param uuId
     */
    void addOrgUserBySelf(String uuId) throws BugManageException;

    /**
     * 添加组织成员
     *
     * @param form
     */
    void addOrgUser(OrgUserForm form) throws BugManageException;

    /**
     * @param orgUuId
     * @param userUuId
     * @return
     * @throws BugManageException
     */
    OrganizationUser getOrganizationUserByUserUuId(String orgUuId, String userUuId) throws BugManageException;

    /**
     * 根据userUuId修改组织成员信息
     *
     *
     * @param userUuId
     * @param form
     * @throws BugManageException
     */
    void modifierOrgUserByUserUuId(String userUuId, OrgUserForm form) throws BugManageException;

    /**
     * 根据组织uuid删除组织成员
     * @param orgUUId
     */
    void removeOrgUserByOrgUUId(String orgUUId) throws BugManageException;

    /**
     * 根据组织uuid获取组织全部成员
     * @param uuId
     * @param form
     * @return
     */
    Map<String ,Object> getOrgUserByOrgUUId(String uuId, OrgUserForm form);  

    /**
     * 根据组织uuid获取组织成员总数
     * @param orgUuId
     * @return
     */
    int getOrgUserCountByOrgUuId(String orgUuId);

    /**
     *根据组织成员id删除人员
     * @param id
     */
    void removeOrgUserById(Long id);

    /**
     * 根据组织uuiid和userUuid获取人员角色(永远不会返回null，默认返回0)
     * @param orgUuId
     * @param userUuId
     * @return
     */
    Byte getRoleByIdAndUserUuId(@Param("orgUuid") String orgUuId, @Param("userUuid")String userUuId);
}
