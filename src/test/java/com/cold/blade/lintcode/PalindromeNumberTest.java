package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
public class PalindromeNumberTest extends BaseTest {

    @Test
    public void testCheckPalindrome() {
        int value = 121;
        Assert.assertTrue(PalindromeNumber.isPalindromeNumber(value));
        Assert.assertTrue(PalindromeNumber.isPalindromeNumber2(value));
        value = -121;
        Assert.assertFalse(PalindromeNumber.isPalindromeNumber(value));
        Assert.assertFalse(PalindromeNumber.isPalindromeNumber2(value));
        value = Integer.MAX_VALUE;
        Assert.assertFalse(PalindromeNumber.isPalindromeNumber(value));
        Assert.assertFalse(PalindromeNumber.isPalindromeNumber2(value));
    }
}
