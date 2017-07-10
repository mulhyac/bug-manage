package com.sunny.bugmanage.common.enums;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.enums.ResultEnum
 * @date 2017-06-06 14:25
 * @description:
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(0, "成功!"),
    /**
     * 账号不存在
     */
    USER_NAME_NOT_EXIST(1, "账号不存在"),
    /**
     * 账号不存在
     */
    POSSWORD_ERROR(2, "密码错误"),
    /**
     * 注册用户异常
     */
    INSERT_APP_USER_ERROR(3, "注册用户异常"),
    /**
     * 账号存在
     */
    USER_NAME_EXIST(4, "账号已经存在"),
    /**
     *   权限不足，请联系管理员
     */
    PERMISSION_DENIED(5,"权限不足，请联系管理员"),
    /**
     * 参数异常
     */
    PARAMETER_ERROR(100, "参数异常!"),
    /**
     * 组织名称存在
     */
    ORG_NAME_EXIST(200, "组织名称存在"),
    /**
     * 组织名称不存在
     */
    ORG_NAME_NOT_EXIST(201, "组织名称不存在"),
    /**
     * 组织成员已经添加
     */
    ORG_USER_EXIST(202, "成员已经添加"),
    /**
     * 组织成员人员达到上限
     */
    ORG_USER_EXCEED_LIMIT(202, "组织成员人员达到上限"),
    /**
     * 项目成员达到上限
     */
    PRO_USER_EXCEED_LIMIT(300, "组织成员人员达到上限"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
