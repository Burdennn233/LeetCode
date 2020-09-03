package com.burdennn;

/**
 * 875. Koko Eating Bananas {@url https://leetcode.com/problems/koko-eating-bananas/}
 *
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 *
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 *
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 *
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 *
 */


public class No875 {
    public static void main(String[] args) {
//        System.out.println(new Solution875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new Solution875().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }
}

class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {
        int len = piles.length;
        int max = piles[0];
        for (int i = 1; i < len; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int mid = max;
        while (left < right) {
            mid = (left + right) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles, int target, int H) {
        int cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            int mod = piles[i] % target;
            cnt += mod == 0 ? piles[i] / target : piles[i] / target + 1;
        }
        return cnt <= H;
    }
}