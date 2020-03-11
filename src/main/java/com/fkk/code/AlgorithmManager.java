package com.fkk.code;

import com.fkk.code.algorithm.SortAlgorithm;

public class AlgorithmManager {

    public static void testSort() {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] targetArrays = {1, 77, 45, 31, 21, 34, 88, 22, 5, 6, 2};
        int[] targetArrays02 = {5, 4, 3, 2, 1};
//        printArray("Bubble Sort ",sortAlgorithm.bubbleSort(targetArrays02));
//        printArray("Selection Sort ",sortAlgorithm.selectionSort(targetArrays02));
//        printArray("Insertion Sort", sortAlgorithm.insertionSort(targetArrays02));
        printArray("Insertion Sort", sortAlgorithm.mergeSort(targetArrays));


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
