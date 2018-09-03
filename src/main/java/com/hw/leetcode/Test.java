package com.hw.leetcode;

import java.util.Arrays;

/**
 * @Author: Hewei
 * @Description: 调用leetcode中的所有方法
 * @Date: Created in 10:49 2018/8/10
 */
public class Test {

    public static void main(String[] args) {
        Leetcode Leetcode = new Leetcode();
        System.out.println(Arrays.toString(Leetcode.twoSum(null, 0)));
        System.out.println(Leetcode.addTwoNumbers(null,null));
        System.out.println(Leetcode.mergeTwoLists(null, null));
        System.out.println(Leetcode.removeDuplicates(null));
        System.out.println(Leetcode.removeDuplicates1(null));
        System.out.println(Leetcode.removeElement(null, 1));
        System.out.println(Leetcode.searchInsert(null, 1));
        System.out.println(Leetcode.maxSubArray(null));
        System.out.println(Arrays.toString(Leetcode.plusOne(null)));
        System.out.println(Arrays.toString(Leetcode.plusOne1(null)));
        System.out.println(Leetcode.mySqrt(1));
        Leetcode.sortColors(null);
        Leetcode.sortColors1(null);
        System.out.println(Leetcode.deleteDuplicates(null));
        System.out.println(Leetcode.deleteDuplicates1(null));
        Leetcode.merge(null, 1, null, 2);
        System.out.println(Leetcode.generate(1));
        System.out.println(Leetcode.getRow(1));
        System.out.println(Leetcode.getRow1(1));
        System.out.println(Leetcode.maxProfit(null));
        System.out.println(Leetcode.maxProfit2(null));
        System.out.println(Leetcode.hasCycle(null));
        System.out.println(Leetcode.hasCycle1(null));
        System.out.println(Leetcode.insertionSortList(null));
        System.out.println(Leetcode.insertionSortList1(null));
        System.out.println(Leetcode.getIntersectionNode(null, null));
        System.out.println(Leetcode.getIntersectionNode1(null, null));
        System.out.println(Arrays.toString(Leetcode.twoSum1(null, 1)));
        System.out.println(Leetcode.majorityElement(null));
        Leetcode.rotate(null, 1);
        Leetcode.rotate1(null, 2);
        System.out.println(Leetcode.numIslands(null));
        System.out.println(Leetcode.removeElements(null, 1));
        System.out.println(Leetcode.reverseList(null));
        System.out.println(Leetcode.reverseList1(null));
        System.out.println(Leetcode.containsDuplicate(null));
        System.out.println(Leetcode.containsNearbyDuplicate(null, 1));
        System.out.println(Leetcode.isPalindrome(null));
        Leetcode.deleteNode(null);
        System.out.println(Leetcode.isAnagram(null, null));
        System.out.println(Leetcode.isAnagram1(null, null));
        System.out.println(Leetcode.missingNumber(null));
        Leetcode.moveZeroes(null);
        Leetcode.moveZeroes1(null);
        System.out.println(Leetcode.canWinNim(1));
        System.out.println(Arrays.toString(Leetcode.intersection(null, null)));
        System.out.println(Arrays.toString(Leetcode.intersect(null, null)));
        System.out.println(Leetcode.thirdMax(null));
        Leetcode.MyLinkedList myLinkedList = Leetcode.new MyLinkedList();
        myLinkedList.addAtIndex(0, 0);
        myLinkedList.addAtTail(1);
        myLinkedList.addAtHead(0);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(9));
        System.out.println(Leetcode.findDisappearedNumbers(null));
        System.out.println(Leetcode.findMaxConsecutiveOnes(null));
        System.out.println(Leetcode.arrayPairSum(null));
        System.out.println(Arrays.deepToString(Leetcode.matrixReshape(null, 1, 1)));
        System.out.println(Leetcode.canPlaceFlowers(null, 1));
        System.out.println(Leetcode.maxAreaOfIsland(null));
        System.out.println(Leetcode.findShortestSubArray(null));
        System.out.println(Leetcode.isOneBitCharacter(null));
        System.out.println(Leetcode.dominantIndex(null));
        System.out.println(Leetcode.isToeplitzMatrix(null));
        System.out.println(Leetcode.largeGroupPositions(null));
        System.out.println(Leetcode.largeGroupPositions1(null));
        System.out.println(Leetcode.peakIndexInMountainArray(null));
        System.out.println(Arrays.deepToString(Leetcode.transpose(null)));
        System.out.println(Leetcode.maximumProduct(null));
        System.out.println(Leetcode.minCostClimbingStairs(null));
        System.out.println(Leetcode.islandPerimeter(null));
        System.out.println(Arrays.deepToString(Leetcode.imageSmoother(null)));
        System.out.println(Leetcode.findLengthOfLCIS(null));
        System.out.println(Leetcode.pivotIndex(null));
        System.out.println(Leetcode.numMagicSquaresInside(null));
        System.out.println(Leetcode.findMaxAverage(null, 1));
        System.out.println(Leetcode.numJewelsInStones(null, null));
        System.out.println(Leetcode.maxIncreaseKeepingSkyline(null));
        System.out.println(Leetcode.toLowerCase(null));
        System.out.println(Leetcode.world());
        System.out.println(Arrays.deepToString(Leetcode.flipAndInvertImage(null)));
        System.out.println(Leetcode.person());
        System.out.println(Leetcode.hammingDistance(1, 2));
        System.out.println(Leetcode.mergeTrees(null, null));
        System.out.println(Leetcode.invertTree(null));
        System.out.println(Leetcode.findComplement(1));
        System.out.println(Leetcode.reverseString(null));
        System.out.println(Leetcode.movie());
        System.out.println(Leetcode.reverseWords(null));
        System.out.println(Arrays.toString(Leetcode.findWords(null)));
        System.out.println(Leetcode.selfDividingNumbers(1, 10));
        System.out.println(Leetcode.updateSalary());
        System.out.println(Leetcode.judgeCircle(null));
        System.out.println(Leetcode.uniqueMorseRepresentations(null));
        System.out.println(Leetcode.maxDepth(Leetcode.new Node(1, null)));
        System.out.println(Leetcode.maxDepth(Leetcode.new Node()));
        System.out.println(Leetcode.maxDepth(Leetcode.new TreeNode(1)));
        System.out.println(Leetcode.fizzBuzz(12));
        System.out.println(Leetcode.middleNode(null));
        System.out.println(Leetcode.employee());
        int[] i = new int[]{4,-1,4,-2,4};
        int[][] y = new int[][]{{2,4}};
        System.out.println(y.length);
        System.out.println(Leetcode.robotSim(i, y));
        System.out.println(Leetcode.robotSim1(i, y));
        System.out.println(Leetcode.checkPossibility(null));
        System.out.println(Leetcode.titleToNumber(null));
        System.out.println(Leetcode.twoTable());
        String[] a = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(Leetcode.subdomainVisits(a));
        System.out.println(Leetcode.convertToTitle(0));
        System.out.println(Leetcode.backspaceCompare(null, null));
        System.out.println(Leetcode.isPalindromeOne("A man, a plan, a canal: Panama"));
        System.out.println(Leetcode.isPalindromeOne1(null));
        System.out.println(Leetcode.strStr(null, null));
        System.out.println(Leetcode.findCircleNum(null));
        int[] as = new int[]{0,2,4,6,7,1,3,5};
        System.out.println(Leetcode.isPalindrome(1000));
        System.out.println(Leetcode.romanToInt(""));
        System.out.println(Leetcode.romanToInt1(null));
        System.out.println(-11 % 10);
        System.out.println(Leetcode.isValid(null));
        System.out.println(Leetcode.climbStairs(0));
        System.out.println(Leetcode.isSameTree(null, null));
        System.out.println(Leetcode.isSymmetric(null));
        System.out.println(Leetcode.hammingWeight(11));
        System.out.println(Leetcode.isUgly(0));
        System.out.println(Leetcode.countPrimes(1));
        System.out.println(Leetcode.countPrimes1(0));
        System.out.println(Leetcode.detectCycle(null));
        System.out.println(Leetcode.detectCycle1(null));
        com.hw.leetcode.Leetcode.ListNode a1 =  Leetcode.new ListNode(1);
        com.hw.leetcode.Leetcode.ListNode a2 =  Leetcode.new ListNode(2);
        com.hw.leetcode.Leetcode.ListNode a3 =  Leetcode.new ListNode(3);
        com.hw.leetcode.Leetcode.ListNode a4 =  Leetcode.new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(Leetcode.swapPairs(a1));
        System.out.println(Leetcode.removeNthFromEnd(null, 1));
        System.out.println(Leetcode.singleNumber(as));
        System.out.println(Leetcode.isHappy(11));
        System.out.println(Arrays.toString(Leetcode.uncommonFromSentences(null, null)));
    }
}
