package com.burdennn;

import java.util.Arrays;

/**
 * 1542. Find Longest Awesome Substring {@url https://leetcode.com/problems/find-longest-awesome-substring/}
 *
 * Given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in order to make it palindrome.
 *
 * Return the length of the maximum length awesome substring of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3242415"
 * Output: 5
 * Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
 * Example 2:
 *
 * Input: s = "12345678"
 * Output: 1
 * Example 3:
 *
 * Input: s = "213123"
 * Output: 6
 * Explanation: "213123" is the longest awesome substring, we can form the palindrome "231132" with some swaps.
 * Example 4:
 *
 * Input: s = "00"
 * Output: 2
 *
 */


public class No1542 {
    public static void main(String[] args) {
        System.out.println(new Solution1542().longestAwesome("3242415")); // 5
        System.out.println(new Solution1542().longestAwesome("12345678")); // 1
        System.out.println(new Solution1542().longestAwesome("213123")); // 6
        System.out.println(new Solution1542().longestAwesome("00")); // 2
    }
}

class Solution1542 {
    public int longestAwesome(String s) {
        int[] dp = new int[1024];
        Arrays.fill(dp, s.length());
        int num = 0;
        int res = 0;
        dp[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            num ^= 1 << (s.charAt(i) - '0');
            dp[num] = Math.min(i, dp[num]);
            res = Math.max(res, i - dp[num]);
            for (int j = 0; j <= 9; j++) {
                res = Math.max(res, i - dp[num ^ (1 << j)]);
            }
        }
        return res;
    }
}

//class Solution1542 {
//    public int longestAwesome(String s) {
//        int max = 0;
//        for (int i = 0; i <= s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                if (isPal(s.substring(i, j))) {
//                    max = Math.max(j - i, max);
//                }
//            }
//        }
//        return max;
//    }
//
//    public boolean isPal(String s) {
//        int[] bit = new int[10];
//        for (char c : s.toCharArray()) {
//            bit[c - '0']++;
//        }
//        int cnt = 0;
//        for (int i = 0; i < 10; i++) {
//            if (bit[i] % 2 != 0) {
//                cnt++;
//            }
//        }
//        return cnt <= 1;
//    }
//}