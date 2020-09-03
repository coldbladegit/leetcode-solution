package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题16 --- 三数之和与target值最近的单元测试
 *
 * @author cold_blade
 * @date 2020/9/3
 * @version 1.0
 */
public class Problem16Test extends BaseTest {

    @Test
    public void test() {
        Problem16 solution = new Problem16();
        int[] nums = {-3, -2, -5, 3, -4};
        Assert.assertEquals(-2, solution.solution(nums, -1));
    }
}
