package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *     假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 *     请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *   思路：
 *     方案一：将该整数当做一个字符数组，从字符数组末尾开始遍历，遇到0直接跳过，直到遇到第一个非0数字，
 *            然后每移动一位就乘以10，当遍历到字符数组的第一个字符时，若字符为'-'，需要对当前结果取反
 *            特别注意控制溢出的情况。
 *
 * @author cold_blade
 * @date 2020/7/25
 * @version 1.0
 */
public class Problem7 {

    public int solutionOne(int num) {
        String str = Integer.toString(num);
        int result = 0;
        int n;
        for (int i = str.length() - 1; i > 0; --i) {
            n = str.charAt(i) - 48;
            if (result < 99999999) {
                result = result * 10 + n;
            } else {
                result = secure(n, result);
                if (-1 == result) {
                    return 0;
                }
            }
        }
        // 数值溢出了
        if (-1 == result) {
            return 0;
        }
        char c = str.charAt(0);
        if (c == '-') {
            return 0 - result;
        } else if (c == '+') {
            return result;
        } else {
            result = secure(c - 48, result);
            return -1 == result ? 0 : result;
        }
    }

    private int secure(int n, int result) {
        int tmp = Integer.MAX_VALUE / 10;
        if (tmp > result) {
            return result * 10 + n;
        } else if (tmp == result) {
            return Integer.MAX_VALUE % 10 < n ? 0 : result * 10 + n;
        }
        return -1;
    }
}
