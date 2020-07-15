package com.cold.blade.lintcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 规则：
 *   '.' 匹配任意单个字符；
 *   '*' 匹配零个或多个前面的那一个元素；
 * 解题思路：
 *   方法一：回溯法，从（i = 0）开始遍历 s ，与从(j = 0)处开始遍历的 p 进行匹配，
 *   对 p 中 j 的移动有如下几种情况：
 *     1、当 j 指向 '*'时，记录下前一个字符，并且 j 不做移动；
 *     2、当 j 指向 '.'时，i 与 j都同时移动一个字符；
 * @author cold_blade
 * @date 2019/8/2
 * @version 1.0
 */
public class StringMatcher {

    public boolean backTrackSolution(String str, String pattern) {
        if (str.isEmpty()) {
            return pattern.isEmpty() || (pattern.length() == 2 && pattern.charAt(1) == '*');
        } else if (pattern.isEmpty() || "*".startsWith(pattern)) {
            return false;
        } else if (".*".equals(pattern) || ".*.".equals(pattern)) {
            return true;
        }
        int strSize = str.length();
        int patternSize = pattern.length();
        int j = 0;
        int i = 0;
        for (; j < patternSize && i < strSize; j++) {
            char pChar = pattern.charAt(j);
            for (; i < strSize; ) {
                char sChar = str.charAt(i);
                if (pChar == '*') {
                    // pattern以*开头的情况在上面的异常流程已经处理
                    if (pattern.charAt(j - 1) == sChar) {
                        // pattern第j个字符为*，且第j - 1个字符与string的第i个字符相等，pattern偏移不动，string偏移向后移动一位
                        i++;
                        continue;
                    }
                    // 继续尝试pattern的j + 1个字符继续与string的第i个字符进行匹配
                    break;
                } else if (pChar == sChar || pChar == '.') {
                    // string偏移移动到下一位
                    i++;
                    break;
                } else if (j + 1 < patternSize && pattern.charAt(j + 1) == '*') {
                    // pattern消费掉了下一个*
                    j++;
                    break;
                } else {
                    return false;
                }
            }
        }
        if (i < strSize) {
            return false;
        } else if (j == patternSize) {
            return true;
        } else if (pattern.charAt(j) == '*') {
            // pattern 当前遍历到*字符，则需要
        }
        // pattern偏移到末尾，或最后一个字符为*
        return j == patternSize || pattern.charAt(patternSize - 1) == '*';
    }
}
