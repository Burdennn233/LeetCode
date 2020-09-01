package com.burdennn;

/**
 * 482. License Key Formatting {@url https://leetcode.com/problems/license-key-formatting/}
 * <p>
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 * <p>
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * <p>
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * <p>
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * <p>
 * Output: "5F3Z-2E9W"
 * <p>
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 * <p>
 * Output: "2-5G-3J"
 * <p>
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 */


public class No482 {
    public static void main(String[] args) {
        System.out.println(new Solution482().licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(new Solution482().licenseKeyFormatting("aaaa", 2));
        System.out.println(new Solution482().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new Solution482().licenseKeyFormatting("---", 3));
    }
}

class Solution482 {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = new char[S.length() * 2];
        int cnt = 0;
        int tail = chars.length - 1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') {
                continue;
            }

            chars[tail--] = getChar(S.charAt(i));
            cnt++;

            if (cnt % K == 0 && i != 0) {
                chars[tail--] = '-';
            }
        }

        if (tail == chars.length - 1) {
            return "";
        }
        int offset = tail + 1;
        if (chars[tail + 1] == '-') {
            offset += 1;
        }
        return new String(chars, offset, chars.length - offset);
    }

    public char getChar(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return c;
        } else {
            return (char) (c - 32);
        }
    }
}
