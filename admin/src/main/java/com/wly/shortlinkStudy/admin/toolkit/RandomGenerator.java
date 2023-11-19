package com.wly.shortlinkStudy.admin.toolkit;

import java.security.SecureRandom;

/**
 * 短连接分组ID随机生成器
 */
public final class RandomGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 生成随机分组ID
     * @return 分组ID
     */
    public static String generateRandom() {
        return generateRandomString(6);
    }

    /**
     * 生成随机分组ID
     * @param length 生成多少位
     * @return 分组ID
     */
    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}
