package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @author cold_blade
 * @date 2019/7/22
 * @version 1.0
 */
public class NoRepeatCharSubStringTest extends BaseTest {

    @Test
    public void testLongestLength() {
        int length = NoRepeatCharSubString.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, length);
        length = NoRepeatCharSubString.lengthOfLongestSubstring("b");
        Assert.assertEquals(1, length);
        length = NoRepeatCharSubString.lengthOfLongestSubstring("aaaaaaa");
        Assert.assertEquals(1, length);
        length = NoRepeatCharSubString.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, length);
    }
}
