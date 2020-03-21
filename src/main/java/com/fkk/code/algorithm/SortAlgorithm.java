package com.fkk.code.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private int[] mergeArrays(int[] left, int[] right) {
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


    /**
     * 快速排序：
     * 发起
     */
    public int[] quickSort(int[] arrays) {
        return quickSort(arrays, 0, arrays.length - 1);
    }

    /**
     * 快速排序：
     * 1. 选中基准点
     * 2. 对左右数组进行递归快排
     */
    private int[] quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            //标定基准，同时以基准对arrays left-right进行快速排序
            int partition = partition(arrays, left, right);
            //对基准左边数组进行快排
            quickSort(arrays, left, partition - 1);
            //对基准右边数组进行快排
            quickSort(arrays, partition + 1, right);

        }
        return arrays;
    }

    /**
     * 快速排序-选择基准元素
     */
    private int partition(int[] arrays, int left, int right) {
        int pivot = arrays[left];//锚定基准点
        int j = right;
        int i = left;
        while (i < j) {
            // 从右侧开始检查，找到第一个小于基数的元素位置
            while (i < j && arrays[j] >= pivot) {
                j--;
            }

            //从左侧开始找，找到第一个大于基数的元素位置
            while (i < j && arrays[i] <= pivot) {
                i++;
            }

            //只有位置不同的时候再交换
            if (i != j) {
                swap(arrays, i, j);
            }

        }
        //同一位置没必要交换
        if (left != i) {
            swap(arrays, left, i);
        }

        return i;
    }


    /**
     * 堆排序
     */
    public int[] heapSort(int[] arrays) {
        int length = arrays.length;
        //首先构建大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            //找到第一个非叶子节点，下到上，右到左。
            // 可以自行画图找规律 length / 2 - 1
            adjustHeap(arrays, i, length);
        }
        //每次把堆顶元素与末尾元素交换，堆减少一个元素，直到遍历完成
        for (int i = length - 1; i > 0; i--) {
            //交换堆顶元素,与末尾元素
            swap(arrays, 0, i);
            //重新构建大顶堆
            adjustHeap(arrays, 0, i);
        }
        return arrays;
    }

    /**
     * 堆排序核心 - 调整 大顶堆
     */
    private void adjustHeap(int[] arrays, int i, int length) {
        int temp = arrays[i];//临时存储 i 对应元素
        //每次选取指定节点的左节点进行比较
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //比较左右节点大小，右节点大选择右节点作为比较对象
            if (k + 1 < length && arrays[k] < arrays[k + 1]) {
                k++;
            }
            //比较和temp元素的大小, 若temp小则被换掉
            // 因为每次比较的都是temp，k位置元素不用改变，最后再改变即可
            if (arrays[k] > temp) {
                arrays[i] = arrays[k];
                i = k;//i直接用来存储每次交换后新的k的位置
            }

        }
        //最终i的值确定以后把临时temp存进去，完成大顶堆的调整
        arrays[i] = temp;
    }

    /**
     * 计数排序
     * 1. 遍历原数组，找出最大和最小元素
     * 2. 根据最大和最小元素创建 计数数组C
     * 3. 遍历原数组，将每一个元素出现的次数存入C中指定位置
     * 4. 对C中每一项都与前一项进行相加运算
     * 5. 倒叙遍历原数组，根据C中i项的值确定在原数组中的位置，同时C[i]-1
     */
    public int[] countingSort(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return arrays;
        }
        int min = arrays[0], max = arrays[0];
        int srcLength = arrays.length;
        //遍历找到最大值和最小值
        for (int temp : arrays) {
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }

        //构建计数数组
        int bucketLength = max - min + 1;
        int[] bucketArray = new int[bucketLength];

        //再次遍历原数组，找出找出元素重复数量
        for (int array : arrays) {
            bucketArray[array - min]++;
        }

        //每一项与前一项叠加
        for (int i = 1; i < bucketLength; i++) {
            bucketArray[i] += bucketArray[i - 1];
        }

        //开始再次遍历原数组
        int[] dstArray = new int[srcLength];
        for (int i = srcLength - 1; i >= 0; i--) {
            int target = arrays[i];
            //计算得到当前元素之前又多少个元素
            int bucketIndex = target - min;
            int index = bucketArray[bucketIndex] - 1;
            dstArray[index] = target;
            bucketArray[bucketIndex]--;
        }
        return dstArray;
    }

    /**
     * 桶排序：
     * 1. 计数排序是特殊的桶排序
     * 2. 桶排序也需要开辟内存空间
     * 3. 内存空间由序列最大值决定
     */
    public void bucketSort(int[] arrays) {
        int min = arrays[0], max = arrays[0];
        int srcLength = arrays.length;
        //遍历找到最大值和最小值
        for (int temp : arrays) {
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }
        //也可以使用别的分组方式
        int bucketSize = (max - min) / srcLength + 1;

        //构建桶
        List<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<>());
        }

        for (int array : arrays) {
            int index = (array - min) / srcLength;
            bucketList.get(index).add(array);
        }

        //对桶中元素进行排序
        for (ArrayList<Integer> item : bucketList) {
            if (!item.isEmpty()){
                //使用官方API，也可以根据需要使用别的排序法
                Collections.sort(item);
            }
        }

        System.out.println("bucket arrays: " + bucketList.toString());
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
