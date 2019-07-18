package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public class RomanToIntTest extends BaseTest {

    @Test
    public void testRomanToInt() {
        Assert.assertEquals(500, RomanToInt.romanToInt("D"));
        Assert.assertEquals(1994, RomanToInt.romanToInt("MCMXCIV"));
    }
}
