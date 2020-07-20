package com.cold.blade.leetcode;

import java.util.Objects;

/**
 * @Description
 *   问题描述：
 *     给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 *     并且它们的每个节点只能存储一位数字如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *     链接：https://leetcode-cn.com/problems/add-two-numbers/
 *
 *   思路：
 *     基于链表只能从头到尾遍历的特性，且存储的真实数字的低位在列表前，因此只需遍历列表，但需注意以下几种情况：
 *       1、单个链表为空的情况，此时直接返回另一个链表；
 *       2、两个链表长度不一致，则长列表中多余的节点直接赋值到新列表，不要忘记前面的进位；
 *       3、特别注意链表末尾，eg:[1, 2, 3] [9, 9, 9, 9]，进位千万不要遗漏
 *       4、虽然链表末尾的节点值为0不影响实际值，但是最好去掉；
 *
 * @author cold_blade
 * @version 1.0
 * @date 2018/9/19
 */
public final class Problem2 {

    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        // 存在空链表，直接返回另外一个链表
        if (Objects.isNull(num1)) {
            return num2;
        } else if (Objects.isNull(num2)) {
            return num1;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        ListNode pre;
        int carry = 0;
        do {
            carry = addTwoNum(num1.val, num2.val, carry, cur);
            num1 = num1.next;
            num2 = num2.next;
            pre = cur;
            cur = cur.next;
        } while (Objects.nonNull(num1) && Objects.nonNull(num2));

        while (Objects.nonNull(num1)) {
            carry = addTwoNum(num1.val, carry, 0, cur);
            num1 = num1.next;
            pre = cur;
            cur = cur.next;
        }
        while (Objects.nonNull(num2)) {
            carry = addTwoNum(num2.val, carry, 0, cur);
            num2 = num2.next;
            pre = cur;
            cur = cur.next;
        }

        if (cur.val == 0) {
            // 处理掉多余的无效节点
            pre.next = null;
        }

        return result;
    }

    private int addTwoNum(int num1, int num2, int carry, ListNode result) {
        int sum = num1 + num2 + carry;
        if (sum >= 10) {
            carry = 1;
            result.val = sum - 10;
        } else {
            carry = 0;
            result.val = sum;
        }
        // 将进位赋值给next节点，是为了防止链表遍历结束时，遗漏了进位
        result.next = new ListNode(carry);
        return carry;
    }

    public static class ListNode {

        private int val;
        private ListNode next;

        ListNode(int value) {
            this.val = value;
        }

        public int getVal() {
            return this.val;
        }

        public ListNode next() {
            return this.next;
        }

        public ListNode next(int val) {
            this.next = new ListNode(val);
            return this.next;
        }
    }
}
