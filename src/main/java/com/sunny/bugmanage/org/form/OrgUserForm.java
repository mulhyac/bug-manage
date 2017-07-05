package com.sunny.bugmanage.org.form;

import com.sunny.bugmanage.common.form.BaseForm;
import com.sunny.bugmanage.common.valid.InsertGroup;
import com.sunny.bugmanage.common.valid.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.form.OrgUserForm
 * @date 2017-07-03 14:37
 * @description:
 */
public class OrgUserForm extends BaseForm<Long> {
    private static final long serialVersionUID = 9045377046890597009L;
    /**
     * 组织uuid
     */
    @NotNull(message = "请输入组织uuid", groups = {InsertGroup.class})
    private String orgUuid;
    /**
     * 用户uuid
     */
    @NotNull(message = "请输入用户uuid", groups = {InsertGroup.class})
    private String userUuid;
    /**
     * 姓名
     */
    @Length(max = 50, message = "用户名称应该在50个字符内", groups = {InsertGroup.class, UpdateGroup.class})
    private String name;
   /**
     * 职位
     */
    @Length(max = 50, message = "职位应该在50个字符内", groups = {InsertGroup.class,UpdateGroup.class})
    private String position;
    /**
     * 角色
     */
    @Max(value = 29, message = "请输入正确的角色", groups = {InsertGroup.class, UpdateGroup.class})
    private Byte role;

    public String getOrgUuid() {
        return orgUuid;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRole() {
        return role == null ? 1 : role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
