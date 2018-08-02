package com.hw.leetcode;

import java.math.BigDecimal;
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

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 2. 两数相加
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
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
     *
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
                } else if (l2 == null) {
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


    /**
     * 27. 移除元素
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  要移除的值
     * @return 新数组长度
     */
    public int removeElement(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[num];
                nums[num] = nums[i];
                nums[i] = temp;
                num++;
            }
        }

        return num;
    }


    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 输入值
     * @return 平方根的整数部分
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return 0;
        }
        BigDecimal min = new BigDecimal(1), max = new BigDecimal(x);
        BigDecimal xB = new BigDecimal(x);
        while (min.compareTo(max) == 0 || min.compareTo(max) == -1) {
            BigDecimal mid = min.add(max).divide(new BigDecimal(2));
            BigDecimal s = mid.multiply(mid);
            if (s.compareTo(xB) == 0) {
                return mid.intValue();
            } else if (s.compareTo(xB) < 0) {
                s = mid.add(new BigDecimal(1)).multiply(mid.add(new BigDecimal(1)));
                if (s.compareTo(xB) > 0) {
                    return mid.add(new BigDecimal(1)).intValue();
                } else if (s.compareTo(xB) > 0) {
                    return mid.intValue();
                } else {
                    min = mid.add(new BigDecimal(1));
                }
            } else {
                s = ((mid.subtract(new BigDecimal(1)).multiply(mid.subtract(new BigDecimal(1)))));
                if (s.compareTo(xB) < 0 || s.compareTo(xB) == 0) {
                    return mid.subtract(new BigDecimal(1)).intValue();
                } else {
                    max = mid.subtract(new BigDecimal(1));
                }
            }
        }
        return x;
    }


    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 输入值
     * @return 平方根的整数部分
     */
    public int mySqrt1(int x) {
        return 0;
    }


    /**
     * 不改变原链表
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
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

    /**
     * 改变原链表
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
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
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows 行数
     * @return 生成的杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> pre = result.get(i - 1);
                list.add(pre.get(j) + pre.get(j - 1));
            }
            if (i > 0) {
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }


    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 0=< k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 下标
     * @return 杨辉三角的对应行
     */
    public List<Integer> getRow(int rowIndex) {
        return generate(34).get(rowIndex);
    }


    /**
     * 空间复杂度0(k)
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 0=< k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 下标
     * @return 杨辉三角的对应行
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            int temp = 1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    result.add(1);
                    continue;
                }
                int s = temp + result.get(j);
                temp = result.get(j);
                result.set(j, s);
            }
        }
        return result;
    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。(尾节点不一定指向首节点中间的环也可)
     *
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
     *
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
            if (slow == fast) {
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
     *
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


    /**
     * 对问题进行抽象 空间复杂度为O(1)
     * 160. 相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
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
     * 169. 求众数
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * @param nums 给定数组
     * @return 众数元素
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (result == nums[i]) {
                num++;
            } else {
                num = 1;
                result = nums[i];
            }

            if (num >= ((nums.length / 2) + 1)) {
                return result;
            }
        }

        return result;
    }

    /**
     * 203. 删除链表中的节点
     * 删除链表中等于给定值 val 的所有节点。
     *
     * @param head 给定链表
     * @param val  要删除的值
     * @return 删除后的链表
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
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
     *
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
     *
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
     *
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
     *
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
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 传入数组
     */
    public void moveZeroes(int[] nums) {
        int sumOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int preIndex = i;
                for (int j = i + 1; j < nums.length - sumOfZero; j++) {
                    if (nums[j] != 0) {
                        nums[preIndex] = nums[j];
                        nums[j] = 0;
                        preIndex = j;
                    }
                }
                sumOfZero++;
            }
        }
    }


    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 传入数组
     */
    public void moveZeroes1(int[] nums) {
        int nunZeroNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nunZeroNums];
                nums[nunZeroNums] = nums[i];
                nums[i] = temp;
                nunZeroNums++;
            }
        }
    }


    /**
     * 292. Nim游戏
     * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。你作为先手。
     * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
     *
     * @param n 石块数量
     * @return 是否能赢
     */
    public boolean canWinNim(int n) {
        return (n % 4) > 0;
    }


    /**
     * 561. 数组拆分 I
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
     * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * @param nums 传入的长度为2n数组
     * @return 最大总和
     * 主要思路 排序后两两分组，每组中较小值求和
     */
    public int arrayPairSum(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += nums[2 * i];
        }
        return result;
    }


    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * @param nums 原始数组
     * @param r    新数组行数
     * @param c    新数组列数
     * @return 返回结果
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int[][] result = new int[r][c];
        int rol = 0, col = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[rol][col];
                col++;
                if (col == nums[0].length) {
                    col = 0;
                    rol++;
                }
            }
        }
        return result;
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

            ListNode(int x) {
                val = x;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
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

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
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
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
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
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
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
            for (int i = 0; i <= size; i++) {
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

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
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


    /**
     * 766. 托普利茨矩阵
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     *
     * @param matrix 传入矩阵
     * @return 是否为托普利茨矩阵
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int k = i;
            int pre = matrix[0][i];
            for (int j = 0; j < Math.min(matrix[0].length - i, matrix.length); j++, k++) {
                if (matrix[j][k] != pre) {
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int k = i;
            int pre = matrix[i][0];
            for (int j = 0; j < Math.min(matrix.length - i, matrix[0].length); j++, k++) {
                if (matrix[k][j] != pre) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 852. 山脉数组的峰顶索引
     * 我们把符合下列属性的数组 A 称作山脉：
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     *
     * @param A 一个山脉数组
     * @return 山脉数组的i值
     */
    public int peakIndexInMountainArray(int[] A) {
        int min = 0, max = A.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                max = min + 1;
            } else if (A[mid] < A[mid - 1]) {
                max = mid - 1;
            }
        }
        return 0;
    }

    /**
     * 867. 转置矩阵
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * @param A 输入矩阵
     * @return 转置后的矩阵
     */
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

}
