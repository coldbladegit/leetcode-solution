package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题13 --- 罗马数字转整数单元测试
 *
 * @author cold_blade
 * @date 2020/8/22
 * @version 1.0
 */
public class Problem13Test extends BaseTest {

    @Test
    public void test() {
        Problem13 solution = new Problem13();
        Assert.assertEquals(3 , solution.solution("III"));
        Assert.assertEquals(4 , solution.solution("IV"));
        Assert.assertEquals(9 , solution.solution("IX"));
        Assert.assertEquals(58 , solution.solution("LVIII"));
        Assert.assertEquals(1994 , solution.solution("MCMXCIV"));
    }
}
