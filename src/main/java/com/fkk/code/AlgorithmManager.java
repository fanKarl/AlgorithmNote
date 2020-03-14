package com.fkk.code;

import com.fkk.code.algorithm.SortAlgorithm;

import java.util.Arrays;

public class AlgorithmManager {

    public static void testSort() {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] targetArrays = {1, 77, 45, 31, 21, 34, 88, 22, 5, 6, 2};
        int[] targetArrays02 = {5, 4, 3, 2, 1};
        printArray("Old Arrays",copyArray(targetArrays));
//        printArray("Bubble Sort ", sortAlgorithm.bubbleSort(copyArray(targetArrays02)));
//        printArray("Selection Sort ", sortAlgorithm.selectionSort(copyArray(targetArrays02)));
//        printArray("Insertion Sort", sortAlgorithm.insertionSort(copyArray(targetArrays02)));
//        printArray("Insertion Sort", sortAlgorithm.mergeSort(copyArray(targetArrays02)));
        printArray("quick sort",sortAlgorithm.quickSort(copyArray(targetArrays02)));

    }

    private static int[] copyArray(int[] srcArray) {
        return Arrays.copyOf(srcArray, srcArray.length);
    }

    private static void printArray(String key, int[] dstArrays) {
        StringBuilder bubble = new StringBuilder(key);
        bubble.append(": [ ");
        for (int b : dstArrays) {
            bubble.append(b).append(" ");
        }
        bubble.append("]");
        System.out.println(bubble.toString());
    }
}
