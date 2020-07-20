package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @version 1.0
 */
public class StringMatcherTest extends BaseTest {

    @Test
    public void testMatch() {
        StringMatcher matcher = new StringMatcher();

        String str = "aaa";
        String pattern = "a*a";
        Assert.assertTrue(matcher.backTrackSolution(str, pattern));

        str = "aaa";
        pattern = "aaaa";
        Assert.assertFalse(matcher.backTrackSolution(str, pattern));

        str = "aa";
        pattern = "a*";
        Assert.assertTrue(matcher.backTrackSolution(str, pattern));

        str = "ab";
        pattern = ".*";
        Assert.assertTrue(matcher.backTrackSolution(str, pattern));

        str = "aab";
        pattern = "c*a*bb*";
        Assert.assertTrue(matcher.backTrackSolution(str, pattern));

        str = "aab";
        pattern = "c*a*b*";
        Assert.assertTrue(matcher.backTrackSolution(str, pattern));

        str = "aab";
        pattern = "c*a*bbb*";
        Assert.assertFalse(matcher.backTrackSolution(str, pattern));
    }
}
