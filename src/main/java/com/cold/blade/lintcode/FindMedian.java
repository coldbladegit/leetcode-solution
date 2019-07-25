package com.cold.blade.lintcode;

/**
 * 我们假设两个有序数组都是升序。
 * 查找两个有序数组的中位数:
 * 中位数： 将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
 *
 * 解题思路：我们把数组A（长度为m）从i处分为左右两部分，left_A[0, i - 1]、right_A[i, m - 1]，注：当i == 0或i == m时
 * left_A或right_A为空集，同理，我们把数组B（长度为n）从j处分为左右两部分，left_B[0, j]、right_B[j, n - 1]，
 * 把A和B的左半部分与右半部分合并，在根据中位数的性质：
 * 1、i + j = m - i + n - j 或 i + j = m - i + n - j + 1（m + n为奇数）；
 * 2、left_A[i - 1] <= right_B[j] && left_B[j - 1] <= right_A[i];
 *
 * 因此有：
 * i 取值 [0, m) 由性质1 => j = (m + n) / 2 - i 或 j = (m + n + 1) / 2 - i（这里需确保m <= n，否则j可能为负数）
 * 由于两个数组都是有序数组（我们假设都是升序），因此在通过性质2筛选合适的i和j时，可以通过二分的查找的方式加快查找速率。
 *
 * 中位数的计算：
 * maxLeftPart = Math.max(left_A[i - 1], left_B[j - 1]);
 * minRightPart = Math.min(right_A[i], right_B[j]);
 * median = (maxLeftPart + minRightPart) / 2
 * 当 m + n 为奇数时，maxLeftPart = 0;（右边部分多出的那个作为中位数）
 *
 * @author cold_blade
 * @date 2019/7/24
 * @version 1.0
 */
public final class FindMedian {

    private FindMedian() {
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 优先处理有一个数组为空的情况
        if (null == nums1) {
            return doFindMedianSortedArray(nums2);
        } else if (null == nums2) {
            return doFindMedianSortedArray(nums1);
        }
        // 两个数组皆不为空
        if (nums1.length > nums2.length) {
            return doFindMedianSortedArrays(nums2, nums1);
        } else {
            return doFindMedianSortedArrays(nums1, nums2);
        }
    }

    private static double doFindMedianSortedArray(int[] nums) {
        int length = nums.length;
        int middle = length / 2;
        if (length % 2 == 0) {
            return (nums[middle - 1] + nums[middle]) / 2.0;
        }
        return nums[middle];
    }

    private static double doFindMedianSortedArrays(int[] shortNums, int[] longNums) {
        int start = 0;
        int end = shortNums.length;// 当i == m时，右边集合是空集
        int totalLength = shortNums.length + longNums.length;
        int half = (totalLength % 2 == 1) ? (totalLength + 1) / 2 : totalLength / 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            int index = half - mid;
            if (mid > start && shortNums[mid - 1] > longNums[index]) {
                end = mid - 1;
            } else if (mid < end && longNums[index - 1] > shortNums[mid]) {
                start = mid + 1;
            } else {
                return calculate(mid, index, shortNums, longNums);
            }
        }
        return 0.0;
    }

    private static double calculate(int mid, int index, int[] shortNums, int[] longNums) {
        int maxLeft;
        if (0 == mid) {
            maxLeft = longNums[index - 1];
        } else if (0 == index) {
            maxLeft = shortNums[mid - 1];
        } else {
            maxLeft = Math.max(shortNums[mid - 1], longNums[index - 1]);
        }
        if ((shortNums.length + longNums.length) % 2 == 1) {
            return maxLeft;
        }

        int minRight;
        if (mid == shortNums.length) {
            minRight = longNums[index];
        } else if (index == longNums.length) {
            minRight = shortNums[mid];
        } else {
            minRight = Math.min(shortNums[mid], longNums[index]);
        }
        return (maxLeft + minRight) / 2.0;
    }
}
