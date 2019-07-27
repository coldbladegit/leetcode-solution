package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/27
 * @version 1.0
 */
public class StringToIntTest extends BaseTest {

    @Test
    public void testValueOf() {
        Assert.assertEquals(42, StringToInt.valueOf("42"));
        Assert.assertEquals(-42, StringToInt.valueOf("-42"));
        Assert.assertEquals(4193, StringToInt.valueOf("4193 with words"));
        Assert.assertEquals(0, StringToInt.valueOf("words and 987"));
        Assert.assertEquals(4193, StringToInt.valueOf("4193 with 1234"));
    }
}
