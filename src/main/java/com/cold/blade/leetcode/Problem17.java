package com.cold.blade.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 *      问题描述：
 *          给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *          给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *      思路：
 *          构造一颗完全多叉树，然后遍历所有到达叶节点的路径。
 * @author cold_blade
 * @date 2020/9/25
 * @version 1.0
 */
public class Problem17 {

    public List<String> solution(String digits) {
        if (null == digits || digits.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Character, String> map = init();
        List<String> result = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        backtrack(result, digits, map, 0, combination);
        return result;
    }

    private Map<Character, String> init() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mon");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }

    private void backtrack(List<String> result, String digits, Map<Character, String> map, int index, StringBuilder combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            for (int i = 0, len = letters.length(); i < len; i++) {
                combination.append(letters.charAt(i));
                backtrack(result, digits, map, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
