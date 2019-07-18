package com.cold.blade.lintcode;

/**
 * 将罗马数值转换成阿拉伯数字
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public final class RomanToInt {

    private RomanToInt() {
    }

    public static int romanToInt(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        int curNum = parse(s.charAt(0));
        if (1 == length) {
            return curNum;
        }
        int result = 0;
        int nextNum = 0;
        for (int i = 1; i < length; i++) {
            nextNum = parse(s.charAt(i));
            if (curNum < nextNum) {
                result -= curNum;
            } else {
                result += curNum;
            }
            curNum = nextNum;
        }
        return result + nextNum;
    }

    private static int parse(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("illegal argument: " + ch);
        }
    }
}
