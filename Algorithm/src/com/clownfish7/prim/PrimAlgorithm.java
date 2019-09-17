package com.clownfish7.prim;

import java.util.Arrays;

/**
 * @author yzy
 * @classname PrimAlgorithm
 * @description 普利姆算法  最小生成树
 * @create 2019-09-17 16:11
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                //'A', 'B', 'C', 'D', 'E', 'F', 'G'
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
        minTree.shorGraph(mGraph);

        minTree.prim(mGraph, 0);
    }
}


class MinTree {
    /**
     * @param graph  图对象
     * @param verxs  图顶点数
     * @param data   图顶点值
     * @param weight 图邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void shorGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verxs];

        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;

        for (int k = 1; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边 <" + graph.data[h1] + "," + graph.data[h2] + "> 权值: " + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }

    }
}

class MGraph {
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
