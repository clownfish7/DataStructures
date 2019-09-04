package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname RadixSort
 * @description 基数排序 空间换时间
 * @create 2019-09-04 10:17
 */
public class RadixSort {

    public static void main(String[] args) {
//        int arr[] = {53, 3, 542, 748, 14, 214};
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        long before = System.currentTimeMillis();
        sort(arr);
        long after = System.currentTimeMillis();
        System.out.println("run time: " + (after - before));
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();
        int bucket[][] = new int[10][arr.length];
        int bucketElements[] = new int[10];
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElements[digitOfElement]] = arr[i];
                bucketElements[digitOfElement]++;
            }

            int index = 0;
            for (int i = 0; i < bucketElements.length; i++) {
                if (bucket[i][0] != 0) {
                    for (int j = 0; j < bucketElements[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                    bucketElements[i] = 0;
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }
}
