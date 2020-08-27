package com.burdennn;

import java.util.HashMap;
import java.util.Map;

/**
 * 1155. Number of Dice Rolls With Target Sum {@url https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/}
 *
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 *
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 *
 *
 *
 * Example 1:
 *
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation:
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation:
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 * Example 4:
 *
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation:
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 * Example 5:
 *
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation:
 * The answer must be returned modulo 10^9 + 7.
 *
 */


public class No1155 {
    public static void main(String[] args) {
        System.out.println(new Solution1155().numRollsToTarget(30, 30, 500));
    }
}

class Solution1155 {
    public static final int MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return sub(d, f, target, cache);
    }

    public int sub(int d, int f, int target, Map<String, Integer> cache) {
        if (target == 0) {
            return 0;
        }

        if (d == 1) {
            return f >= target ? 1 : 0;
        }

        String key = d + "," + target;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int sum = 0;
        for (int i = 1; i <= f && i <= target; i++) {
            sum = (sum + sub(d - 1, f, target - i, cache)) % MOD;
        }

        cache.put(key, sum);
        return sum;
    }
}
