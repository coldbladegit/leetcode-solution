package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题8 --- 字符串转换成整数的单元测试
 *
 * @author cold_blade
 * @date 2020/7/27
 * @version 1.0
 */
public class Problem8Test extends BaseTest {

    @Test
    public void test() {
        Problem8 solution = new Problem8();
        Assert.assertEquals(42, solution.solution("42"));
        Assert.assertEquals(-42, solution.solution("-42"));
        Assert.assertEquals(4193, solution.solution("4193 with words"));
        Assert.assertEquals(0, solution.solution("words and 987"));
        Assert.assertEquals(-2147483648, solution.solution("-91283472332"));
        Assert.assertEquals(0, solution.solution("0-1"));
    }
}
