package com.fkk.code.leetcode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口法
     */
    public int scrollWindow(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }

            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }

        return max;
    }


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
