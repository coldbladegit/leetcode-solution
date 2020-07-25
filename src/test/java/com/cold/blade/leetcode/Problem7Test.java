package com.cold.blade.leetcode;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题7 --- 整数反转的单元测试
 *
 * @author cold_blade
 * @date 2020/7/25
 * @version 1.0
 */
public class Problem7Test extends BaseTest {

    @Test
    public void testOne() {
        Problem7 solution = new Problem7();
        test(solution::solutionOne);
    }

    private void test(Function<Integer, Integer> func) {
        Assert.assertEquals(321, func.apply(123).intValue());
        Assert.assertEquals(-321, func.apply(-123).intValue());
        Assert.assertEquals(0, func.apply(1534236469).intValue());
    }
}
