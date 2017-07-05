package com.sunny.bugmanage.org.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.common.valid.SelectGroup;
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
     * 根据组织uuid获取成员 (支持模糊搜索)
     *
     * @return
     */
    @GetMapping("/{uuId:.+}")
    public BaseResult getOrgUserByOrgUUId(@PathVariable("uuId") String uuId, @Validated({SelectGroup.class}) OrgUserForm form) {
        return ResultUtils.success("获取组织成员成功",organizationUserService.getOrgUserByOrgUUId(uuId,form));
    }

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
     * 根据id修改组织成员
     *
     * @param form
     * @return
     */
    @PostMapping("/{id:.+}")
    public BaseResult modifierOrgUser(@PathVariable("id") Long id,@RequestBody @Validated({UpdateGroup.class}) OrgUserForm form) {
        organizationUserService.modifierOrgUserByUserUuId(id,form);
        return ResultUtils.success("修改组织成员成功");
    }
}
