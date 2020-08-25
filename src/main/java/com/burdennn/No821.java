package com.burdennn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 821. Shortest Distance to a Character {@url https://leetcode.com/problems/shortest-distance-to-a-character/}
 * <p>
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */


public class No821 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution821().shortestToChar("loveleetcode", 'e')));
    }
}

class Solution821 {
    public int[] shortestToChar(String S, char C) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                indices.add(i);
            }
        }

        Integer[] targets = indices.toArray(new Integer[0]);
        int[] res = new int[S.length()];
        int start = -1;
        for (int i = 0; i < S.length(); i++) {
            if (i < targets[0]) {
                res[i] = targets[0] - i;
            } else {
                res[i] = getMin(i, targets[Math.max(0, start)], targets[Math.min(targets.length - 1, start + 1)]);
                if (i == targets[Math.min(targets.length - 1, start + 1)]) {
                    start++;
                }
            }
        }
        return res;
    }

    public int getMin(int c, int start, int end) {
        return Math.min(Math.abs(c - start), Math.abs(c - end));
    }
}

//     public int[] shortestToChar(String S, char C) {
//        int n = S.length(), pos = -n, res[] = new int[n];
//        for (int i = 0; i < n; ++i) {
//            if (S.charAt(i) == C) pos = i;
//            res[i] = i - pos;
//        }
//        for (int i = pos - 1; i >= 0; --i) {
//            if (S.charAt(i) == C)  pos = i;
//            res[i] = Math.min(res[i], pos - i);
//        }
//        return res;
//    }