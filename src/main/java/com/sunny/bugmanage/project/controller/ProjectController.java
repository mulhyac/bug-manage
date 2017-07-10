package com.sunny.bugmanage.project.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.project.form.ProjectForm;
import com.sunny.bugmanage.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.controller.ProjectController
 * @date 2017-07-10 13:33
 * @description:
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    /**
     * 创建项目
     *
     * @param form
     * @return
     */
    @PutMapping
    public BaseResult addProject(@RequestBody @Validated({InsertGroup.class}) ProjectForm form) {
        projectService.addProject(form);
        return ResultUtils.success("创建项目成功");
    }
   
}
