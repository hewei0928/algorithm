package com.hw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Hewei
 * @Description: leetcode刷题记录
 * @Date: Created in 17:08 2018/7/27
 */
public class leetcode {

    /**
     * 1. 两数之和
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 2. 两数相加
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1 数字1
     * @param l2 数字2
     * @return 和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, node = result;
        while (p != null || q != null) {
            int pVal = (p == null) ? 0 : p.val;
            int qVal = (q == null) ? 0 : q.val;
            int sum = pVal + qVal + carry;
            int val = sum % 10;
            carry = sum / 10;
            node.next = new ListNode(val);
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            node = node.next;
        }
        // 最高位进1
        if (carry > 0) {
            node.next = new ListNode(1);
        }
        return result.next;
    }


    


}
