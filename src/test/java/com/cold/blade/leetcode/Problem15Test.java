package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题15 --- 寻找三数之和为0的单元测试
 *
 * @author cold_blade
 * @date 2020/8/31
 * @version 1.0
 */
public class Problem15Test extends BaseTest {

    @Test
    public void test() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Problem15 solution = new Problem15();
        Assert.assertEquals(2, solution.solution(array).size());
        int[] another = {-1, 0, 1, 0};
        Assert.assertEquals(1, solution.solution(another).size());
    }
}
