package com.cold.blade.leetcode;

/**
 * @Description
 *   问题描述：
 *     给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *     说明：你不能倾斜容器，且 n 的值至少为 2。
 *     链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 *   思路：双指针：
 *      在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 min(a[i], a[j]) * (j - i + 1)。
 *      此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针。
 *      这是因为，由于容纳的水量是由两个指针指向的数字中较小值∗指针之间的距离决定的
 *
 * @author cold_blade
 * @date 2020/8/20
 * @version 1.0
 */
public class Problem11 {

    public int solution(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        int maxArea = 0;
        do {
            if (array[i] < array[j]) {
                maxArea = Math.max(maxArea, array[i] * (j - i));
                i++;
            } else {
                maxArea = Math.max(maxArea, array[j] * (j - i));
                j--;
            }
        } while (i < j);

        return maxArea;
    }
}
