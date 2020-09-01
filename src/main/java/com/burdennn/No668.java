package com.burdennn;

/**
 * 668. Kth Smallest Number in Multiplication Table {@url https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/}
 *
 * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?
 *
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.
 *
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 * Example 2:
 * Input: m = 2, n = 3, k = 6
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 *
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 *
 */


public class No668 {
    public static void main(String[] args) {
        System.out.println(new Solution668().findKthNumber(3, 3, 5)); // 3
        System.out.println(new Solution668().findKthNumber(2, 3, 6)); // 6
        System.out.println(new Solution668().findKthNumber(42, 34, 401)); //126
        System.out.println(new Solution668().findKthNumber(45, 12, 471));
    }
}

class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = countMin(mid, m, n);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int countMin(int target, int row, int line) {
        int i = row;
        int j = 1;
        int cnt = 0;
        while (i >= 1 && j <= line) {
            if (i * j <= target) {
                j++;
                cnt += i;
            } else {
                i--;
            }
        }
        return cnt;
    }


}
