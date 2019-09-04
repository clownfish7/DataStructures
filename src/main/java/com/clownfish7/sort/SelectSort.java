package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname SelectSort
 * @description 选择排序
 * @create 2019-09-02 10:53
 */
public class SelectSort {
    public static void main(String[] args) {
//        int arr[] = {1,2,3,4,5,6,7,8,8,9,10,3132};
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }
        long before = System.currentTimeMillis();
        sort(arr);
        long after = System.currentTimeMillis();
        System.out.println(before-after);

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] < arr[j]) {
                    index = j;
                }
            }
            if (index!=i) {
                arr[index] = arr[index] ^ arr[i];
                arr[i] = arr[index] ^ arr[i];
                arr[index] = arr[index] ^ arr[i];
                System.out.println();
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
