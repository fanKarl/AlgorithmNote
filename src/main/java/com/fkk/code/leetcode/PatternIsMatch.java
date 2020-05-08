package com.fkk.code.leetcode;

public class PatternIsMatch {

    /**
     * 回溯法
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        //第一个字节相同或者是 .
        boolean isHeadMatch = !s.isEmpty() && s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';

        if (p.length() >= 2 && p.charAt(1) == '*') {
            //前一种情况是出现0次，直接比较p后面的字符串
            return isMatch(s, p.substring(2)) || (isHeadMatch && isMatch(s.substring(1), p));
        }

        return isHeadMatch && isMatch(s.substring(1), p.substring(1));
    }
}
