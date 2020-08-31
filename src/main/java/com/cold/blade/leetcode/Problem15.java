package com.cold.blade.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 *      问题描述：
 *          给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *          请你找出所有满足条件且不重复的三元组。
 *          注意：答案中不可以包含重复的三元组。
 *      链接：https://leetcode-cn.com/problems/3sum

 * @author cold_blade
 * @date 2020/8/28
 * @version 1.0
 */
public class Problem15 {

    public List<List<Integer>> solution(int[] nums) {
        if (null == nums || nums.length < 3) {
            return Collections.emptyList();
        }
        // 将数组分为左侧部分 < 0，右侧部分 >= 0的两部分
        int keyIndex = divided(nums);
        // 数组中的元素全部 < 0
        if (keyIndex >= nums.length) {
            return Collections.emptyList();
        }
        List<Integer> zeros = find3Zeros(nums);
        // 数组中的元素全部 >= 0
        if (keyIndex < 0) {
            return zeros.size() < 3 ? Collections.emptyList() : Collections.singletonList(zeros);
        }

        return new ArrayList<>(process(nums, keyIndex, zeros).values());
    }

    private int divided(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int tmp;
        while (i < j) {
            while (j >= 0 && nums[j] >= 0) {
                j--;
            }
            while (i < nums.length && nums[i] < 0) {
                i++;
            }
            if (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        return j < 0 ? j : i;
    }

    private List<Integer> find3Zeros(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        for (int num : nums) {
            if (0 == num && zeros.size() < 3) {
                zeros.add(num);
            }
        }
        return zeros;
    }

    private Map<String, List<Integer>> process(int[] nums, int keyIndex, List<Integer> zeros) {
        // keyIndex 为第一个非负整数的索引
        if (nums[keyIndex] < 0) {
            keyIndex++;
        }
        Map<String, List<Integer>> map = new HashMap<>(capacity(nums.length, keyIndex));
        // 三个元素都为0的情况
        if (zeros.size() == 3) {
            map.put(hash(0, 0, 0), zeros);
        }
        // 两个负数一个非负整数的情况
        if (keyIndex >= 2) {
            Set<Integer> positives = new HashSet<>(nums.length - keyIndex + 1);
            for (int i = keyIndex; i < nums.length; i++) {
                positives.add(nums[i]);
            }
            process(nums, 0, keyIndex - 1, map, positives);
        }
        // 两个非负整数一个负数的情况
        if (keyIndex < nums.length - 1) {
            Set<Integer> negatives = new HashSet<>(keyIndex);
            for (int i = 0; i < keyIndex; i++) {
                negatives.add(nums[i]);
            }
            process(nums, keyIndex, nums.length - 1, map, negatives);
        }

        return map;
    }

    private int capacity(int len, int keyIndex) {
        int capacity = 1;
        if (keyIndex >= 2) {
            capacity += keyIndex * (keyIndex - 1) / 2 + 1;
        }
        if (keyIndex < len - 1) {
            capacity += (len - keyIndex) * (len - keyIndex - 1) / 2 + 1;
        }

        return capacity;
    }

    private void process(int[] nums, int start, int end, Map<String, List<Integer>> map, Set<Integer> tempSets) {
        int result;
        String hashCode;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                result = 0 - (nums[i] + nums[j]);
                if (tempSets.contains(result)) {
                    hashCode = hash(nums[i], nums[j], result);
                    if (!map.containsKey(hashCode)) {
                        List<Integer> items = new ArrayList<>(3);
                        items.add(nums[i]);
                        items.add(nums[j]);
                        items.add(result);
                        map.put(hashCode, items);
                    }
                }
            }
        }
    }

    private String hash(int obj1, int obj2, int obj3) {
        int tmp;
        if (obj1 > obj2) {
            tmp = obj1;
            obj1 = obj2;
            obj2 = tmp;
        }
        if (obj2 > obj3) {
            tmp = obj2;
            obj2 = obj3;
            obj3 = tmp;
        }
        return String.join(":", String.valueOf(obj1), String.valueOf(obj2), String.valueOf(obj3));
    }
}
