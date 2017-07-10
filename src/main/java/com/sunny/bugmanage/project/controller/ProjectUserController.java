package com.sunny.bugmanage.project.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.project.form.ProjectUserForm;
import com.sunny.bugmanage.project.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.bugmanage.project.controller.ProjectUserController
 * @date 2017-07-10 14:15
 * @description:
 */
@RestController
@RequestMapping("/project")
public class ProjectUserController {
    @Autowired
    private ProjectUserService projectUserService;
    //添加成员

    /**
     * 添加成员
     *
     * @param form
     * @return
     */
    @PutMapping("/{proUuId:.+}/user")
    public BaseResult addProjectUser(@PathVariable("uuId") String proUuId, @RequestBody @Validated({InsertGroup.class}) ProjectUserForm form) {
        form.setProUuid(proUuId);
        projectUserService.addProjectUser(form);
        return ResultUtils.success("添加项目成员成功");
    }
}
