package com.cold.blade.leetcode;

/**
 * @Description
 * 问题描述：
 *   给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *   请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *   你可以假设 nums1 和 nums2 不会同时为空。
 *   链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * 思路：
 *   假设中位数的索引为k，排除数组为空的情况，则中位数的索引将
 *   数组a分割成a[0, i)和a[i, m - 1]两部分，
 *   数组b分割成b[0, j)和b[j, n - 1]两部分
 *   且 i + j = k; a[i] >= b[j - 1] && a[i] <= b[j]，注意当i = 0 或 j = 0的特殊情况
 *   那么问题就转化为在数组b中寻找j，而题目中对时间复杂度要求为O(n) = log(m + n)，
 *   因此二分查找是必选方案。
 *
 * @author cold_blade
 * @date 2020/7/20
 * @version 1.0
 */
public class Problem4 {

    public double solution(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length == 0) {
            return findMedian(nums2);
        } else if (null == nums2 || nums2.length == 0) {
            return findMedian(nums1);
        }
        if (nums1.length > nums2.length) {
            return findMedian(nums1, nums2);
        }
        return findMedian(nums2, nums1);
    }

    private double findMedian(int[] nums) {
        int middle = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[middle - 1] + nums[middle]) / 2.0;
        }

        return nums[middle];
    }

    private double findMedian(int[] longArray, int[] shortArray) {
        int totalLen = longArray.length + shortArray.length;
        int middle = totalLen / 2;
        // 查找短数组中的将数组分成两部分的index
        int shortIndex = findShortIndex(longArray, shortArray, middle);
        int longIndex = Math.min(middle - shortIndex, longArray.length - 1);
        if (0 == shortIndex) {
            // 表示短数组左半部分为空
            if (shortArray.length == longArray.length) {
                // 两个数组长度相等的情况
                return (longArray[longIndex] + shortArray[shortIndex]) / 2.0;
            } else {
                // 长度不等，则看两个数组长度之和的奇偶性
                return (totalLen % 2 == 0) ? (longArray[longIndex - 1] + Math.min(longArray[longIndex], shortArray[shortIndex])) / 2.0
                    : Math.min(shortArray[shortIndex], longArray[longIndex]);
            }
        } else if (shortIndex == shortArray.length) {
            // 表示短数组右半部分为空
            shortIndex = shortArray.length - 1;
            if (shortArray.length == longArray.length) {
                // 两个数组长度相等的情况
                return (longArray[longIndex] + shortArray[shortIndex]) / 2.0;
            } else {
                // 长度不等，则看两个数组长度之和的奇偶性
                return (totalLen % 2 == 0) ? (longArray[longIndex] + Math.max(longArray[longIndex - 1], shortArray[shortIndex])) / 2.0
                    : longArray[longIndex];
            }
        } else {
            // 在正常划分的情况下，当两个数组之和为偶数时，需要左右两部分的数组各出一个数
            return (totalLen % 2 == 0) ?
                (Math.max(shortArray[shortIndex - 1], longArray[longIndex - 1]) + Math.min(shortArray[shortIndex], longArray[longIndex])) / 2.0
                : Math.min(shortArray[shortIndex], longArray[longIndex]);
        }
    }

    private int findShortIndex(int[] longArray, int[] shortArray, int middle) {
        // 这里选取短数组做查找是为了避免j出现负数，且i能遍历到短数组中的每一个数
        int start = 0;
        int end = shortArray.length;
        int i;
        do {
            i = (start + end) / 2;
            int j = middle - i;
            if (i > start && shortArray[i - 1] > longArray[j]) {
                end = i - 1;
            } else if (i < end && shortArray[i] < longArray[j - 1]) {
                start = i + 1;
            } else {
                break;
            }
        } while (start <= end);

        return i;
    }
}
