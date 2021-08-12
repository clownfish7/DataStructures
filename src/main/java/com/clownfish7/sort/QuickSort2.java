package com.clownfish7.sort;

import java.util.Arrays;

/**
 * classname QuickSort
 * description 随机快排
 * create 2021-08-10 13:38
 *
 * @author yzy yuzhiyou999@outlook.com
 * @version 1.0
 */
public class QuickSort2 {

    public void teskQuick() {
        int[] arr = new int[]{1, 3, 4, 6, 7, 6, 5, 1, 2, 4, 4, 1, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, l + (int)(Math.random() * (r-l+1)), r);
            int[] p = partition(nums, l, r);
            quickSort(nums, l, p[0] - 1);
            quickSort(nums, p[0] + 1, r);
        }
    }

    private int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, ++less, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};
    }


    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
