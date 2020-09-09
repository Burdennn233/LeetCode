package com.burdennn;

import java.util.Date;

/**
 * 1360. Number of Days Between Two Dates {@url https://leetcode.com/problems/number-of-days-between-two-dates/}
 *
 * Write a program to count the number of days between two dates.
 *
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 *
 *
 * Example 1:
 *
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * Example 2:
 *
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 *
 */


public class No1360 {
    public static void main(String[] args) {
        System.out.println(new Solution1360().daysBetweenDates("2074-09-12", "1983-01-08"));
    }
}

class Solution1360 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDaysFrom(date1) - getDaysFrom(date2));
    }

    public int getDaysFrom(String date) {
        int[] dayOfMonth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strs = date.split("-");
        boolean isOdd = isOdd(Integer.valueOf(strs[0]));
        int days = 0;
        for (int i = 1971; i < Integer.valueOf(strs[0]); i++) {
            days += isOdd(i) ? 366 : 365;
        }
        for (int i = 1; i < Integer.valueOf(strs[1]); i++) {
            days += dayOfMonth[i];
            if (i == 2 && isOdd) {
                days++;
            }
        }
        return days + Integer.valueOf(strs[2]);
    }

    public boolean isOdd(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
