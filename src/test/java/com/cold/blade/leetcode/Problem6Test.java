package com.cold.blade.leetcode;

import java.util.function.BiFunction;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题6 --- 输出给定字符串z字形排列后的字串的单元测试
 *
 * @author cold_blade
 * @date 2020/7/23
 * @version 1.0
 */
public class Problem6Test extends BaseTest {

    @Test
    public void testOne() {
        Problem6 solution = new Problem6();
        test(solution::solutionOne);
    }

    @Test
    public void testTwo() {
        Problem6 solution = new Problem6();
        test(solution::solutionTwo);
    }

    private void test(BiFunction<String, Integer, String> func) {
        Assert.assertEquals("LCIRETOESIIGEDHN", func.apply("LEETCODEISHIRING", 3));
        Assert.assertEquals("LDREOEIIECIHNTSG", func.apply("LEETCODEISHIRING", 4));
    }
}
