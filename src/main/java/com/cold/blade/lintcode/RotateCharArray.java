package com.cold.blade.lintcode;

/**
 * @author cold_blade
 * @version 1.0
 * @description
 * @date 2018/9/25
 */
public final class RotateCharArray {

    private RotateCharArray() {
    }

    public static void solution(char[] str, int offset) {
        if (null == str || offset < 0 || offset >= str.length) {
            throw new IllegalArgumentException("param exception");
        }
        if (0 == str.length) {
            return;
        }
        char tmp;
        for (int i = 0; i < offset; ++i) {
            tmp = str[str.length - 1];
            for (int j = str.length - 1; j > 0; --j) {
                str[j] = str[j - 1];
            }
            str[0] = tmp;
        }
    }
}
