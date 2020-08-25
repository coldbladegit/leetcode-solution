package com.cold.blade.leetcode;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题14 --- 最长前缀单元测试
 *
 * @author cold_blade
 * @date 2020/8/24
 * @version 1.0
 */
public class Problem14Test extends BaseTest {

    @Test
    public void test1() {
        Problem14 solution = new Problem14();
        doTest(solution::solution1);
    }

    @Test
    public void test2() {
        Problem14 solution = new Problem14();
        doTest(solution::solution2);
    }

    @Test
    public void test3() {
        Problem14 solution = new Problem14();
        doTest(solution::solution3);
    }

    private void doTest(Function<String[], String> func) {
        String[] strs1 = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", func.apply(strs1));
        String[] strs2 = {"dog", "racecar", "car"};
        Assert.assertEquals("", func.apply(strs2));
    }
}
