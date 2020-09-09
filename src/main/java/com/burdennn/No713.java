package com.burdennn;

/**
 * 713. Subarray Product Less Than K {@url https://leetcode.com/problems/subarray-product-less-than-k/}
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 */


public class No713 {
    public static void main(String[] args) {
        System.out.println(new Solution713().numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }
}

class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int cnt = 0;
        int tmp = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp *= nums[i];
            while (left <= i && tmp >= k) {
                tmp /= nums[left++];
            }
            cnt += (i - left + 1);
        }
        return cnt;

    }
}
