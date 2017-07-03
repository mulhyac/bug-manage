package com.sunny.bugmanage.org.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.common.valid.UpdateGroup;
import com.sunny.bugmanage.org.form.OrgUserForm;
import com.sunny.bugmanage.org.service.OrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.controller.OrganizationUserController
 * @date 2017-07-03 15:53
 * @description:
 */
//@Api(value = "OrganizationController", description = "组织相关接口")
@RestController
@RequestMapping("/org/user")
public class OrganizationUserController {
    @Autowired
    private OrganizationUserService organizationUserService;

    /**
     * 添加组织成员
     *
     * @param form
     * @return
     */
    @PutMapping
    public BaseResult addOrgUser(@RequestBody @Validated({InsertGroup.class}) OrgUserForm form) {
        organizationUserService.addOrgUser(form);
        return ResultUtils.success("添加组织成员成功");
    }

    /**
     * 修改组织成员
     * @param form
     * @return
     */
    @PostMapping
    public BaseResult modifierOrgUser(@RequestBody @Validated({UpdateGroup.class}) OrgUserForm form) {
        organizationUserService.modifierOrgUserByUserUuId(form);
        return ResultUtils.success("修改组织成员成功");
    }
}
