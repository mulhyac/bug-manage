package com.sunny.bugmanage.common.fields;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.fields.Role
 * @date 2017-07-05 22:45
 * @description:
 */
public class Role {
    private Role(){
        super();
    }
    /**
     * 组织成员---管理员
     */
    public static Byte ORG_USER_MANAGE=30;

    /**
     *  删除的最小权限
     */
    public static Byte DEL_MIN_ROLE=25;

    /**
     * 获取职位
     *
     * @param role
     * @return
     */
    public static String getPositionByRole(Byte role) {
        if (role == null) {
            return "成员";
        }
        switch (role) {
            case 1:
                return "成员";
            case 20:
                return "项目负责";
            case 30:
                return "管理员";
            default:
                return "成员";
        }
    }
}
