package com.cold.blade.lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s，找到s中最长的回文子串。你可以假设 s 的最大长度为 1000.
 *
 * 分析：
 * 回文是一个正读和反读都相同的字符串，例如，"aba"是回文，而"abc"不是。
 *
 * 解题思路：
 * 解法一、暴力解法：
 *           依次判断[2, len]长度范围内的所有子字符串是否为回文字串
 *           时间复杂度为：O(n) = n * n * n; 空间复杂度为 O(1)；
 * 解法二、动态规划：
 *           考虑对解法一做一个优化，设想如下场景：当我们在判断所有长度为[i, j]的子串是否为回文串时，
 *           若 S[i + 1, j - 1]是回文串的话，则只需判断S[i] == S[j]是否成立即可，该动态规划算法
 *           需求当前判断的子串最小长度为3，因此需要初始化长度为1、2的回文子串即可。
 *           时间复杂度为：O(n) = n * n; 空间复杂度为 O(n) = 2 * n；
 *
 * 解法三、中心扩展法：
 *           事实上，我们通过从回文中心不断向两边扩展也可以达到效果，但这里的回文中心存在两类：
 *               1、回文中心是真实的 S 中的元素，比如 "aba" 中的 'b'；
 *               2、回文中心是一个虚拟概念，比如 “abba” 中的两个'b'中间处；
 *           因此针对 S 中的每个元素，我们都需要做两次扩展，以自身和下一个元素之间；
 *           时间复杂度为：O(n) = n * n; 空间复杂度为 O(1)
 *
 * @author cold_blade
 * @date 2019/7/25
 * @version 1.0
 */
public final class PalindromeString {

    private PalindromeString() {
    }

    /**
     * 暴力解法
     *
     * @param s 入参字符串
     * @return 最长回文子串
     */
    public static String doGruffly(String s) {
        String result = preParse(s);
        if (result != null) {
            return result;
        }
        int prePalindromeBegin = 0;
        int prePalindromeEnd = 1;// 开区间
        int length = s.length();
        // 长度为1的子串肯定为回文串
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                if (isPalindrome(s, i, len)) {
                    prePalindromeBegin = i;
                    prePalindromeEnd = i + len;
                    // 同一长度的子串取一个即可
                    break;
                }
            }
        }

        return s.substring(prePalindromeBegin, prePalindromeEnd);
    }

    private static boolean isPalindrome(String s, int begin, int length) {
        for (int i = begin, j = begin + length - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划解法
     *
     * @param s 入参字符串
     * @return 最长回文子串
     */
    public static String doDynamic(String s) {
        String result = preParse(s);
        if (result != null) {
            return result;
        }
        int length = s.length();
        // prePreSet 用于保存当前遍历时，用于判断当前子串的子串是否为回文
        Set<String> prePreSet = init(s, 1);
        // preSet 用于保存当前遍历的结果。
        Set<String> preSet = init(s, 2);
        Set<String> curSet;
        for (int len = 3; len <= length; len++) {
            curSet = new HashSet<>();
            for (int i = 0; i <= length - len; i++) {
                if (prePreSet.contains(s.substring(i + 1, i + len - 1)) && s.charAt(i) == s.charAt(i + len - 1)) {
                    curSet.add(s.substring(i, i + len));
                }
            }
            if (curSet.isEmpty()) {
                break;
            }
            prePreSet = preSet;
            preSet = curSet;
        }
        return preSet.iterator().next();
    }

    private static Set<String> init(String s, int length) {
        Set<String> palindromeSet = new HashSet<>();
        for (int i = 0; i <= s.length() - length; ++i) {
            if (s.charAt(i) == s.charAt(i + length - 1)) {
                palindromeSet.add(s.substring(i, i + length));
            }
        }
        return palindromeSet;
    }

    public static String doExpandAroundCenter(String s) {
        String result = preParse(s);
        if (result != null) {
            return result;
        }
        // 最小的回文子串长度为1
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            int curExpandLen = Math.max(doExpand(s, i, false), doExpand(s, i, true));
            if (maxLen < curExpandLen) {
                maxLen = curExpandLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     *  围绕假设的回文中心处开始进行扩展
     *
     * @param s 入参字符串
     * @param index 回文中心 or 回文中心左边元素索引。
     * @param isVirtual 是否为虚拟的回文中心
     * @return isVirtual 为true时，当虚拟的回文中心不存在（"ab",回文中心在'a'与'b'之间），返回0，否则返回回文子串的长度
     */
    private static int doExpand(String s, int index, boolean isVirtual) {
        int left = isVirtual ? index : index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为right 和 left是索引，而索引是从0开始的，因此计算长度时要 + 1，
        // 而这里由于while循环导致两个索引都越界了一位 故 -2 + 1 = -1
        return right - left - 1;
    }

    private static String preParse(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }
        return null;
    }
}
