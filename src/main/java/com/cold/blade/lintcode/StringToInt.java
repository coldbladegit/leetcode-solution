package com.cold.blade.lintcode;

/**
 * 将字符串转换成整数。要求如下：
 *   1、该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止；
 *   2、第一个非空字符为正或者负号之后面尽可能多的连续数字组合起来；
 *   3、字符串除了有效的整数部分之后也可能会存在无效的字符，这些字符可以被忽略，它们对于函数不应该造成影响；
 *   4、假如该字符串中的第一个非空格字符不是一个有效整数字符、+、以及 - 等字符时，视为无效字串；
 *   5、在任何情况下，若函数不能进行有效的转换时，请返回 0；
 *   6、整数的范围控制在2^32 - 1 与 -2^31之间；
 *
 * 解题思路：
 *    根据题目要求，首先检查入参字符串的有效性，无效直接返回0；在检测有效性的同时确定第一个有效的整数字符（不包含0）、
 *    + 或 - 的位置 begin，通过s.charAt(begin) 确定整数是否为负数和是否begin++（ch == '+' || ch == '-'），
 *    然后从 begin 处开始进行遍历并计算；还有一个关键点：一定是连续数字，对于"124www234"这种，后面的"www234"都会被忽略
 *
 * @author cold_blade
 * @date 2019/7/27
 * @version 1.0
 */
public final class StringToInt {

    private StringToInt() {
    }

    public static int valueOf(String s) {
        int begin = check(s);
        if (-1 == begin) {
            return 0;
        }
        char firstChar = s.charAt(begin);
        boolean isNegative = firstChar == '-';
        if (isNegative || firstChar == '+') {
            begin++;
        }
        long result = 0;
        for (int index = begin; index < s.length(); index++) {
            char ch = s.charAt(index);
            // 只处理连续数字
            if (ch > '9' || ch < '0') {
                break;
            }
            result = result * 10 + (ch - 48);
        }
        if (isNegative) {
            result = 0 - result;
            return result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) result;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    /**
     * 检查入参的有效性
     *
     * @param s 待转换的字符串
     * @return 字符串有效返回第一个有效整数字符、+ 或 - 处的索引，否则返回-1
     */
    private static int check(String s) {
        for (int index = 0; index < s.length(); ++index) {
            char ch = s.charAt(index);
            if (ch >= '1' && ch <= '9' || ch == '+' || ch == '-') {
                // 字符串前面的0无效
                return index;
            } else if (ch != ' ') {
                break;
            }
        }
        return -1;
    }
}
