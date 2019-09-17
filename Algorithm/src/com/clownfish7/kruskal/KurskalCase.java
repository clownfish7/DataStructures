package com.clownfish7.kruskal;

import java.util.Arrays;

/**
 * @author yzy
 * @classname KurskalCase
 * @description TODO
 * @create 2019-09-17 17:40
 */
public class KurskalCase {

    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}
        };

        KurskalCase kurskalCase = new KurskalCase(vertexs, matrix);
        kurskalCase.print();
        EData[] edges = kurskalCase.getEdges();
        kurskalCase.sortEdge(edges);
        System.out.println(Arrays.toString(edges));
        kurskalCase.kurskal();
    }

    public KurskalCase(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;

        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (this.matrix[i][j] != INF && this.matrix[i][j] != 0) {
                    this.edgeNum++;
                }
            }
        }
        edgeNum /= 2;
    }

    public void kurskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] results = new EData[edgeNum];
        EData[] edges = getEdges();
        System.out.println(edges.length);

        sortEdge(edges);

        for (int i = 0; i < edges.length; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            if (m != n) {
                ends[m] = n;
                results[index++] = edges[i];
            }
        }

        System.out.println(Arrays.toString(results));
    }

    public void print() {
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%10d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sortEdge(EData[] eDatas) {
        for (int i = 0; i < eDatas.length - 1; i++) {
            for (int j = 0; j < eDatas.length - i - 1; j++) {
                if (eDatas[j].weight > eDatas[j + 1].weight) {
                    EData temp = eDatas[j];
                    eDatas[j] = eDatas[j + 1];
                    eDatas[j + 1] = temp;
                }
            }
        }
    }

    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] eDatas = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF && this.matrix[i][j] != 0) {
                    eDatas[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return eDatas;
    }

    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
