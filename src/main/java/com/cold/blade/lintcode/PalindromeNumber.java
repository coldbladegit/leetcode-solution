package com.cold.blade.lintcode;

/**
 * 判断是否为回文数
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public final class PalindromeNumber {

    private PalindromeNumber() {
    }

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; ++i, --j) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeNumber2(int x) {
        if (x < 0) {
            return false;
        }
        return x == NumberReverse.reverse2(x);
    }
}
