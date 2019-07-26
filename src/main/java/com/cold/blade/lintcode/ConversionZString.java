package com.cold.blade.lintcode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 之后，输出需要从左往右逐行读取，产生出一个新的字符串。
 *
 * 解题思路：
 * 解法一、依次遍历：
 *          从头开始遍历 s ，通过当前是向上还是向下的趋势来计算row的变化: goingDown ? row++ : row--
 *          时间复杂度 O(n) = s.length() + 2 * rows;
 *          空间复杂度 O(n) = s.length();
 *
 * 解法二、按行遍历：
 *          根据 Z 字形排列的特性，我们可以得出字符串的索引 i 与 每行中的字符在 S 之中的 step 为：
 *          1、每行首字符对应 S 中字符的索引为  row；
 *          2、当 row = 0 或 row = rows - 1 时，step = 2 * (rows - 1);
 *          3、当 row 处于 (0, rows - 1) 之间时，又分为以下两种情况：
 *               1>、row 中当前字符的下一个位置为空：step = 2 * (rows - 1 - row);
 *               2>、row 中当前字符的下一个位置为字符串中的字符：step = 2 * row;
 *             而上述两种情况是交替出现的。
 *          时间复杂度 O(n) = s.length();
 *          空间复杂度 O(n) = s.length();
 *
 * @author cold_blade
 * @date 2019/7/26
 * @version 1.0
 */
public final class ConversionZString {

    private ConversionZString() {
    }

    public static String iterateChar(String s, int rows) {
        String preResult = preDeal(s, rows);
        if (Objects.nonNull(preResult)) {
            return preResult;
        }
        List<StringBuilder> stringBuilders = IntStream.range(0, rows).
            mapToObj(i -> new StringBuilder()).collect(Collectors.toList());
        boolean goingDown = false;
        int row = 0;
        for (int i = 0; i < s.length(); ++i) {
            stringBuilders.get(row).append(s.charAt(i));
            if (0 == row || row == rows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }
        return stringBuilders.stream().reduce(StringBuilder::append).orElse(new StringBuilder()).toString();
    }

    public static String iterateRow(String s, int rows) {
        String preResult = preDeal(s, rows);
        if (Objects.nonNull(preResult)) {
            return preResult;
        }
        int length = s.length();
        StringBuilder result = new StringBuilder(length);
        for (int row = 0; row < rows; row++) {
            // 当前行的当前字符对应的下一个字符是否为null（在 Z 字形的排列中）
            boolean nextNull = true;
            for (int i = row; i < length; i += calculateStep(row, rows, !nextNull)) {
                result.append(s.charAt(i));
                nextNull = !nextNull;
            }
        }
        return result.toString();
    }

    private static int calculateStep(int row, int rows, boolean nextNull) {
        if (0 == row || row == rows - 1) {
            return 2 * (rows - 1);
        }
        return nextNull ? 2 * (rows - 1 - row) : 2 * row;
    }

    private static String preDeal(String s, int rows) {
        if (rows <= 0 || Objects.isNull(s)) {
            throw new IllegalArgumentException(String.format("illegal argument rows: %s, s: %s", rows, s));
        } else if (1 == rows) {
            return s;
        }
        return null;
    }
}
