package com.cold.blade.utils;

/**
 * @author cold_blade
 * @version 1.0
 * @description
 * @date 2018/9/17
 */
public final class LogAlgorithm {

    private LogAlgorithm() {
    }

    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
