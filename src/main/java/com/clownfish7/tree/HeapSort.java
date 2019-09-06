package com.clownfish7.tree;

import java.util.Arrays;

/**
 * @author yzy
 * @classname HeapSort
 * @description TODO
 * @create 2019-09-06 16:16
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, 11 , 32, -1 , 20,50,60,61,62,63};
        sort(arr);
    }

    public static void sort(int[] arr) {
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("1 -> " + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("2 -> " + Arrays.toString(arr));
        int c = 1;
        System.out.println("0 -> " + Arrays.toString(arr));
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
            System.out.println(c + " -> " + Arrays.toString(arr));
            c++;
        }

        int temp = 0;
        for (int i = arr.length - 1; i> 0; i--) {
            temp= arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        System.out.println("- -> " + Arrays.toString(arr));
    }

    /**
     * 任务：完成以 i 对应的非叶子节点的树调整为大顶堆
     *
     * @param arr    待调整数组
     * @param i      非叶子节点在数组中的索引
     * @param length 对多少个元素调整,length逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
        System.out.println("    + -> " + Arrays.toString(arr));
    }
}
