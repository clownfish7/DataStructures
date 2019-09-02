package com.clownfish7.recursion;

/**
 * @author You
 * @create 2019-09-01 0:11
 */
public class Queen8 {
    int max = 8;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queen8 q = new Queen8();
        q.check(0);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n+1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
