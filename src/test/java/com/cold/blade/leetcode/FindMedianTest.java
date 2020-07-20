package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/24
 * @version 1.0
 */
public class FindMedianTest extends BaseTest {

    @Test
    public void testFindMedian() {
        int[] num1 = {1};
        int[] num2 = {1};
        double median = FindMedian.findMedianSortedArrays(num1, num2);
        Assert.assertEquals(1.0, median, 0.001);

        int[] num3 = {1, 2};
        int[] num4 = {3, 4};
        median = FindMedian.findMedianSortedArrays(num3, num4);
        Assert.assertEquals(2.5, median, 0.001);

        int[] num5 = {1, 3};
        int[] num6 = {2};
        median = FindMedian.findMedianSortedArrays(num5, num6);
        Assert.assertEquals(2.0, median,0.001);

        int[] num7 = {7, 8};
        int[] num8 = {1, 2, 3, 4};
        median = FindMedian.findMedianSortedArrays(num7, num8);
        Assert.assertEquals(3.5, median, 0.001);
    }
}
