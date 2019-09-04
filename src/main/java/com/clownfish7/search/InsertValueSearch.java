package com.clownfish7.search;

import java.util.Arrays;

/**
 * @author yzy
 * @classname InsertValueSearch
 * @description 插值查找
 * @create 2019-09-04 14:44
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        int index = search(arr, 0, arr.length - 1, 500);
        System.out.println("index: " + index);
    }

    public static int search(int[] arr, int left, int right, int value) {
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (left > right || value < arr[left] || value > arr[right]) {
            return -1;
        }

        if (arr[mid] > value) {
            return search(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return search(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
