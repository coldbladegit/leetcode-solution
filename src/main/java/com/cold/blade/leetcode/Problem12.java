package com.cold.blade.leetcode;

/**
 * @Description
 *     问题描述：
 *         罗马数字包含以下七种字符： I(1)， V(5)， X(10)， L(50)， C(100)， D(500) 和 M(1000)
 *         整数转罗马数字，通常情况下，罗马数字中小的数字在大的数字的右边。
 *         但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 *         所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 *         这个特殊的规则只适用于以下六种情况：
 *             1、I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *             2、X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 *             3、C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *         给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 *     链接：https://leetcode-cn.com/problems/integer-to-roman
 *
 * @author cold_blade
 * @date 2020/8/21
 * @version 1.0
 */
public class Problem12 {

    public String solution(int num) {
        if (num < 0 || num > 3999) {
            return "";
        }
        String roman = parseThousand(num / 1000);
        roman += parse((num % 1000) / 100, "M", "D", "C");
        roman += parse((num % 100) / 10, "C", "L", "X");
        roman += parse(num % 10, "X", "V", "I");
        return roman;
    }

    private String parseThousand(int n) {
        if (0 == n) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append("M");
            n--;
        } while (n > 0);

        return sb.toString();
    }

    private String parse(int n, String carryBit, String midBit, String curBit) {
        if (0 == n) {
            return "";
        } else if (9 == n) {
            return curBit + carryBit;
        } else if (n >= 5) {
            StringBuilder sb = new StringBuilder();
            sb.append(midBit);
            while (n > 5) {
                sb.append(curBit);
                n--;
            }
            return sb.toString();
        } else if (4 == n) {
            return curBit + midBit;
        } else {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(curBit);
                n--;
            } while (n > 0);
            return sb.toString();
        }
    }
}
