package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname QuickSort
 * @description 快速排序
 * @create 2019-09-03 9:46
 */
public class QuickSort {
    public static void main(String[] args) {
//        int arr[] = {-9, 78, 0, 23, -567, 70};
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long before = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        long after = System.currentTimeMillis();
        System.out.println("run time: " + (after - before));
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            sort(arr, left, r);
        }
        if (right > l) {
            sort(arr, l, right);
        }
    }
}
