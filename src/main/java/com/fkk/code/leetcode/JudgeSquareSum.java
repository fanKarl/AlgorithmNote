package com.fkk.code.leetcode;

/**
 * 平方数之和：LeetCode 633：https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {

    /**
     * 暴力破解 一
     */
    public boolean judgeSquareSum(int c) {

        int sqrt = (int) Math.sqrt(c);

        for (int i = 0; i <= sqrt; i++) {
            int m = c - i * i;
            int a = (int) Math.sqrt(m);
            if (a * a == m) {
                return true;
            }
        }

        return false;
    }

    /**
     * 方法二： 二分查找法
     */
    public boolean judgeSquareSum2(int c) {

        for (long a = 0; a * a <= c; a++) {
            int m = c - (int) (a * a);
            if (binarySearch(0, m, m)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     */
    public boolean binarySearch(long start, long end, int m) {
        if (start > end) {
            return false;
        }

        long mid = (start + end) / 2;
        if (mid * mid == m) {
            return true;
        } else if (mid * mid > m) {
            return binarySearch(start, mid - 1, m);
        } else {
            return binarySearch(mid + 1, end, m);
        }

    }


}
