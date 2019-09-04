package com.clownfish7.search;

import java.util.Arrays;

/**
 * @author yzy
 * @classname FibonacciSearch
 * @description 斐波那契
 * @create 2019-09-04 15:22
 */
public class FibonacciSearch {

    public static final int MAXSIZE = 20;

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int index = search(arr, 89);
        System.out.println("index = "+index);
    }

    public static int[] fib() {
        int f[] = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0;
        int f[] = fib();

        while (high > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid -1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
