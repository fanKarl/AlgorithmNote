package com.fkk.code;

import com.fkk.code.leetcode.PatternIsMatch;

public class LeetCodeManager {

    public static void runSolution() {
//        MergeArrays.testMergeArrays();
//        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        String arrays = longestPalindrome.useCenterSpreadPlus("abbabb");
//        printArray("LongestPalindrome", arrays);

//        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
//        int count = substring.solution("abcabcbb");
//        System.out.println("count = "+count);


        PatternIsMatch patternIsMatch = new PatternIsMatch();
        System.out.println("{aa,a,false} = " + patternIsMatch.isMatch("aa", "a"));
        System.out.println("{aa,a*,true} = " + patternIsMatch.isMatch("aa", "a*"));
        System.out.println("{ab,.*,true} = " + patternIsMatch.isMatch("ab", ".*"));
        System.out.println("{aab,c*a*b,true} = " + patternIsMatch.isMatch("aab", "c*a*b"));
        System.out.println("{mississippi,mis*is*p*.,false} = " + patternIsMatch.isMatch("mississippi", "mis*is*p*."));
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
