package com.cold.blade.leetcode;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题17 --- 电话号码字符组合单元测试
 *
 * @author cold_blade
 * @date 2020/9/25
 * @version 1.0
 */
public class Problem17Test extends BaseTest {

    @Test
    public void test() {
        String phone = "23";
        Problem17 solution = new Problem17();
        List<String> result = solution.solution(phone);
        Assert.assertEquals(9, result.size());
    }
}
