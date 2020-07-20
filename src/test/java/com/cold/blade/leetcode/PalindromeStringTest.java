package com.cold.blade.leetcode;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/25
 * @version 1.0
 */
public class PalindromeStringTest extends BaseTest {

    @Test
    public void testGruff() {
        doTest(PalindromeString::doGruffly);
    }

    @Test
    public void testDynamic() {
        doTest(PalindromeString::doDynamic);
    }

    @Test
    public void testExpandAroundCenter() {
        doTest(PalindromeString::doExpandAroundCenter);
    }

    private void doTest(Function<String, String> algorithm) {
        String str = "babad";
        String result = algorithm.apply(str);
        Assert.assertTrue("bab".equals(result) || "aba".equals(result));
        str = "cbbd";
        Assert.assertEquals("bb", algorithm.apply(str));
    }
}
