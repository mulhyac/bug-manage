package com.sunny.bugmanage.org.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.controller.OrganizationController
 * @date 2017-07-03 10:46
 * @description:
 */
//@Api(value = "OrganizationController", description = "组织相关接口")
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /**
     * 验证组织名是否存在
     *
     * @param name
     * @return
     */
    // @ApiOperation(value = "验证组织名是否存在", notes = "验证组织名是否存在")
    @GetMapping(value = "/check/{name:.+}")
    public BaseResult checkOrgName(@PathVariable("name") String name) {
        return organizationService.checkOrgName(name);
    }

    /**
     * 获取全部组织
     *
     * @param form
     * @return
     */
    //@ApiOperation(value = "获取全部组织", notes = "获取全部组织支持模糊查询、分页")
    @GetMapping
    public BaseResult checkOrgName(OrgForm form) {
        return ResultUtils.success(organizationService.getAllOrg(form));
    }

    // @ApiOperation(value = "创建组织", notes = "创建组织")

    /**
     * 创建组织
     *
     * @param form
     * @return
     */
    @PutMapping
    public BaseResult addOrg(@RequestBody @Validated({InsertGroup.class}) OrgForm form) {
        organizationService.addOrg(form);
        return ResultUtils.success("创建组织成功");
    }

    /**
     * 根据组织uuid删除组织
     *
     * @param uuId
     * @return
     */
    @DeleteMapping("/{uuId:.+}")
    public BaseResult removeOrgByUUId(@PathVariable("uuId") String uuId) {
        organizationService.removeOrgByUUID(uuId);
        return ResultUtils.success("删除组织成功");
    }

}
