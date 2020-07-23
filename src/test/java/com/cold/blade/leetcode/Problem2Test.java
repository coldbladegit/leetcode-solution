package com.cold.blade.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;
import com.cold.blade.leetcode.Problem2.ListNode;

/**
 * @Description 试题2 --- 两个非负整数链表求和的单元测试
 *
 * @author cold_blade
 * @date 2019/7/19
 * @version 1.0
 */
public class Problem2Test extends BaseTest {

    @Test
    public void testAddTwoNumbers() {
        Problem2 problem2 = new Problem2();
        ListNode num = new ListNode(1);
        ListNode num2 = new ListNode(9);
        num2.next(8);
        ListNode result = problem2.addTwoNumbers(num2, num);
        Assert.assertEquals(0, result.getVal());
        Assert.assertEquals(9, result.next().getVal());

        num = new ListNode(5);
        num.next(9).next(9);
        result = problem2.addTwoNumbers(num2, num);
        Assert.assertEquals(4, result.getVal());
        Assert.assertEquals(8, result.next().getVal());
        Assert.assertEquals(0, result.next().next().getVal());
        Assert.assertEquals(1, result.next().next().next().getVal());
    }
}
