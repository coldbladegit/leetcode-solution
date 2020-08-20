package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题11 --- 盛水最多容器单元测试
 *
 * @author cold_blade
 * @date 2020/8/20
 * @version 1.0
 */
public class Problem11Test extends BaseTest {

    @Test
    public void test() {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Problem11 solution = new Problem11();
        Assert.assertEquals(49, solution.solution(array));
    }
}
