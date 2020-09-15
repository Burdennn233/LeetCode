package com.burdennn;

/**
 * 67. Add Binary {@url https://leetcode.com/problems/add-binary/}
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */


public class No67 {
    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("1010", "1011")); // 10101
        System.out.println(new Solution67().addBinary("11", "1")); // 100
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder sbA = a.length() > b.length() ? new StringBuilder(a).reverse() : new StringBuilder(b).reverse();
        StringBuilder sbB = a.length() > b.length() ? new StringBuilder(b).reverse() : new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < sbB.length(); i++) {
            int num = sbA.charAt(i) - '0' + sbB.charAt(i) - '0' + cnt;
            cnt  = num / 2;
            sb.append(num % 2);
        }
        for (int i = sbB.length(); i < sbA.length(); i++) {
            int num = sbA.charAt(i) - '0' + cnt;
            cnt = num/2;
            sb.append(num % 2);
        }
        if (cnt > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
