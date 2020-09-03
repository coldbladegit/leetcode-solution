package com.cold.blade.leetcode;

/**
 * @Description
 *      问题描述：
 *          给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 *          找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *          返回这三个数的和。假定每组输入只存在唯一答案。
 *          Notice:
 *              3 <= nums.length <= 10^3
 *              -10^3 <= nums[i] <= 10^3
 *              -10^4 <= target <= 10^4
 *      链接：https://leetcode-cn.com/problems/3sum-closest
 *
 *      思路：排序加双指针，针对本题对数组规模和数值范围均较小的情形，非常适合计数排序
 *      （正数和负数分别单独一个队列，然后合并）
 *
 * @author cold_blade
 * @date 2020/9/1
 * @version 1.0
 */
public class Problem16 {

    public int solution(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        // 将数组进行升序排序
        sort(nums);
        int bestVal = Integer.MAX_VALUE;
        for (int pa = 0; pa < nums.length - 2; pa++) {
            // 由于是升序排序，因此若当前索引与前一个索引处的值相等，则跳过本次遍历
            if (pa > 0 && nums[pa] == nums[pa - 1]) {
                continue;
            }
            // 双指针
            int pb = pa + 1;
            int pc = nums.length - 1;
            do {
                int sum = nums[pa] + nums[pb] + nums[pc];
                if (target == sum) {
                    return target;
                } else if (sum < target) {
                    pb++;
                } else {
                    pc--;
                }
                if (bestVal == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(bestVal - target)) {
                    bestVal = sum;
                }
            } while (pb < pc);
        }
        return bestVal;
    }

    private void sort(int[] nums) {
        int[] positives = new int[1001];
        int[] negatives = new int[1001];
        for (int num : nums) {
            if (num < 0) {
                negatives[-num]++;
            } else {
                positives[num]++;
            }
        }
        int index = 0;
        for (int i = 1000; i > 0; i--) {
            while (negatives[i]-- > 0) {
                nums[index++] = -i;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (positives[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}
