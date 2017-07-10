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
    @GetMapping("/{orgUuId:.+}")
    public BaseResult getOrgUserByOrgUUId(@PathVariable("orgUuId") String orgUuId, @Validated({SelectGroup.class}) OrgUserForm form) {
        return ResultUtils.success("获取组织成员成功",organizationUserService.getOrgUserByOrgUUId(orgUuId,form));
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
     * 根据成员userUuId修改组织成员
     *
     * @param form
     * @return
     */
    @PostMapping("/{orgUuId:.+}/{userUuId:.+}")
    public BaseResult modifierOrgUser(@PathVariable("orgUuId") String orgUuId,@PathVariable("userUuId") String userUuId,@RequestBody @Validated({UpdateGroup.class}) OrgUserForm form) {
        form.setOrgUuid(orgUuId);
        organizationUserService.modifierOrgUserByUserUuId(userUuId,form);
        return ResultUtils.success("修改组织成员成功");
    }

    /**
     * 根据组织uuid和成员uuid删除组织成员
     *
     *
     * @param userUuId
     * @return
     */
    @DeleteMapping("/{orgUuId:.+}/{userUuId:.+}")
    public BaseResult removeOrgUserById(@PathVariable("orgUuId") String orgUuId,@PathVariable("userUuId") String userUuId) {
        organizationUserService.removeOrgUserById(orgUuId,userUuId);
        return ResultUtils.success("删除组织成员成功");
    }
}
