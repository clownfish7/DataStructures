package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname BubbleSort
 * @description TODO
 * @create 2019-09-02 9:54
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {-5,3, 9, -1, 10, -2};
//        int arr[] = {1,2,3,4,5,6,8,9};
        int arr[] = new int[80000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }

        System.out.println(Arrays.toString(arr));

        long before = System.currentTimeMillis();
        sort(arr);
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    public static void sort(int[] arr) {
        boolean finish;
        for (int i = 0; i < arr.length - 1; i++) {
            finish = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    finish = false;
                }
            }
            if (finish) {
                break;
            }
//            System.out.println(Arrays.toString(arr));
        }

//        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }
}
