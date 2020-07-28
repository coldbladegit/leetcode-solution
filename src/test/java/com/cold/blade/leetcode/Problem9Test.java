package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题9 -- 回文整数的单元测试
 *
 * @author cold_blade
 * @date 2020/7/28
 * @version 1.0
 */
public class Problem9Test extends BaseTest {

    @Test
    public void test() {
        Problem9 solution = new Problem9();
        Assert.assertTrue(solution.solution(121));
        Assert.assertFalse(solution.solution(-121));
    }
}
