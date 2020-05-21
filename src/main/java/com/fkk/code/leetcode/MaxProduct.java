package com.fkk.code.leetcode;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    temp = temp * nums[j];
                }
                max = Math.max(temp, max);
            }
        }
        return max;
    }

}
