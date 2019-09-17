package com.clownfish7.dynamic;

import java.util.Arrays;

/**
 * @author yzy
 * @classname KnaostackProblem
 * @description 动态匹配背包问题
 * @create 2019-09-11 13:54
 */
public class KnaostackProblem {
    public static void main(String[] args) {
        int w[] = {1, 4, 3};
        int val[] = {1500, 3000, 2000};
        int m = 4;
        int n = val.length;

        int v[][] = new int[n + 1][m + 1];
        int path[][] = new int[n + 1][m + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }
        System.out.println();
        for (int i = 0; i < path.length; i++) {
            System.out.println(Arrays.toString(path[i]));
        }

        int i = v.length - 1;
        int j = v[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n",i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
