package com.fkk.code;

import com.fkk.code.leetcode.LongestPalindrome;

public class LeetCodeManager {

    public static void runSolution() {
//        MergeArrays.testMergeArrays();
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String arrays = longestPalindrome.useCenterSpreadPlus("abbabb");
        printArray("LongestPalindrome", arrays);
    }

    private static void printArray(String key, String dstArrays) {
        StringBuilder bubble = new StringBuilder(key);
        bubble.append(": [ ");
        for (char b : dstArrays.toCharArray()) {
            bubble.append(b).append(" ");
        }
        bubble.append("]");
        System.out.println(bubble.toString());
    }

}
