package com.cold.blade.lintcode;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/22
 * @version 1.0
 */
public class Problem3Test extends BaseTest {

    @Test
    public void testSolutionOne() {
        test(Problem3::solutionOne);
    }

    @Test
    public void testSolutionTwo() {
        test(Problem3::solutionTwo);
    }

    @Test
    public void testSolutionThree() {
        test(Problem3::solutionThree);
    }

    private void test(Function<String, Integer> solution) {
        int length = solution.apply("abcabcbb");
        Assert.assertEquals(3, length);
        length = solution.apply("b");
        Assert.assertEquals(1, length);
        length = solution.apply("aaaaaaa");
        Assert.assertEquals(1, length);
        length = solution.apply("pwwkew");
        Assert.assertEquals(3, length);
    }
}
