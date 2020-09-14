package com.burdennn;

/**
 * 813. Largest Sum of Averages {@url https://leetcode.com/problems/largest-sum-of-averages/}
 *
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?
 *
 * Note that our partition must use every number in A, and that scores are not necessarily integers.
 *
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 */


public class No813 {
    public static void main(String[] args) {
        System.out.println(new Solution813().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(new Solution813().largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }
}

//class Solution813 {
//    public double largestSumOfAverages(int[] A, int K) {
//        double[] sum = new double[A.length];
//        sum[0] = A[0];
//        for (int i = 1; i <= A.length - 1; i++) {
//            sum[i] = sum[i - 1] + A[i];
//        }
//        return subFun(sum, A, 0, K);
//    }
//
//    public double subFun(double[] sum, int[] A, int start, int K) {
//        int len = sum.length;
//        if (K <= 1) {
//            return (sum[len - 1] - sum[start] + A[start]) / (len - start);
//        }
//        double max = A[start];
//        for (int i = start; i + K <= len; i++) {
//            max = Math.max(max, (sum[i] - sum[start] + A[start]) / (i - start + 1) + subFun(sum, A, i + 1, K -1));
//        }
//        return max;
//    }
//}

class Solution813 {
    public double largestSumOfAverages(int[] A, int K) {
        double[] sum = new double[A.length];
        sum[0] = A[0];
        for (int i = 1; i <= A.length - 1; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        double[][] cache = new double[A.length + 1][K];
        return subFun(sum, A, 0, K, cache);
    }

    public double subFun(double[] sum, int[] A, int start, int K, double[][] cache) {
        int len = sum.length;
        if (K <= 1) {
            cache[start][K - 1] = (sum[len - 1] - sum[start] + A[start]) / (len - start);
        }
        if (cache[start][K - 1] != 0) {
            return cache[start][K - 1];
        }
        double max = A[start];
        for (int i = start; i + K <= len; i++) {
            max = Math.max(max, (sum[i] - sum[start] + A[start]) / (i - start + 1) + subFun(sum, A, i + 1, K -1 ,cache));
        }
        cache[start][K - 1] = max;
        return max;
    }
}
