package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *   思路：
 *     方案一、暴力方案：
 *           依次判断[2, len]长度范围内的所有子字符串是否为回文字串
 *           时间复杂度为：O(n) = n ^ 3; 空间复杂度为 O(1)；
 *     方案二、动态规划：
 *           考虑对方案一做一个优化，设想如下场景：当我们在判断所有长度为[i, j]的子串是否为回文串时，
 *           若 S[i + 1, j - 1]是回文串的话，则只需判断S[i] == S[j]是否成立即可，该动态规划算法
 *           需求当前判断的子串最小长度为3，因此需要初始化长度为1、2的回文子串即可。
 *           时间复杂度为：O(n) = n * n; 空间复杂度为 O(n) = 2 * n；
 *
 * @author cold_blade
 * @date 2020/7/22
 * @version 1.0
 */
public class Problem5 {

    public String solutionOne(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int maxLen = 0;
        int palindromeLen;
        String maxPalindrome = "";
        for (int i = 0; i < chars.length; ++i) {
            for (int j = chars.length - 1; j > i; --j) {
                if (isPalindrome(chars, i, j)) {
                    palindromeLen = j - i + 1;
                    if (maxLen < palindromeLen) {
                        maxLen = palindromeLen;
                        maxPalindrome = str.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return maxPalindrome;
    }

    public String solutionTwo(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        // 初始化长度为1的回文串索引数组,并以该数组进行扩展寻找更长长度的回文串索引数组
        int[] palindromeOneArray = new int[chars.length];
        initPalindromeArray(chars, palindromeOneArray, true);
        String maxPalindrome = findMaxPalindrome(str, chars, palindromeOneArray, 1);
        // 初始化长度为2的回文串索引数组，若存在，则以该数组进行扩展寻找更长长度的回文串索引数组
        int[] palindromeTwoArray = new int[chars.length - 1];
        if (initPalindromeArray(chars, palindromeTwoArray, false)) {
            String tmp = findMaxPalindrome(str, chars, palindromeTwoArray, 2);
            if (maxPalindrome.length() < tmp.length()) {
                maxPalindrome = tmp;
            }
        }

        return maxPalindrome;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        do {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        } while (start < end);
        return true;
    }

    private boolean initPalindromeArray(char[] chars, int[] palindromeArray, boolean single) {
        boolean exist = false;
        if (single) {
            for (int i = 0; i < palindromeArray.length; ++i) {
                palindromeArray[i] = i;
            }
            exist = true;
        } else {
            for (int i = 0; i < palindromeArray.length; ++i) {
                if (chars[i] == chars[i + 1]) {
                    palindromeArray[i] = i;
                    exist = true;
                } else {
                    // 该位置不存在长度为2的回文串
                    palindromeArray[i] = -1;
                }
            }
        }

        return exist;
    }

    private String findMaxPalindrome(String str, char[] chars, int[] palindromeIndexArray, int palindromeLen) {
        int curPalindromeLen = palindromeLen;
        int maxPalindromeIndex = findFirstPalindromeIndex(palindromeIndexArray);
        while (nextPalindromeArray(chars, palindromeIndexArray, curPalindromeLen)) {
            curPalindromeLen += 2;
            maxPalindromeIndex = findFirstPalindromeIndex(palindromeIndexArray);
        }

        return str.substring(maxPalindromeIndex, maxPalindromeIndex + curPalindromeLen);
    }

    private int findFirstPalindromeIndex(int[] palindromeIndexArray) {
        for (int index : palindromeIndexArray) {
            if (index >= 0) {
                return index;
            }
        }
        return 0;
    }

    private boolean nextPalindromeArray(char[] chars, int[] prePalindromeIndexArray, int palindromeLen) {
        int startIndex;
        boolean existNext = false;
        for (int i = 0; i < prePalindromeIndexArray.length; ++i) {
            startIndex = prePalindromeIndexArray[i];
            // -1表示无效索引，即不存在该回文串
            if (startIndex >= 0) {
                if (startIndex == 0 || startIndex == chars.length - palindromeLen) {
                    // 处于字串首尾的回文字串没办法在继续扩展
                    prePalindromeIndexArray[i] = -1;
                } else {
                    // 如果存在更长回文串，则替换数组当前位置处的回文串的起始索引，否则置为-1，表示在当前回文串基础上无法找到更长的回文串
                    if (chars[startIndex - 1] == chars[startIndex + palindromeLen]) {
                        existNext = true;
                        prePalindromeIndexArray[i] = startIndex - 1;
                    } else {
                        prePalindromeIndexArray[i] = -1;
                    }
                }
            }
        }

        return existNext;
    }
}
