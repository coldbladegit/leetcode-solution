package com.cold.blade.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 问题描述:
 *   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *   你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *   链接：https://leetcode-cn.com/problems/two-sum
 *
 * 思路:
 *   方案一：直接选择排序的思路，时间复杂度为 O(n) = n^2；
 *   方案二：反向思考，题目中是找出两个数之和为target的，考虑若用target减去数组中的一个数，结果为result，
 *          那我们只需找到数组中另一个等于result的数的索引即可，而要快速找到这个数，hash算法目前应该算比较快速的
 *          算法，其时间复杂度为O(1),不过需要额外的空间O(n)；
 *
 * @author cold_blade
 * @date 2020/7/15
 * @version 1.0
 */
public class Problem1 {

    public int[] solution(int[] iArray, int target) {
        // 以数组中的值为key，数组中值所对应的索引为value
        Map<Integer, Integer> indexMap = new HashMap<>(iArray.length);
        int result;
        int index;
        for (int i = 0; i < iArray.length; ++i) {
            result = target - iArray[i];
            if (indexMap.containsKey(result)) {
                index = indexMap.get(result);
                // 不能重复使用数组中的同一个数
                if (index != i) {
                    return new int[]{i, index};
                }
            }
            indexMap.put(iArray[i], i);
        }

        return new int[]{};
    }
}
