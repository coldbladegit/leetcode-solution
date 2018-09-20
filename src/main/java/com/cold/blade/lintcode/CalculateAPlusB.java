package com.cold.blade.lintcode;

/**
 * @author cold_blade
 * @version 1.0
 * @description
 * @date 2018/9/19
 */
public final class CalculateAPlusB {

    private CalculateAPlusB() {

    }

    public static long solution(long a, long b) {
        long result;
        long forward;
        do {
            result = a ^ b;
            forward = (a & b) << 1;
            a = result;
            b = forward;
        } while (forward != 0);
        return result;
    }
}
