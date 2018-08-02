package com.hw.leetcode;

import com.hw.leetcode.leetcode;

import java.io.FileWriter;

/**
 * @Author: Hewei
 * @Description:
 * @Date: Created in 20:56 2018/7/30
 */
public class PSVM {
    public static void main(String[] args) throws Exception{
        leetcode leetcode = new leetcode();
        int[] a = new int[]{-1,1,1,1,2,1};
        System.out.println(leetcode.removeElement(a, 1));
    }
}
