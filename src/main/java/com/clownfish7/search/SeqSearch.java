package com.clownfish7.search;

/**
 * @author yzy
 * @classname SeqSearch
 * @description 线性查找
 * @create 2019-09-04 11:27
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 46, 486, 132, 165, 413, 13};
        int index = search(arr, 132);
        System.out.println("index: " + index);
    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
