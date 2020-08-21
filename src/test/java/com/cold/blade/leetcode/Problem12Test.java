package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题12 --- 整数转罗马数字单元测试
 *
 * @author cold_blade
 * @date 2020/8/21
 * @version 1.0
 */
public class Problem12Test extends BaseTest {

    @Test
    public void test() {
        Problem12 solution = new Problem12();
        Assert.assertEquals("III", solution.solution(3));
        Assert.assertEquals("IV", solution.solution(4));
        Assert.assertEquals("IX", solution.solution(9));
        Assert.assertEquals("LVIII", solution.solution(58));
        Assert.assertEquals("MCMXCIV", solution.solution(1994));
    }
}
