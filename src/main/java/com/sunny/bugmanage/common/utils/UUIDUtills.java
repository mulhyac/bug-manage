package com.sunny.bugmanage.common.utils;

import java.util.UUID;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.utils.UUIDUtills
 * @date 2017-06-09 17:06
 * @description:
 */
public class UUIDUtills {
    private UUIDUtills() {
        super();
    }

    /**
     * 前缀+_+uuid
     *
     * @param prefix
     * @return
     */
    public static String getUUID(String prefix) {
        String uuid = UUID.randomUUID().toString();
        return prefix + "_" + uuid.replaceAll("-", "");
    }

    /**
     * 默认id_+uuid
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
