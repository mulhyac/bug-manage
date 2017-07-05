package com.sunny.bugmanage.org.model.vo;

import com.sunny.bugmanage.org.model.OrganizationUser;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.model.vo.OrganizationUserVo
 * @date 2017-07-05 13:03
 * @description:
 */
public class OrganizationUserVo extends OrganizationUser {
    private static final long serialVersionUID = -3579195685598825179L;
    /**
     * 用户头像
     */
    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
