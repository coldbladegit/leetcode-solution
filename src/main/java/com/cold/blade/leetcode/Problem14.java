package com.cold.blade.leetcode;

import java.util.LinkedList;

/**
 * @Description
 *      问题描述：
 *          编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
 *          说明：所有输入只包含小写字母 a-z 。
 *      链接：https://leetcode-cn.com/problems/longest-common-prefix/
 *
 *      思路：
 *          方案一：纵向比较
 *          方案二：横向比较（选择、归并）
 *
 * @author cold_blade
 * @date 2020/8/24
 * @version 1.0
 */
public class Problem14 {

    public String solution1(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Integer.min(minLen, str.length());
        }
        StringBuilder sb = new StringBuilder(minLen);
        String first = strs[0];
        char c;
        boolean equal;
        for (int i = 0; i < minLen; i++) {
            c = first.charAt(i);
            equal = true;
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String solution2(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 类比选择排序思想
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            // 空串提前返回
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    public String solution3(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        LinkedList<String> link = new LinkedList<>();
        for (String str : strs) {
            link.addLast(str);
        }
        String prefix = link.pollFirst();
        while (!link.isEmpty() && !prefix.isEmpty()) {
            prefix = longestCommonPrefix(prefix, link.pollFirst());
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }
}
