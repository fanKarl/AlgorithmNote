package com.fkk.code.index;

/**
 * 合并数组： https://leetcode-cn.com/problems/sorted-merge-lcci/
 */
public class MergeArrays {

    public static void test() {
        int[] a1 = {1, 2, 3, 0, 0, 0};
        int[] b1 = {2, 5, 6};
        merge01(a1, 3, b1, 3);

        int[] a2 = {0};
        int[] b2 = {1};
        merge01(a2,0,b2,1);//考察临界条件

        int[] a3 = {2,0};
        int[] b3 = {1};
        merge01(a3,1,b3,1);
    }

    /**
     * 快速排序法
     */
    public static void merge01(int[] A, int m, int[] B, int n) {

        if (n == 0) {
            return;
        }

        if (m == 0) {
            if (n >= 0) {
                System.arraycopy(B, 0, A, 0, n);
            }
            return;
        }


        int stepA = m - 1;
        int stepB = n - 1;
        int step = (m + n - 1);

        while (step >= 0) {
            if (stepB < 0) {
                A[step] = A[stepA];
                stepA--;
                step--;
                continue;
            }

            if (stepA < 0) {
                A[step] = B[stepB];
                stepB--;
                step--;
                continue;
            }

            if (A[stepA] > B[stepB]) {
                A[step] = A[stepA];
                stepA--;
            } else {
                A[step] = B[stepB];
                stepB--;
            }
            step--;
        }
    }
}
