package com.cold.blade.leetcode;

import java.util.HashMap;
import java.util.Map;

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
 *         给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *     链接：https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author cold_blade
 * @date 2020/8/21
 * @version 1.0
 */
public class Problem13 {

    public int solution(String roman) {
        if (null == roman || roman.isEmpty()) {
            return 0;
        }
        int len = roman.length();
        Map<Character, Integer> keyValue = init();
        int result = 0;
        int cur;
        int pre;
        for (int i = 0; i < len; i++) {
            cur = keyValue.get(roman.charAt(i));
            result += cur;
            if (i > 0) {
                pre = keyValue.get(roman.charAt(i - 1));
                if (pre < cur) {
                    result -= (2 * pre);
                }
            }
        }
        return result;
    }

    private Map<Character, Integer> init() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }
}
