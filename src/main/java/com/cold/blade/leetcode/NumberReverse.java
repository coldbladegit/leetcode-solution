package com.cold.blade.leetcode;

/**
 * @description
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public final class NumberReverse {

    private NumberReverse() {
    }

    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int from;
        int to;
        if (x > 0) {
            from = 0;
            to = chars.length / 2;
        } else {
            from = 1;
            to = chars.length / 2 + 1;
        }
        for (int i = from, j = chars.length - 1; i < to; ++i, --j) {
            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;
        }
        long result = Long.valueOf(String.valueOf(chars));
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
