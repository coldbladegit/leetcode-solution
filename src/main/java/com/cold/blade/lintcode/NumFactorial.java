package com.cold.blade.lintcode;

import com.cold.blade.utils.LogAlgorithm;

/**
 * @author cold_blade
 * @version 1.0
 * @description
 * @date 2018/9/17
 */
public final class NumFactorial {

    /**
     * number阶乘的位数
     */
    public static final int NUM_LENGTH = 1;
    /**
     * number阶乘的末尾0的个数
     */
    public static final int NUM_ZERO_COUNT = 2;

    public static int solution(int num, int mode) {
        if (num < 0) {
            throw new IllegalArgumentException("num must >= 0");
        }
        if (0 == num) {
            return 1;
        }
        if (NUM_LENGTH == mode) {
            return calculateLength(num);
        } else if (NUM_ZERO_COUNT == mode) {
            return calculateZeroCount(num);
        } else {
            throw new IllegalArgumentException("mode can only be 1 or 2");
        }
    }

    /**
     * 可以将n!表示成10的次幂,即n!=10^M(10的M次方)则不小于M的最小整数就是 n!的位数,对该式两边取对数,
     * 有 M =log10^n! 即: M = log10^1+log10^2+log10^3...+log10^n
     * @param num
     * @return
     */
    private static int calculateLength(int num) {
        double len = 0.0;
        for (int i = 1; i <= num; ++i) {
            len += Math.log10(i);
        }
        return (int) len + 1;
    }

    /**
     * 一个数 n 的阶乘末尾有多少个 0 取决于从 1 到 n 的各个数的因子中 2 和 5 的个数
     * 而 2 的个数是远远多余 5 的个数的,因此求出 5 的个数即可,求解因子 5 的个数的方
     * 法是用 n 不断除以 5,直到结果为 0,然后把中间得到的结果累加
     * @param num
     * @return
     */
    private static int calculateZeroCount(int num) {
        int cnt = 0;
        for (int i = 5; i <= num; i += 5) {
            cnt += LogAlgorithm.log(i, 5);
        }
        return cnt;
    }
}
