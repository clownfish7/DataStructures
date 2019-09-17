package com.clownfish7.binarysearchnorecursion;

/**
 * @author yzy
 * @classname BinarySearchNoRecur
 * @description 二分查找非递归
 * @create 2019-09-11 10:09
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = search(arr, 91);
        System.out.println(index);
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
