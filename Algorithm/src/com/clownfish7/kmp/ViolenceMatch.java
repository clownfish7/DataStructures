package com.clownfish7.kmp;

/**
 * @author yzy
 * @classname ViolenceMatch
 * @description TODO
 * @create 2019-09-11 14:46
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = match(str1, str2);
        System.out.println(index);
    }

    public static int match(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1len = s1.length;
        int s2len = s2.length;

        int i = 0;
        int j = 0;

        while (i < s1len && j < s2len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == s2len) {
            return i - j;
        }
        return -1;
    }
}
