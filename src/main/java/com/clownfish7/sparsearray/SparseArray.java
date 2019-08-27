package com.clownfish7.sparsearray;


/**
 * @author You
 * @create 2019-08-24 17:19
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("原始二位数组 ");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }
//        int[][] sparseArr = new int[3][3];
//        sparseArr[0][0] = 11;
//        sparseArr[0][1] = 11;
//        sparseArr[0][2] = 2;
//        sparseArr[1][0] = 1;
//        sparseArr[1][1] = 2;
//        sparseArr[1][2] = 1;
//        sparseArr[2][0] = 2;
//        sparseArr[2][1] = 3;
//        sparseArr[2][2] = 2;

        System.out.println("原始二维数组 -> 稀疏数组 ");
        int rowNum = 1;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data == 0) {
                    continue;
                }
                rowNum++;
            }
        }

        int[][] sparseArr = new int[rowNum][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = 2;

        rowNum = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[rowNum][0] = i;
                    sparseArr[rowNum][1] = j;
                    sparseArr[rowNum][2] = chessArr1[i][j];
                    rowNum ++;
                }
            }
        }

        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }

        System.out.println("稀疏数组 -> 原始二维数组 ");
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }
    }
}
