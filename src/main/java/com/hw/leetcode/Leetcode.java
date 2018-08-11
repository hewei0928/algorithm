package com.hw.leetcode;

import com.hw.algorithm.union_found.WeightedQuickUnionUF;

import java.util.*;

/**
 * @Author: Hewei
 * @Description: leetcode刷题记录
 * @Date: Created in 17:08 2018/7/27
 */
public class Leetcode {

    /**
     * 1. 两数之和
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
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
                } else {
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
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums 输入数组
     * @return 删除后数组的有效长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //重复数的数量
        int duplicateCount = 0;
        for (int i = 0; i < nums.length - duplicateCount - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int temp = nums[i];
                System.arraycopy(nums, i + 1, nums, i, nums.length - duplicateCount - 1 - i);
                nums[nums.length-duplicateCount - 1] = temp;
                duplicateCount++;
                i--;
            }
        }
        return nums.length - duplicateCount;
    }




    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums 输入数组
     * @return 删除后数组的有效长度
     * 思路: 双指针
     */
    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
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
        if (nums == null) {
            return 0;
        }
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
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * @param nums 有序数组
     * @param target 要插入的数字
     * @return 插入索引
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }




    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums 输入数组
     * @return 最大子序列和
     * 思路： 如果加到某个下标处和小于零，则一定不包含在最大子序列内
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }


    /**
     * 66. 加一
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits 非负整数非空数组
     * @return 新数组
     */
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int[] result = new int[digits.length];
        int newValue = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = (digits[i] + newValue) % 10;
            newValue = (digits[i] + newValue) / 10;
        }
        if (newValue == 1) {
            int[] temp = new int[result.length + 1];
            temp[0] = 1;
            System.arraycopy(result, 0, temp, 1, result.length);
            return temp;
        }
        return result;
    }


    /**
     * 66. 加一
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits 非负整数非空数组
     * @return 新数组
     * 思路： 数组大小变化时，必定为99，999，9999,....
     */
    public int[] plusOne1(int[] digits) {
        if (digits == null) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        // 利用数组初始值每位都为1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 输入值
     * @return 平方根的整数部分
     * x / i < i
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        for (int i = 1; i <= x; i++) {
            if (x / i < i) {
                return i - 1;
            }
        }
        return 0;
    }



    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * @param nums 输入数组
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int zero = 0, one = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (i < zero + one) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }


    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * @param nums 输入数组
     */
    public void sortColors1(int[] nums) {
        if (nums == null) {
            return;
        }
        int indexBefore = 0, indexEnd = nums.length - 1;
        for (int i = 0; i <= indexEnd; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[indexBefore];
                nums[indexBefore] = temp;
                indexBefore++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[indexEnd];
                nums[indexEnd] = temp;
                indexEnd--;
                //往后移index-- 往前则无须-1
                i--;
            }
        }
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
     * 88. 合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * @param nums1 数组1
     * @param m 实际存储数量
     * @param nums2 数组2
     * @param n 实际存储的数量
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1, l = m + n - 1;
        while (k > -1 && j > -1) {
            if (nums2[k] >= nums1[j]) {
                nums1[l] = nums2[k];
                k--;
            } else {
                nums1[l] = nums1[j];
                j--;
            }
            l--;
        }
        while (k >= 0) {
            nums1[k] = nums2[k];
            k--;
        }
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
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 改变序列
        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i - 1];
        }
        prices[0] = 0;
        // 求最大子序列
        int maxSum=0,sum=0;
        for (int price : prices) {
            sum += price;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }


    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * @param prices 价格列表
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i-1];
        }
        prices[0] = 0;

        int maxSum = 0;
        for (int price : prices) {
            if (price > 0) {
                maxSum += price;
            }
        }

        return maxSum;
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
     * 147. 对链表进行插入排序
     * 对链表进行插入排序。
     * @param head 头节点
     * @return 排序后链表
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        ListNode current = head;
        while (current.next != null) {
            // 要排序的节点
            ListNode pre = current;
            current = current.next;
            // 插入遍历节点
            ListNode node = result;
            // 头节点之前插入
            if (current.val <= node.val) {
                pre.next = current.next;
                current.next = node;
                result = current;
                current = pre;
                continue;
            }
            while (node.next != current) {
                if (node.val <= current.val && current.val <= node.next.val) {
                    pre.next = current.next;
                    current.next = node.next;
                    node.next = current;
                    current = pre;
                    break;
                }
                node = node.next;
            }
        }
        return result;
    }


    /**
     * 147. 对链表进行插入排序
     * 对链表进行插入排序。
     * @param head 头节点
     * @return  插入后的链表
     */
    public ListNode insertionSortList1(ListNode head) {
        ListNode helper=new ListNode(0);
        ListNode pre;
        ListNode current=head;
        while(current!=null) {
            pre=helper;
            while(pre.next!=null&&pre.next.val<current.val) {
                pre=pre.next;
            }
            ListNode next=current.next;
            current.next=pre.next;
            pre.next=current;
            current=next;
        }
        return helper.next;
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
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照 升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * @param numbers 有序数组
     * @param target 两个数的和
     * @return 两个下标值
     */
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (maps.containsKey(numbers[i])) {
                return new int[]{maps.get(numbers[i]) + 1, i + 1};
            } else {
                maps.put(target - numbers[i], i);
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
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int num = 0;
        int result = nums[0];
        for (int num1 : nums) {
            if (result == num1) {
                num++;
            } else {
                num = 1;
                result = num1;
            }

            if (num >= ((nums.length / 2) + 1)) {
                return result;
            }
        }

        return result;
    }


    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums 数组
     * @param k 平移次数
     */
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        k = k % length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            for (int j = 0; j < length; j++) {
                int value = nums[(j + 1) % length];
                nums[(j + 1) % length] = temp;
                temp = value;
            }
        }
    }


    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums 数组
     * @param k 平移次数
     * 思路：
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        k = k % nums.length;
        reverse(nums,0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组某一范围内的数
     * @param nums 数组
     * @param start 起始下标
     * @param end 结束下标
     */
    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * 200. 岛屿的个数
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     * 你可以假设网格的四个边均被水包围。
     * @param grid 岛屿数组
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        WeightedQuickUnionUF quickUnionUF = new WeightedQuickUnionUF(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i-1][j] == '1') {
                        quickUnionUF.union(i*col+j, (i-1)*col+j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        quickUnionUF.union(i*col+j, i*col+j-1);
                    }
                }
            }
        }

        //判断该点位陆地且根节点值与其下标值相同
        int count = 0;
        int[] a = quickUnionUF.getArray();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(a[i * col + j] == (i * col + j) && grid[i][j] == '1'){
                    count ++;
                }
            }
        }
        return count;
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
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * @param nums 给定数组
     * @return 是否存在重复值
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            if (sets.contains(num)) {
                return true;
            } else {
                sets.add(num);
            }
        }
        return false;
    }


    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * @param nums 数组
     * @param k 整数
     * @return 是否存在
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);

        }
        return false;
    }




    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     *
     * @param head 链表
     * @return 是否为回文链表
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
        if (node == null) {
            return;
        }
        if (node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * @param s s
     * @param t t
     * @return 是否是字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i ++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * @param s s
     * @param t t
     * @return 是否是字母异位词
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            table[t.charAt(i) - 'a'] --;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }


    /**
     * 268. 缺失数字
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * @param nums 数组
     * @return 缺失的数字
     */
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int all = (nums.length + 1) * nums.length / 2;
        return  all - sum;
    }



    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 传入数组
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
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
        if (nums == null) {
            return;
        }
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
     * 349. 两个数组的交集
     * 给定两个数组，写一个函数来计算它们的交集。
     * 例子:
     * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
     * 每个在结果中的元素必定是唯一的
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> sets = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j <nums2.length;) {
            if (nums1[i] == nums2[j]) {
                sets.add(nums1[i]);
                j++;
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                i++;
            }
        }

        int[] results = new int[sets.size()];
        int i = 0;
        for (Integer result : sets) {
            results[i] = result;
            i++;
        }
        return results;
    }


    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，写一个方法来计算它们的交集。
     * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j <nums2.length;) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            result[index ++] = i;
        }
        return result;
    }


    /**
     * 414. 第三大的数
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * @param nums 数组
     * @return 返回值
     */
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer max = null;
        Integer second = null;
        Integer third = null;
        for (Integer num : nums) {
            if (num.equals(max) || num.equals(second) || num.equals(third)) {
                continue;
            }
            if (max == null || num > max) {
                third = second;
                second = max;
                max = num;
            } else if ((second == null || (num < max && num > second))) {
                third = second;
                second = num;
            } else if ((third == null || (num < second && num > third))) {
                third = num;
            }
        }

        return (third == null) ? max : third;
    }



    /** 
     * 448. 找到所有数组中消失的数字
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了(两次)，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * @param nums 给定数组
     * @return 消失的数字集合
     * 思路： 重点在出现一次和两次以及出现的数范围上
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }


    /**
     * 463. 岛屿的周长
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。网格中的格子水平和垂直方向相连（对角线方向不相连）。
     * 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
     * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * @param grid 地图数组
     * @return 岛屿周长
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 1方块数量以及内部连接变
        int count = 0, adjacent = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if ((i > 0 && grid[i-1][j] == 1)) {
                        adjacent++;
                    }
                    if ((j > 0 && grid[i][j-1] == 1)) {
                        adjacent++;
                    }
                }
            }
        }
        return count*4 - 2*adjacent;
    }



    /**
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * @param nums 给定数组 [1,1,0,1,1,1]
     * @return 连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                index++;
            } else {
                index = 0;
            }
            max = Math.max(index, max);
        }

        return max;
    }


    // TODO: 2018/8/11
    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j),
     * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * @param nums 数组
     * @param k 差值
     * @return k-diff 数对 数量
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < k) {
                count++;
            }
            sets.add(nums[i]);
        }
        return 0;
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
        if (nums == null) {
            return 0;
        }
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
        if (nums == null || nums.length == 0 || r * c != nums.length * nums[0].length)
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
     * 581. 最短无序连续子数组
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度。
     * @param nums
     * @return
     */
//    public int findUnsortedSubarray(int[] nums) {
//
//    }



    /**
     * 605. 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
     * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     * @param flowerbed 已有花坛数组
     * @param n 要种的花的数量
     * @return 能否成功
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null) {
            return false;
        }
        //记录间隔数的集合
        List<Integer> places = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 1) {
                count ++ ;
                if (i == flowerbed.length - 1) {
                    places.add(count + 1);
                }
            } else {
                places.add(count);
                count = 0;
            }
        }

        int flowers = 0;
        for (Integer place : places) {
            flowers += (place - 1)/2;
        }
        return flowers >= n;
    }


    /**
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * @param nums 数组
     * @return 最大乘积
     * 思路 不论正负， 最大值总是min*secondmin*max 和max*secondmax*thirdmax的较大值（三个最大值中有1到2个负数则最大值一定为min*secondmin*max）
     */
    public int maximumProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE, max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        for (int num : nums){
            if (num >= max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num >= secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax){
                thirdMax = num;
            }

            if (num <= min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }

        return Math.max(min*secondMin*max, max*secondMax*thirdMax);
    }


    /**
     * 643. 子数组最大平均数 I
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     * @param nums 给定数组
     * @param k 子数组长度
     * @return 最大平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                count += nums[j];
            }
            max = Math.max(count, max);
        }
        return ((double)max) / k;
    }


    /**
     * 661. 图片平滑器
     * 包含整数的二维矩阵 M 表示一个图片的灰度。
     * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)，
     * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     * @param M 表示图片的数组
     * @return 平滑后的数组
     */
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) {
            return null;
        }
        int row = M.length, col = M[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int total = M[i][j], count = 1;
                if (i > 0) {
                    total += M[i-1][j];
                    count++;
                    if (j > 0) {
                        total += M[i-1][j-1];
                        count++;
                    }
                    if (j < col-1) {
                        total += M[i-1][j+1];
                        count++;
                    }
                }

                if (i < row - 1) {
                    total += M[i+1][j];
                    count++;
                    if (j > 0) {
                        total += M[i+1][j-1];
                        count++;
                    }
                    if (j < col-1) {
                        total += M[i+1][j+1];
                        count++;
                    }
                }

                if (j > 0) {
                    total += M[i][j-1];
                    count++;
                }
                if (j < col - 1) {
                    total += M[i][j+1];
                    count++;
                }

                result[i][j] = total/count;
            }
        }
        return result;
    }


    // TODO: 2018/8/10 未完成
    /**
     * 665. 非递减数列
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *  我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     * @param nums 数组
     * @return 能否成功
     * 思路 找到第一个大于后一个数的数下标，当它为i-1或i+1时其后的数组是否有序
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                if (i != 0) {
                    nums[i] = nums[i-1];
                    for (int j = i; j < nums.length - 1; j++) {
                        if (nums[j] > nums[j + 1]) {
                            return false;
                        }
                    }
                    nums[i] = temp;
                }
                nums[i] = nums[i + 1];
//                for (int k = i; k < nums.length - 1; k++) {
//                    if (nums[k] > )
//                }
            }
        }
        return true;
    }


    /**
     * 674. 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     * @param nums 数组
     * @return 最长递增子序列
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1,temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);

        return max;
    }



    /**
     * 695. 岛屿的最大面积
     * 给定一个包含了一些 0 和 1的非空二维数组 grid ,
     * 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
     * 你可以假设二维矩阵的四个边缘都被水包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
     * @param grid 地图数组
     * @return 最大岛屿面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int length = grid.length * grid[0].length, row = grid.length, col = grid[0].length;
        WeightedQuickUnionUF quickUnionUF = new WeightedQuickUnionUF(length);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (j > 0 && grid[i][j - 1] == 1) {
                        quickUnionUF.union( i*col+j, i*col+j-1);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        quickUnionUF.union(i*col+j, (i-1)*col+j);
                    }
                } else {
                    quickUnionUF.array[i*col+j] = -1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int size = quickUnionUF.size(i*col+j);
                if (size > max) {
                    max = size;
                }
            }
        }
        return max;
    }





    /**
     * 697. 数组的度
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * @param nums 数组
     * @return 度
     */
    public int findShortestSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                List<Integer> list = result.get(nums[i]);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                result.put(nums[i], list);
            }
        }

        int max = 0, length = nums.length;
        for (int i : result.keySet()) {
            List<Integer> list = result.get(i);
            if (list.get(0) >= max) {
                max = list.get(0);
            }
        }

        for (int i : result.keySet()) {
            List<Integer> list = result.get(i);
            if (list.get(0) == max) {
                int temp = list.get(2) - list.get(1) + 1;
                if (temp < length) {
                    length = temp;
                }
            }
        }

        return length;
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
        MyLinkedList() {
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
            return n.val;
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
     * 717. 1比特与2比特字符
     * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
     * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
     * @param bits 字符数组
     * @return 最后一个字符是否必定为一个一比特字符
     * 思路： 遇0 +1， 遇1 +2
     */
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null) {
            return false;
        }
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 0) {
                if (i == bits.length-1) {
                    return true;
                } else {
                    i++;
                }
            } else {
                i += 2;
            }
        }
        return false;
    }


    /**
     * 724. 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @param nums 数组
     * @return 中心索引下标
     */
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int total = 0, left = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (total - left - nums[i] == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }



    // TODO: 2018/8/9 动态规划 重点
    /** 
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * @param cost 数组
     * @return 最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) return 0;
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;

    }

    /**
     * 747. 至少是其他数字两倍的最大数
     * 在一个给定的非负数组nums中，总是存在一个最大元素 。
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * 如果是，则返回最大元素的索引，否则返回-1。
     * @param nums 数组
     * @return 最大数的索引
     */
    public int dominantIndex(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0, max = 0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= (2 * second)) {
            return index;
        } else return -1;
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
        if (matrix == null) {
            return false;
        }
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
     * 771. 宝石与石头
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *  J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * @param J
     * @param S
     * @return
     */
//    public int numJewelsInStones(String J, String S) {
//        int count = 0;
//        for (int i = 0; i < S.length(); i++) {
//            if (J.co) {
//
//            }
//        }
//    }



    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 最终结果按照字典顺序输出。
     * @param S 字符串
     * @return  较大分组位置
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        int count = 1, start = 0, end = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                if (i == chars.length - 1) {
                    count++;
                    if (count >= 3) {
                        end = i;
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(end);
                        result.add(list);
                    }

                } else {
                    if (count == 1) {
                        start = i - 1;
                    }
                    count++;
                    if (count >= 3) {
                        end = i;
                    }
                }
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                }
                count = 1;
            }
        }
        return result;
    }


    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 最终结果按照字典顺序输出。
     * @param S 字符串
     * @return  较大分组位置
     */
    public List<List<Integer>> largeGroupPositions1(String S) {
        if (S == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, length = S.length();
        for (int i = 0; i < length; i++) {
            if (i == length - 1 || S.charAt(i) != S.charAt(i + 1)) {
                if (i - start + 1 >= 3) {
                    result.add(Arrays.asList(start, i));
                }
                start = i + 1;
            }
        }
        return result;
    }

    /**
     * 840. 矩阵中的幻方
     * 3 x 3 的幻方是一个填充有从 1 到 9 的 不同数字 的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
     * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
     * @param grid 矩阵
     * @return 幻方的数量
     */
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 5) {
                    int num0 = grid[i-1][j-1],
                            num1 = grid[i-1][j],
                            num2 = grid[i-1][j+1],
                            num3 = grid[i][j-1],
                            num4 = grid[i][j],
                            num5 = grid[i][j+1],
                            num6 = grid[i+1][j-1],
                            num7 = grid[i+1][j],
                            num8 = grid[i+1][j+1];
                    if (magic(num0, num1, num2, num3, num4, num5, num6, num7, num8)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v: vals) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }



    /**
     * 849. 到最近的人的最大距离
     * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
     * 至少有一个空座位，且至少有一人坐在座位上。
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * 返回他到离他最近的人的最大距离。
     * @param seats 座位数组
     * @return 最大距离
     */
//    public int maxDistToClosest(int[] seats) {
//        if (seats == null) {
//            return 0;
//        }
//        int start = -1, end = -1, max = 0, temp = 0;
//        for (int i = 0; i < seats.length; i++) {
//            if (seats[i] == 1);
//        }
//    }



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
        if (A == null) {
            return 0;
        }
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
        if (A == null) {
            return null;
        }
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

}
