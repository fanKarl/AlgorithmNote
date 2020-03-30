package com.fkk.code.leetcode;

import com.fkk.code.utils.Log;

/**
 * 无重复字符的最长子串：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {



    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int step = i + 1;
            while (step < s.length()) {
                String tempStr = s.substring(i, step);
                char temp = s.charAt(step);
                if (tempStr.indexOf(temp) == -1) {
                    step++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(step - i, maxLength);
        }

        return maxLength;
    }

}
