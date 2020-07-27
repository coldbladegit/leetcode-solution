package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *     首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *     如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 *     假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 *     该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 *     注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
 *     则你的函数不需要进行转换，即无法进行有效转换。
 *     在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *     链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * @author cold_blade
 * @date 2020/7/27
 * @version 1.0
 */
public class Problem8 {

    public int solution(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }
        int size = str.length();
        boolean isNegative = false;
        boolean isBeforeNumber = true;
        boolean isFirstSymbol = true;
        int result = 0;
        char c;
        for (int i = 0; i < size; ++i) {
            c = str.charAt(i);
            if (c >= 48 && c <= 57) {
                // 数字字符(Integer.MAX_VALUE = 2147483647 Integer.MIN_VALUE = -2147483648)
                if (result < 214748364) {
                    result = result * 10 + (c - 48);
                } else if (214748364 == result && c <= 55) {
                    result = result * 10 + (c - 48);
                    break;
                } else {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                isBeforeNumber = false;
            } else if (isBeforeNumber && ('-' == c || '+' == c) && isFirstSymbol) {
                // 首次遇到+/-字符，判断当前是否为负数，注只有数字之前的才有效
                isNegative = ('-' == c);
                isFirstSymbol = false;
            } else if (c != ' ' || !isBeforeNumber || !isFirstSymbol) {
                // 非空字符或非数字字符之前的空格或非符号字符之前的空格字符
                break;
            }
        }

        return isNegative ? 0 - result : result;
    }
}
