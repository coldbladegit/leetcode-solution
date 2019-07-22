package com.cold.blade.lintcode;

/**
 * @author cold_blade
 * @date 2019/7/22
 * @version 1.0
 */
public final class NoRepeatCharSubString {

    private NoRepeatCharSubString() {
    }

    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        int maxLength = 0;
        int subLength;
        int index, j;
        for (int i = 0; i < chars.length; ++i) {
            index = -1;
            for (j = i + 1; j < chars.length; ++j) {
                index = indexOf(chars, i, j, j);
                if (index != -1) {
                    // 表示有重复的字符
                    break;
                }
            }
            subLength = j - i;
            if (subLength > maxLength) {
                maxLength = subLength;
            }
            if (index == -1) {
                // 表示已经遍历到字符串末尾[i, length - 1]的子串长度肯定大于[i + 1, length - 1]的长度，因此后面没必要再遍历了
                break;
            } else {
                // [0, index]的子串往后遍历都会遇到j处的重复字符
                i = index;
            }
        }
        return maxLength;
    }

    private static int indexOf(char[] chars, int from, int excludeTo, int index) {
        for (int i = from; i < excludeTo; ++i) {
            if (chars[i] == chars[index]) {
                return i;
            }
        }
        return -1;
    }
}
