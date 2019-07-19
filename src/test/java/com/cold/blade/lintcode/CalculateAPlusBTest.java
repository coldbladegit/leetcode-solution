package com.cold.blade.lintcode;

import org.junit.Assert;
import org.junit.Test;

import com.cold.blade.BaseTest;
import com.cold.blade.lintcode.CalculateAPlusB.ListNode;

/**
 * @author cold_blade
 * @date 2019/7/19
 * @version 1.0
 */
public class CalculateAPlusBTest extends BaseTest {

    @Test
    public void testAddTwoNumbers() {
        ListNode num = new ListNode(1);
        ListNode num2 = new ListNode(9);
        num2.next(8);
        ListNode result = CalculateAPlusB.addTwoNumbers(num2, num);
        Assert.assertEquals(0, result.getVal());
        Assert.assertEquals(9, result.next().getVal());

        num = new ListNode(5);
        num.next(9).next(9);
        result = CalculateAPlusB.addTwoNumbers(num, num);
        Assert.assertEquals(0, result.getVal());
        Assert.assertEquals(9, result.next().getVal());
        Assert.assertEquals(9, result.next().next().getVal());
        Assert.assertEquals(1, result.next().next().next().getVal());
    }
}
