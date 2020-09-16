package com.burdennn;

import java.util.Arrays;

/**
 * 1072. Flip Columns For Maximum Number of Equal Rows {@url https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/}
 *
 * Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
 *
 * Return the maximum number of rows that have all values equal after some number of flips.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * Example 2:
 *
 * Input: [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * Example 3:
 *
 * Input: [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 *
 */


public class No1072 {
    public static void main(String[] args) {
        System.out.println(new Solution1072().maxEqualRowsAfterFlips(new int[][]{{0,0,0},{0,0,1},{1,1,0}}));
        System.out.println(new Solution1072().maxEqualRowsAfterFlips(new int[][]{{0,1},{1,1}}));
    }
}

class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int cnt = 0;
            int[] flip = new int[col];
            for (int j = 0; j < col; j++) {
                flip[j] = 1 - matrix[i][j];
            }

            for (int j = 0; j < matrix.length; j++) {
                if (Arrays.equals(matrix[i], matrix[j]) || Arrays.equals(flip, matrix[j])) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
