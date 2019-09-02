package com.clownfish7.sort;

import java.util.Arrays;

/**
 * @author yzy
 * @classname ShellSort
 * @description TODO
 * @create 2019-09-02 15:41
 */
public class ShellSort {
    public static void main(String[] args) {
//        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long before = System.currentTimeMillis();
        sort3Try(arr);
        long after = System.currentTimeMillis();
        System.out.println("run time: " + (after - before));
    }

    public static void sort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        arr[j] = arr[j] ^ arr[j + gap];
                        arr[j + gap] = arr[j] ^ arr[j + gap];
                        arr[j] = arr[j] ^ arr[j + gap];
                    }
                }
            }
            System.out.println("once: " + Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
    }

    // 移位法
    public static void sort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void sort3Try(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
