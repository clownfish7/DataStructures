package com.clownfish7.greedy;

import java.util.*;

/**
 * @author yzy
 * @classname GreedyAlgorithm
 * @description 贪心算法
 * @create 2019-09-17 14:55
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Map<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        HashSet<String> areas = new HashSet<>();
        areas.add("北京");
        areas.add("上海");
        areas.add("天津");
        areas.add("广州");
        areas.add("深圳");
        areas.add("成都");
        areas.add("杭州");
        areas.add("大连");

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> temp = new HashSet<>();

        String maxKey = null;
        while (areas.size() != 0) {
            for (String key : broadcasts.keySet()) {
                HashSet<String> area = broadcasts.get(key);
                temp.clear();
                temp.addAll(area);
                temp.retainAll(areas);
                if (temp.size() > 0 &&
                        (maxKey == null || temp.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                areas.removeAll(broadcasts.get(maxKey));
            }
            maxKey = null;
        }

        System.out.println("result "+selects);
    }
}
