package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *     你能不将整数转为字符串来解决这个问题吗？
 *     链接：https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author cold_blade
 * @date 2020/7/28
 * @version 1.0
 */
public class Problem9 {

    public boolean solution(int num) {
        if (num < 0) {
            return false;
        }
        int result = 0;
        int tmp = num;
        while (tmp > 0) {
            // Integer.MAX_VALUE = 2147483647
            result = result * 10 + tmp % 10;
            if (result < 0) {
                // int数值溢出
                return false;
            }
            tmp = tmp / 10;
        }

        return result == num;
    }
}
