package com.cold.blade.leetcode;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题5---寻找最长回文串的单元测试
 *
 * @author cold_blade
 * @date 2020/7/23
 * @version 1.0
 */
public class Problem5Test extends BaseTest {

    @Test
    public void testOne() {
        Problem5 solution = new Problem5();
        test(solution::solutionOne);
    }

    @Test
    public void testTwo() {
        Problem5 solution = new Problem5();
        test(solution::solutionTwo);
    }

    private void test(Function<String, String> func) {
        Assert.assertEquals("bab", func.apply("babad"));
        Assert.assertEquals("bb", func.apply("cbbd"));
    }
}
