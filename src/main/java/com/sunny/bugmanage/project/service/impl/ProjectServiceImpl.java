package com.sunny.bugmanage.project.service.impl;

import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.utils.UUIDUtills;
import com.sunny.bugmanage.org.service.OrganizationService;
import com.sunny.bugmanage.project.form.ProjectForm;
import com.sunny.bugmanage.project.mapper.ProjectMapper;
import com.sunny.bugmanage.project.model.Project;
import com.sunny.bugmanage.project.service.ProjectService;
import com.sunny.bugmanage.project.service.ProjectUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.service.impl.ProjectServiceImpl
 * @date 2017-07-10 13:34
 * @description:
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private OrganizationService organizationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProject(ProjectForm form) {
        String orgUuid = form.getOrgUuid();
        //organizationService.getOrgProLimitByUUID(orgUuid);
        if (organizationService.getOrgProLimitByUUID(orgUuid) < getProCountByOrgUuId(orgUuid)) {
           throw new BugManageException(ResultEnum.ORG_PRO_EXCEED_LIMIT);
        }

        Project project = new Project();
        String uuId = UUIDUtills.getUUID();
        //project.setName(form.getName());
        BeanUtils.copyProperties(form,project);
        project.setUuid(uuId);
        projectMapper.insertSelective(project);
        //添加项目成员
        projectUserService.addProjectUserBySelf(uuId);
    }

    @Override
    public Integer getProCountByOrgUuId(String orgUuId) {
        return projectMapper.selectProCountByOrgUuId(orgUuId);
    }

    @Override
    public Integer getPeopleLimitByProUuId(String proUuId) {
        return projectMapper.selectPeopleLimitByProUuId(proUuId);
    }
}
