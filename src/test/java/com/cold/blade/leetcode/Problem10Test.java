package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题10 --- 字符串模式匹配
 * @author cold_blade
 * @date 2020/8/18
 * @version 1.0
 */
public class Problem10Test extends BaseTest {

    @Test
    public void test() {
        Problem10 tester = new Problem10();
        String str = "aaa";
        String pattern = "ab*a*c*a";
        Assert.assertTrue(tester.solution(str, pattern));
        str = "aa";
        pattern = "a*";
        Assert.assertTrue(tester.solution(str, pattern));
        str = "ab";
        pattern = ".*";
        Assert.assertTrue(tester.solution(str, pattern));
        str = "aab";
        pattern = "c*a*b";
        Assert.assertTrue(tester.solution(str, pattern));
        str = "mississippi";
        pattern = "mis*is*p*.";
        Assert.assertFalse(tester.solution(str, pattern));
    }
}
