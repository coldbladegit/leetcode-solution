package com.cold.blade.lintcode;

/**
 * @version 1.0
 * @date 2018/9/19
 */
public final class CalculateAPlusB {

    private CalculateAPlusB() {

    }

    public static long solution(long a, long b) {
        long result;
        long forward;
        do {
            result = a ^ b;
            forward = (a & b) << 1;
            a = result;
            b = forward;
        } while (forward != 0);
        return result;
    }


    public static ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNodeWrapper wrapper = add(num1, num2.val, 0);
        ListNode head = wrapper.node;
        ListNode cur = head;
        num1 = num1.next;
        num2 = num2.next;
        while (num1 != null && num2 != null) {
            wrapper = add(num1, num2.val, wrapper.overflow);
            cur.next = wrapper.node;
            cur = cur.next;
            num1 = num1.next;
            num2 = num2.next;
        }
        if (num1 != null) {
            wrapper = append(cur, num1, wrapper.overflow);
            cur = wrapper.node;
        } else if (num2 != null) {
            wrapper = append(cur, num2, wrapper.overflow);
            cur = wrapper.node;
        }
        // 遍历完两个列表及计算后仍有进位
        if (wrapper.overflow > 0) {
            cur.next = new ListNode(wrapper.overflow);
        }

        return head;
    }

    private static ListNodeWrapper append(ListNode source, ListNode target, int overflow) {
        do {
            if (target.val == 9 && 1 == overflow) {
                target.val = 0;// 重用之前的节点，并修正其值
                overflow = 1;
            } else {
                target.val = target.val + overflow;
                overflow = 0;
            }
            source.next = target;
            source = source.next;
        } while ((target = target.next) != null);
        // 遍历完target链表后，返回计算后是否有进位的情况如[9,9,9...]
        return new ListNodeWrapper(source, overflow);
    }

    private static ListNodeWrapper add(ListNode node1, int value, int overflow) {
        value = node1.val + value + overflow;
        if (value > 9) {
            return new ListNodeWrapper(new ListNode(value - 10), 1);
        } else {
            return new ListNodeWrapper(new ListNode(value), 0);
        }
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

    private static class ListNodeWrapper {

        private ListNode node;
        private int overflow;

        private ListNodeWrapper(ListNode node, int overflow) {
            this.node = node;
            this.overflow = overflow;
        }
    }
}
