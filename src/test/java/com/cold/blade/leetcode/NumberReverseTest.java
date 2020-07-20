package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public class NumberReverseTest extends BaseTest {

    @Test
    public void testReverse() {
        int value = -12345678;
        Assert.assertEquals(-87654321, NumberReverse.reverse(value));
        Assert.assertEquals(-87654321, NumberReverse.reverse2(value));
    }

    @Test
    public void testEfficient() {
        printCost(statisticEfficient(NumberReverse::reverse, Integer.MAX_VALUE), "ns");
        printCost(statisticEfficient(NumberReverse::reverse2, Integer.MAX_VALUE), "ns");
    }
}
