package com.fkk.code.leetcode;

public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int N) {

        int count = 0;
        for (int i = 1; i < N/2; i++) {
            int mid = N / i;
            if (i % 2 == 0) {
                if (mid > i / 2 && mid * i + i / 2 == N) {
                    count++;
                }
            } else {
                if (mid * i == N) {
                    count++;
                }
            }
        }
        return count;
    }

}
