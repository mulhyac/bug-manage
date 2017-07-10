package com.sunny.bugmanage.project.service.impl;

import com.sunny.bugmanage.common.UserContext.BugAppUser;
import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.fields.Role;
import com.sunny.bugmanage.common.fields.Status;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.project.form.ProjectUserForm;
import com.sunny.bugmanage.project.mapper.ProjectUserMapper;
import com.sunny.bugmanage.project.model.ProjectUser;
import com.sunny.bugmanage.project.service.ProjectService;
import com.sunny.bugmanage.project.service.ProjectUserService;
import com.sunny.bugmanage.user.service.AppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.service.impl.ProjectUserServiceImpl
 * @date 2017-07-10 14:13
 * @description:
 */
@Service
public class ProjectUserServiceImpl implements ProjectUserService {
    @Autowired
    private ProjectUserMapper projectUserMapper;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private ProjectService projectService;
    //@Autowired
    // private OrganizationService organizationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProjectUser(ProjectUserForm form) {
        String userUuid = form.getUserUuid();
        String proUuid = form.getProUuid();

        ProjectUser oldUser = projectUserMapper.selectProjectUserByProUuIdAndUserUuId(proUuid, userUuid);
        if (oldUser != null) {
            return;
        }
        String nickName = appUserService.getAppUserNickNameByUuid(userUuid);
        if (StringUtils.isBlank(nickName)) {
            return;
        }
        if (getProUserCountByProUuId(proUuid, null) > projectService.getPeopleLimitByProUuId(proUuid)) {
            throw new BugManageException(ResultEnum.PRO_USER_EXCEED_LIMIT);
        }
        ProjectUser projectUser = new ProjectUser();
        BeanUtils.copyProperties(form, projectUser);
        projectUser.setName(nickName);
        projectUser.setPosition(Role.getPositionByRole(form.getRole()));
        projectUserMapper.insertSelective(projectUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProjectUserBySelf(String proUuId) throws BugManageException {
        ProjectUserForm form = new ProjectUserForm();
        form.setProUuid(proUuId);
        //form.set
        form.setUserUuid(BugAppUser.userUUId());
        form.setRole(Status.ORG_USER_ROLE_MANAGE);
        addProjectUser(form);
    }

    @Override
    public Integer getProUserCountByProUuId(String proUuId, String name) {
        return projectUserMapper.selectProUserCountByProUuId(proUuId, name);
    }
}
