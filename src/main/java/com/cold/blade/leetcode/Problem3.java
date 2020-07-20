package com.cold.blade.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 *   问题描述：
 *     给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 *   思路：
 *     方案一：类比选择排序思路，区别在于选择排序每一趟只比较索引i以后的元素，此处需要递归的比较[i, j - 1]之间的元素
 *            时间复杂度O(n) = n ^ 3，空间复杂度为T(1)
 *     方案二：对方案一的一个小优化，利用hash算法将比较[i, j - 1]之间的元素步骤简化为直接比较Set集合中是否包含char[j],
 *            时间复杂度为O(n) = n ^ 2，空间复杂度为T(n) = 常量值95
 *     方案三：对方案二的进一步优化，字符ASCII编码总共只有128个，因此可以定义一个长度为128的int数组，
 *            字符的ASCII码值与数组的索引一一对应，每次映射，值自增
 *
 * @author cold_blade
 * @date 2019/7/22
 * @version 1.0
 */
public final class Problem3 {

    private Problem3() {
    }

    public static int solutionOne(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int maxLength = 1;
        for (int i = 0; i < chars.length - 1; ++i) {
            int j = i;
            boolean repeat = false;
            do {
                j++;
                for (int k = i; k < j; k++) {
                    if (chars[k] == chars[j]) {
                        repeat = true;
                        break;
                    }
                }
            } while (!repeat && j < chars.length - 1);
            int subLength = repeat ? j - i : j - i + 1;
            maxLength = Math.max(subLength, maxLength);
        }
        return maxLength;
    }

    public static int solutionTwo(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int maxLength = 1;
        // ASCII可见字符只有95个
        Set<Character> characters = new HashSet<>(95);
        for (int i = 0; i < chars.length - 1; ++i) {
            characters.clear();
            characters.add(chars[i]);
            boolean repeat = false;
            int j = i;
            do {
                j++;
                if (characters.contains(chars[j])) {
                    repeat = true;
                    break;
                }
                characters.add(chars[j]);
            } while (j < chars.length - 1);
            int subLength = repeat ? j - i : j - i + 1;
            maxLength = Math.max(subLength, maxLength);
        }
        return maxLength;
    }

    public static int solutionThree(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int maxLength = 1;
        int[] arrayASCII = new int[128];
        int base = 0;
        for (int i = 0; i < chars.length - 1; ++i) {
            boolean repeat = false;
            int j = i;
            // 模拟方案二中的set.clear()
            base++;
            arrayASCII[chars[i]] += 1;
            do {
                j++;
                if (arrayASCII[chars[j]] == base) {
                    repeat = true;
                    break;
                }
                arrayASCII[chars[j]] += 1;
            } while (j < chars.length - 1);
            int subLength = repeat ? j - i : j - i + 1;
            maxLength = Math.max(subLength, maxLength);
        }
        return maxLength;
    }
}
