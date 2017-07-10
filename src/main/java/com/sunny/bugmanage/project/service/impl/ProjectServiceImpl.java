package com.sunny.bugmanage.project.service.impl;

import com.sunny.bugmanage.common.utils.UUIDUtills;
import com.sunny.bugmanage.project.form.ProjectForm;
import com.sunny.bugmanage.project.mapper.ProjectMapper;
import com.sunny.bugmanage.project.model.Project;
import com.sunny.bugmanage.project.service.ProjectService;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProject(ProjectForm form) {
        Project project=new Project();
        String uuId= UUIDUtills.getUUID();
        project.setUuid(uuId);
        project.setName(form.getName());
        projectMapper.insertSelective(project);
    }

    @Override
    public Integer getProCountByOrgUuId(String orgUuId) {
        return projectMapper.selectProCountByOrgUuId(orgUuId);
    }
}
