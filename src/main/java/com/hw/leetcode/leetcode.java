package com.hw.leetcode;

import java.util.*;

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


    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0), node = listNode;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                if (l1 == null) {
                    ListNode n = new ListNode(l2.val);
                    node.next = n;
                    node = n;
                    l2 = l2.next;
                } else if (l2 == null){
                    ListNode n = new ListNode(l1.val);
                    node.next = n;
                    node = n;
                    l1 = l1.next;
                }
                continue;
            }

            if (l1.val >= l2.val) {
                ListNode n = new ListNode(l2.val);
                node.next = n;
                node = n;
                l2 = l2.next;
            } else {
                ListNode n = new ListNode(l1.val);
                node.next = n;
                node = n;
                l1 = l1.next;
            }
        }
        return listNode.next;
    }


    /** 不改变原链表
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * @param head 传入的链表
     * @return 序链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0), node = listNode;
        while (head != null) {
            boolean contain = false;
            ListNode n = listNode.next;
            while (n != null) {
                if (n.val == head.val) {
                    contain = true;
                    break;
                }
                n = n.next;
            }

            if (contain) {
                head = head.next;
                continue;
            } else {
                ListNode val = new ListNode(head.val);
                node.next = val;
                node = val;
            }
        }
        return listNode.next;
    }

    /** 改变原链表
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * @param head 传入的链表
     * @return 序链表
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                // 连续3个或三个以上重复时会出现bug
                //head = head.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }


    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。(尾节点不一定指向首节点中间的环也可)
     * @param head 给定链表
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
                head = head.next;
            }
        }
        return false;
    }


    /**
     * 不使用额外空间 双指针的使用
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。(尾节点不一定指向首节点中间的环也可)
     * @param head 给定链表
     * @return 是否有环
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        // 仔细思考，不会发生无线循环的情况
        while (slow != null && fast != null) {
            if (fast.next == null) {
                return false;
            }
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    /**
     * 160. 相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * @param headA 链表a
     * @param headB 链表b
     * @return 相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    /** 对问题进行抽象 空间复杂度为O(1)
     * 160. 相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * @param headA 链表a
     * @param headB 链表b
     * @return 相交节点
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        //标识是否已经更换了链表
        int a1 = 0, b1 = 0;
        while (a != null && b != null) {
            if (a == b) {
                return a;
            } else {
                a = a.next;
                b = b.next;
                if (a1 == 0 && a == null) {
                    a = headB;
                    a1 += 1;
                }
                if (b1 == 0 && b == null) {
                    b = headA;
                    b1 += 1;
                }
            }
        }
        return null;
    }

    /**
     * 203. 删除链表中的节点
     * 删除链表中等于给定值 val 的所有节点。
     * @param head 给定链表
     * @param val 要删除的值
     * @return 删除后的链表
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head !=null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode nodeOne = head.next;
        ListNode nodeTwo = head;
        while (nodeOne != null) {
            if (nodeOne.val == val) {
                nodeOne = nodeOne.next;
                if (nodeOne == null) {
                    nodeTwo.next = null;
                    break;
                }
                nodeTwo.next = nodeTwo.next.next;
            } else {
                nodeTwo = nodeTwo.next;
                nodeOne = nodeOne.next;
            }
        }
        return head;
    }


    /**
     * 206. 反转链表
     * 反转一个单链表。
     * @param head 链表
     * @return 反转后链表
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode nodeOne = head;
        while (nodeOne != null) {
            vals.add(nodeOne.val);
            nodeOne = nodeOne.next;
        }

        int i = vals.size() - 1;
        ListNode nodeTwo = head;
        while (nodeTwo != null) {
            nodeTwo.val = vals.get(i);
            nodeTwo = nodeTwo.next;
            i--;
        }
        return head;
    }


    /**
     * 不创建额外空间
     * 206. 反转链表
     * 反转一个单链表。
     * @param head 链表
     * @return 反转后链表
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 存储正序链表
            ListNode nextTemp = curr.next;
            //链表逆序
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 偶数个节点时
        if (fast != null) {
            slow = slow.next;
        }
        // 反转半个链表
        slow = reverseList1(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    /**
     * 237. 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 (末尾节点不删除)
     * 不要从你的函数中返回任何结果。
     * @param node 要删除的节点
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 707. 设计链表
     */
    public class MyLinkedList {

        ListNode head;
        ListNode tail;
        int size;

        class ListNode {
            int val;
            ListNode next;
            ListNode pre;
            ListNode(int x) { val = x; }
        }

        /** Initialize your data structure here. */
        public MyLinkedList() {
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            ListNode n = head;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return n.val;
                }
                n = n.next;
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                tail = node;
                head = node;
            } else {
                head.pre = node;
                node.next = head;
                head = node;
            }
            size ++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
            size ++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            ListNode n = head;
            if (size == 0) {
                if (index == 1 || index == 0) {
                    ListNode node = new ListNode(val);
                    head = node;
                    tail = node;
                }
                return;
            }
            for(int i = 0; i <= size; i++) {
                if (index == i) {
                    ListNode node = new ListNode(val);
                    if (index == 0) {
                        head.pre = node;
                        node.next = head;
                        head = node;
                        return;
                    }
                    if (index == size) {
                        tail.next = node;
                        node.pre = tail;
                        tail = node;
                        return;
                    }

                    ListNode pre = n.pre;
                    if (pre != null) {
                        pre.next = node;
                    }
                    node.pre = pre;
                    node.next = n;
                    n.pre = node;
                    return;
                }
                n = n.next;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            ListNode n = head;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    if (index == 0) {
                        ListNode node = head.next;
                        node.pre = null;
                        head = node;
                    } else if (index == size - 1) {
                        ListNode node = tail.pre;
                        node.next = null;
                        tail = node;
                    } else {
                        ListNode pre = n.pre;
                        pre.next = n.next;
                        n.next.pre = pre;
                    }
                    size--;
                }
            }
        }
    }

    


}
