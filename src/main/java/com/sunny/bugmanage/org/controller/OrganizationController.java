package com.sunny.bugmanage.org.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.service.OrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.controller.OrganizationController
 * @date 2017-07-03 10:46
 * @description:
 */
@Api(value = "OrganizationController", description = "组织相关接口")
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    
    @GetMapping(value = "/check/{name:.+}")
    public BaseResult checkOrgName(@PathVariable("name") String name){
       return   organizationService.checkOrgName(name);
    }
    @GetMapping()
    public BaseResult checkOrgName(OrgForm form){
        return ResultUtils.success(organizationService.getAllOrg(form));
    }

}
