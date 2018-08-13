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
//        int[] i = new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7};
        int[] i = new int[]{4,-1,4,-2,4};
        int[][] y = new int[][]{{2,4}};
//        int[][] y = new int[][]{{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22},{14,-25},{-11,69},{63,36},{35,-99},{-24,82},{-29,-98},{-50,-70},{72,95},{80,80},{-68,-40},{65,70},{-92,78},{-45,-63},{1,34},{81,50},{14,91},{-77,-54},{13,-88},{24,37},{-12,59},{-48,-62},{57,-22},{-8,85},{48,71},{12,1},{-20,36},{-32,-14},{39,46},{-41,75},{13,-23},{98,10},{-88,64},{50,37},{-95,-32},{46,-91},{10,79},{-11,43},{-94,98},{79,42},{51,71},{4,-30},{2,74},{4,10},{61,98},{57,98},{46,43},{-16,72},{53,-69},{54,-96},{22,0},{-7,92},{-69,80},{68,-73},{-24,-92},{-21,82},{32,-1},{-6,16},{15,-29},{70,-66},{-85,80},{50,-3},{6,13},{-30,-98},{-30,59},{-67,40},{17,72},{79,82},{89,-100},{2,79},{-95,-46},{17,68},{-46,81},{-5,-57},{7,58},{-42,68},{19,-95},{-17,-76},{81,-86},{79,78},{-82,-67},{6,0},{35,-16},{98,83},{-81,100},{-11,46},{-21,-38},{-30,-41},{86,18},{-68,6},{80,75},{-96,-44},{-19,66},{21,84},{-56,-64},{39,-15},{0,45},{-81,-54},{-66,-93},{-4,2},{-42,-67},{-15,-33},{1,-32},{-74,-24},{7,18},{-62,84},{19,61},{39,79},{60,-98},{-76,45},{58,-98},{33,26},{-74,-95},{22,30},{-68,-62},{-59,4},{-62,35},{-78,80},{-82,54},{-42,81},{56,-15},{32,-19},{34,93},{57,-100},{-1,-87},{68,-26},{18,86},{-55,-19},{-68,-99},{-9,47},{24,94},{92,97},{5,67},{97,-71},{63,-57},{-52,-14},{-86,-78},{-17,92},{-61,-83},{-84,-10},{20,13},{-68,-47},{7,28},{66,89},{-41,-17},{-14,-46},{-72,-91},{4,52},{-17,-59},{-85,-46},{-94,-23},{-48,-3},{-64,-37},{2,26},{76,88},{-8,-46},{-19,-68}};
        System.out.println(y.length);
        System.out.println(Leetcode.robotSim(i, y));
        System.out.println(Leetcode.robotSim1(i, y));
        System.out.println(Leetcode.checkPossibility(null));
        System.out.println(Leetcode.titleToNumber(null));
        System.out.println(Leetcode.twoTable());
        String[] a = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(Leetcode.subdomainVisits(a));
        System.out.println(Leetcode.convertToTitle(0));
    }
}
