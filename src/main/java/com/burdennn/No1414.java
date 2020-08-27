package com.burdennn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K {@url https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/}
 *
 * Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.
 *
 * The Fibonacci numbers are defined as:
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 , for n > 2.
 * It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.
 *
 *
 * Example 1:
 *
 * Input: k = 7
 * Output: 2
 * Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
 * For k = 7 we can use 2 + 5 = 7.
 * Example 2:
 *
 * Input: k = 10
 * Output: 2
 * Explanation: For k = 10 we can use 2 + 8 = 10.
 * Example 3:
 *
 * Input: k = 19
 * Output: 3
 * Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 *
 */


public class No1414 {
    public static void main(String[] args) {
        System.out.println(new Solution1414().findMinFibonacciNumbers(19));
    }
}

class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibList = new ArrayList<>();
        fibList.add(1);
        fibList.add(1);
        fib(fibList, k);
        return calc(k, fibList);
    }

    public void fib(List<Integer> fibList, int k) {
        int next = fibList.get(fibList.size() - 1) + fibList.get(fibList.size() - 2);
        if (next <= k) {
            fibList.add(next);
            fib(fibList, k);
        } else {
            return;
        }
    }

    public int calc(int k, List<Integer> fibList) {
        if (k == 0) {
            return 0;
        }

        int max = fibList.get(fibList.size() - 1);
        for(int i = fibList.size() - 1; i >= 0; i--) {
            if (fibList.get(i) <= k) {
                max = fibList.get(i);
                break;
            }
        }
        return calc(k - max, fibList) + 1;
    }
}

//
//    public int findMinFibonacciNumbers(int k) {
//        if (k < 2) return k;
//        int a = 1, b = 1;
//        while (b <= k) {
//            b += a;
//            a = b - a;
//        }
//        return 1 + findMinFibonacciNumbers(k - a);
//    }