package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *     '.' 匹配任意单个字符
 *     '*' 匹配零个或多个前面的那一个元素
 *     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *     说明:
 *       s 可能为空，且只包含从 a-z 的小写字母。
 *       p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *     链接：https://leetcode-cn.com/problems/regular-expression-matching
 *
 *   思路：动态规划加状态转移，核心需要处理的场景为字母 + 星号的组合的匹配，本质上只会有两种情况：
 *      1. 匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
 *      2. 不匹配字符，将该组合扔掉，不再进行匹配。
 *
 * @author cold_blade
 * @date 2020/7/29
 * @version 1.0
 */
public class Problem10 {

    public boolean solution(String s, String p) {
        if (null == s) {
            return null == p;
        } else if (null == p) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        int[][] dp = new int[sLen + 1][pLen + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if ('*' == p.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 2];
                    if (i != 0 && equal(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    }
                } else {
                    if (i != 0 && equal(s.charAt(i - 1), p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLen][pLen] == 1;
    }

    private boolean equal(char s, char p) {
        return s == p || '.' == p;
    }
}
