package com.cold.blade.leetcode;

import java.util.function.BiFunction;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/26
 * @version 1.0
 */
public class ConversionZStringTest extends BaseTest {

    @Test
    public void testIterateChar() {
        doTest(ConversionZString::iterateChar);
    }

    @Test
    public void testIterateRow() {
        doTest(ConversionZString::iterateRow);
    }

    private void doTest(BiFunction<String, Integer, String> function) {
        String str = "LEETCODEISHIRING";
        int rows = 3;
        Assert.assertEquals("LCIRETOESIIGEDHN", function.apply(str, rows));
        rows = 4;
        Assert.assertEquals("LDREOEIIECIHNTSG", function.apply(str, rows));
    }
}
