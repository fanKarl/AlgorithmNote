package com.fkk.code.leetcode;

import java.util.stream.Stream;

/**
 * 05. 最长回文字符串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 终极改进版O(n)算法
     */
    public String manacher(String s){
        
        return null;
    }

    /**
     * 中心扩散法：改进版
     * 时间复杂度O(n^2)
     */
    public String useCenterSpreadPlus(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String dstStr = addBounds(s, '#');
        int maxLength = 1;

        int start = 0;
        for (int i = 0; i < dstStr.length(); i++) {
            int step = centerSpread(dstStr, i);
            if (step > maxLength) {
                maxLength = step;
                //根据新串中的位置，和目标回文串的宽度计算原字符串中的起始位置
                start = (i - maxLength) / 2;
            }
        }

        return s.substring(start, start + maxLength);

    }

    private int centerSpread(String src, int center) {
        int length = src.length();
        int left = center - 1;
        int right = center + 1;

        int step = 0;
        while (left >= 0 && right < length && src.charAt(left) == src.charAt(right)) {
            left--;
            right++;
            step++;
        }

        return step;
    }

    private String addBounds(String src, char divider) {
        if (src == null || src.length() == 0) {
            return "";
        }

        if (src.indexOf(divider) != -1) {
            throw new IllegalArgumentException("参数错误，不可以传递已经存在的字符作为分隔符");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(divider);
        for (char ch : src.toCharArray()) {
            stringBuilder.append(ch).append(divider);
        }
        return stringBuilder.toString();
    }

    /**
     * 中心扩散法：时间复杂度O(n^2)
     */
    public String useCenterSpread(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLength = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxString = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxString.length() > maxLength) {
                maxLength = maxString.length();
                res = maxString;
            }
        }
        return res;
    }

    private String centerSpread(String src, int left, int right) {
        int length = src.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < length) {
            if (src.charAt(i) == src.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return src.substring(i + 1, j);
    }

    /**
     * 暴力破解法: 这是一个糟糕的解法
     * 时间复杂度是： O(n^3)
     */
    public String useBruteForce(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLength && isPalindrome(s, i, j)) {
                    maxLength = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String src, int left, int right) {
        while (left < right) {
            if (src.charAt(left) != src.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

}
