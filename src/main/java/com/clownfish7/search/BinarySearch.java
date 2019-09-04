package com.clownfish7.search;

import java.util.ArrayList;

/**
 * @author yzy
 * @classname BinarySearch
 * @description 二分查找
 * @create 2019-09-04 11:35
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000,1000,1000,1000,1000, 1234};
        ArrayList list = search(arr, 0, arr.length - 1, 1000);
        System.out.println("index: " + list);
    }

    public static ArrayList search(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;

        if (left > right) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-1);
            return arrayList;
        }

        if (arr[mid] > value) {
            right = mid - 1;
            return search(arr, left, right, value);
        } else if (arr[mid] < value) {
            left = mid + 1;
            return search(arr, left, right, value);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int index = mid;
            while (--index >= left && arr[index] == value) {
                arrayList.add(index);
            }
            arrayList.add(mid);
            index = mid;
            while (++index <= right  && arr[index] == value) {
                arrayList.add(index);
            }
            return arrayList;
        }
    }
}
