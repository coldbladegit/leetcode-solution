package com.cold.blade.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 *   问题描述：
 *     将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串。
 *     链接：https://leetcode-cn.com/problems/zigzag-conversion/
 *
 *   思路：
 *     方案一：定义一个长度为rowNum的StringBuilder列表，假设列表首尾StringBuilder的capacity为 x，则 2x + 2x * (rowNum - 2) = str.length() + c
 *            （即中间部分StringBuilder的capacity为首尾StringBuilder的2倍）， x的粗略值为 x = str.length() / (2 * (rowNum - 1))
 *            长度不够时再自动扩展;依次遍历str，通过改变向上OR向下的标记来将str中的char放入正确的StringBuilder中，最后再将StringBuilder列表顺序组装成一个字符串
 *
 *     方案二：以 V 字型为一个循环, 循环周期为 cycleLen = (2 * rowNum - 2) （2倍行数 - 头尾2个）。
 *            L     D     R
 *            E   O E   I I
 *            E C   I H   N
 *            T     S     G
 *            此时str下标i、row、cycle三者之间有 int cycleIndex = i % cycleLen; row = cycleIndex < rowNum ? cycleIndex : cycleLen - cycleIndex;
 *
 * @author cold_blade
 * @date 2020/7/23
 * @version 1.0
 */
public class Problem6 {

    public String solutionOne(String str, int rowNum) {
        if (null == str || str.length() <= 2 || rowNum <= 1) {
            return str;
        }
        int strLen = str.length();
        List<StringBuilder> stringBuilders = buildStringBuilders(strLen, rowNum);
        boolean isDown = true;
        int j = 0;
        for (int i = 0; i < strLen; ++i) {
            if (isDown) {
                stringBuilders.get(j).append(str.charAt(i));
                if (j == rowNum - 1) {
                    j--;
                    isDown = false;
                } else {
                    j++;
                }
            } else {
                stringBuilders.get(j).append(str.charAt(i));
                if (0 == j) {
                    isDown = true;
                    j++;
                } else {
                    j--;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder(strLen);
        stringBuilders.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    public String solutionTwo(String str, int rowNum) {
        if (null == str || str.length() <= 2 || rowNum <= 1) {
            return str;
        }
        int strLen = str.length();
        List<StringBuilder> stringBuilders = buildStringBuilders(strLen, rowNum);
        // 以V型结构为一个遍历循环，其循环长度为2个整行减去2个头尾
        int cycleLen = 2 * rowNum - 2;
        int cycleIndex;
        for (int i = 0; i < strLen; ++i) {
            cycleIndex = i % cycleLen;
            stringBuilders.get(cycleIndex < rowNum ? cycleIndex : cycleLen - cycleIndex).append(str.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder(strLen);
        stringBuilders.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private List<StringBuilder> buildStringBuilders(int strLen, int rowNum) {
        int capacity = strLen / (2 * (rowNum - 1));
        int listSize = Math.min(rowNum, strLen);
        List<StringBuilder> stringBuilders = new ArrayList<>(listSize);
        stringBuilders.add(new StringBuilder(capacity));
        for (int i = 1; i < listSize - 1; ++i) {
            stringBuilders.add(new StringBuilder(2 * capacity));
        }
        stringBuilders.add(new StringBuilder(capacity));
        return stringBuilders;
    }
}
