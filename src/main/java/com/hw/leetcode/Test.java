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
        System.out.println(Leetcode.mySqrt1(1));
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
        System.out.println(Leetcode.sortList(null));
        System.out.println(Leetcode.maximumProduct(null));
        System.out.println(Leetcode.checkPossibility(null));
        System.out.println(Leetcode.minCostClimbingStairs(null));
        System.out.println(Leetcode.islandPerimeter(null));
        System.out.println(Arrays.deepToString(Leetcode.imageSmoother(null)));
        System.out.println(Leetcode.findLengthOfLCIS(null));
        System.out.println(Leetcode.pivotIndex(null));
//        System.out.println(Leetcode.maxDistToClosest(null));
        System.out.println(Leetcode.numMagicSquaresInside(null));
        System.out.println(Leetcode.findMaxAverage(null, 1));
    }
}
