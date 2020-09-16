package com.burdennn;

/**
 * 409. Longest Palindrome {@url https://leetcode.com/problems/longest-palindrome/}
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 *
 */


public class No409 {
    public static void main(String[] args) {
        // 983
        System.out.println(new Solution409().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(new Solution409().longestPalindrome("bb"));
    }
}

class Solution409 {
    public int longestPalindrome(String s) {
        int[] dic = new int['z'];
        for (char c : s.toCharArray()) {
            dic[c - 'A']++;
        }
        int numOddMax = 0;
        int numOdd = 0;
        int numEven = 0;
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] >0 && dic[i] % 2 == 0) {
                numEven += dic[i];
            } else if (dic[i] > 0){
                numOddMax = Math.max(numOddMax, dic[i]);
                numOdd += dic[i] - 1;
            }
        }
        return numEven + numOdd + (numOddMax == 0 ? 0 : 1);
    }
}
