package com.sunny.bugmanage.org.form;

import com.sunny.bugmanage.common.form.BaseForm;
import com.sunny.bugmanage.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.form.OrgForm
 * @date 2017-07-03 11:03
 * @description:
 */
public class OrgForm extends BaseForm<String> {
    private static final long serialVersionUID = -947466584450351804L;
    /**
     * 组织名称
     */
    @NotNull(message = "请输入组织名称", groups = InsertGroup.class)
    @Length(max = 50, min = 3, message = "组织名称在3-50个字符", groups = InsertGroup.class)
    private String name;
    /**
     * 简介
     */
    @Length(max = 200, message = "简介应该在200字符内", groups = {InsertGroup.class})
    private String intro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
