package com.burdennn;

/**
 * 1131. Maximum of Absolute Value Expression {@url https://leetcode.com/problems/maximum-of-absolute-value-expression/}
 *
 * Given two arrays of integers with equal lengths, return the maximum value of:
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * Example 2:
 *
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 *
 */


public class No1131 {
    public static void main(String[] args) {
        System.out.println(new Solution1131().maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6}));
    }
}

class Solution1131 {
    public int maxAbsValExpr(int[] x, int[] y) {
        int res = 0, n = x.length, P[] = {-1,1};
        for (int p : P) {
            for (int q : P) {
                int smallest = p * x[0] + q * y[0] + 0;
                for (int i = 1; i < n; ++i) {
                    int cur = p * x[i] + q * y[i] + i;
                    res = Math.max(res, cur - smallest);
                    smallest = Math.min(smallest, cur);
                }
            }
        }
        return res;
    }
}