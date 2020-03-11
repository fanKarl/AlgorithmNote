package com.fkk.code.algorithm;

public class SortAlgorithm {

    /**
     * 冒泡排序
     * 两两比较，步骤：
     * 1. 相邻元素比较，比如第一个元素和第二个元素比较，大的元素移动到后面
     * 2. 继续比较每一对相邻元素，大的元素放后面，一直到最后一对元素比较完毕，最大的元素就到最后面了
     * 3. 重复上述步骤，再比较时不必比较上一次循环确定的最大元素也就是最后一个元素
     * 4. 重复1-3步骤，直到全部比较完毕
     * <p>
     * 可用数据结构：数组
     */
    public int[] bubbleSort(int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }

    /**
     * 选择排序法:
     * 时间复杂度O(n^2)，步骤：
     * 1. 拿每一个跟后续所有元素比较，找到最小元素
     * 2. 最小元素和当前所在元素交换位置
     * 3. 重复1、2步骤直到所有元素都遍历了一遍
     */
    public int[] selectionSort(int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return arrays;
        }

        int length = arrays.length;

        int minIndex;

        for (int i = 0; i < length; i++) {
            minIndex = i;
            //这里使用i+1，因为每次遍历之后第一项肯定是最小的，否则会引入脏数据
            for (int j = i + 1; j < length; j++) {
                if (arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[minIndex];
            arrays[minIndex] = temp;
        }

        return arrays;
    }

    /**
     * 插入排序法:
     * 1. 从第二个元素开始遍历数组，每一轮拿当前位置元素跟前面所有元素比较
     * 2. 比较过程中，比当前元素大的后移一位，直到遇到第一个比当前元素小的元素
     * 3. 将当前元素插入到小元素后面一位
     * 4. 重复1-3步骤直到全部遍历完毕
     * 时间复杂度：平均是O(n^2),
     */
    public int[] insertionSort(int[] arrays) {
        int length = arrays.length;
        int preIndex, currValue;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            currValue = arrays[i];
            while (preIndex >= 0 && arrays[preIndex] > currValue) {
                arrays[preIndex + 1] = arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex + 1] = currValue;
        }
        return arrays;
    }

    /**
     * 归并排序法（二路归并）
     */
    public int[] mergeSort(int[] arrays) {
        if (arrays.length < 2) {
            return arrays;
        }
        int n = arrays.length / 2;
        int[] left = new int[n];
        int[] right = new int[arrays.length - n];
        System.arraycopy(arrays, 0, left, 0, left.length);
        System.arraycopy(arrays, n, right, 0, right.length);
        return mergeArrays(mergeSort(left), mergeSort(right));
    }

    /**
     * 对左右数组进行合并排序
     */
    public int[] mergeArrays(int[] left, int[] right) {
        int[] mergeArrays = new int[left.length + right.length];
        int a = 0, b = 0;
        for (int i = 0; i < mergeArrays.length; i++) {
            if (a >= left.length) {
                mergeArrays[i] = right[b];
                b++;
            } else if (b >= right.length) {
                mergeArrays[i] = left[a];
                a++;
            } else {
                if (left[a] < right[b]) {
                    mergeArrays[i] = left[a];
                    a++;
                } else {
                    mergeArrays[i] = right[b];
                    b++;
                }
            }
        }
        return mergeArrays;
    }

}
