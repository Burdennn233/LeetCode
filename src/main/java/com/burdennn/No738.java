package com.burdennn;

/**
 * 738. Monotone Increasing Digits {@url https://leetcode.com/problems/monotone-increasing-digits/}
 *
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 *
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 *
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 *
 */


public class No738 {
    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(654044082));
        System.out.println(new Solution738().monotoneIncreasingDigits(399443));
        System.out.println(new Solution738().monotoneIncreasingDigits(12345));
        System.out.println(new Solution738().monotoneIncreasingDigits(10));
    }
}

class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        char[] s = String.valueOf(N).toCharArray();
        int start = s.length;
        for (int i = s.length - 1; i >= 1; i--) {
            if (s[i] < s[i - 1]) {
                s[i - 1] = (char)(s[i - 1] - 1);
                start = i;
            }
        }

        for (int i = start; i < s.length; i++) {
            s[i] = '9';
        }
        return Integer.valueOf(new String(s));
    }
}
