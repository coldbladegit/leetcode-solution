package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;

/**
 * @Description 试题一的单元测试
 *
 * @author cold_blade
 * @date 2020/7/15
 * @version 1.0
 */
public class Problem1Test extends BaseTest {

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        Problem1 problem = new Problem1();
        int[] indexArray = problem.solution(numbers, 9);
        int minIndex = Math.min(indexArray[0], indexArray[1]);
        int maxIndex = Math.max(indexArray[0], indexArray[1]);
        Assert.assertTrue(0 == minIndex);
        Assert.assertTrue(1 == maxIndex);

        indexArray = problem.solution(numbers, 8);
        Assert.assertTrue(indexArray.length == 0);
    }
}
