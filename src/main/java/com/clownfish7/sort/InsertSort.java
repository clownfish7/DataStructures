package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname InsertSort
 * @description TODO
 * @create 2019-09-02 14:58
 */
public class InsertSort {
    public static void main(String[] args) {
//        int arr[] = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long before = System.currentTimeMillis();
        sort(arr);
        long after = System.currentTimeMillis();
        System.out.println("run time: " + (after - before));

    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && arr[index] < value) {
                arr[index + 1] = arr[index];
                index--;
            }
            if (arr[index + 1] != value) {
                arr[index + 1] = value;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
