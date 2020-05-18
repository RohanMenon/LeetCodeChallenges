/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

*/


class Solution {
    public boolean isEqual(int[] a, int[] b){
        for(int i=0;i<26;i++) if(a[i] != b[i]) return false;
        
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {        
        int s1Len = s1.length();
        int s2Len = s2.length();
        int start = 0;
        
        if(s2Len < s1Len)
            return false;
        
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        
        for(int i=0;i < s1Len;i++){
            s1Freq[s1.charAt(i) - 'a'] += 1;
            s2Freq[s2.charAt(i) - 'a'] += 1;
        }
        
        for(int i = s1Len;i < s2Len;i++){
            if(isEqual(s1Freq, s2Freq))
                return true;
        
            s2Freq[s2.charAt(start) - 'a'] -= 1;
            s2Freq[s2.charAt(i) - 'a'] += 1;
            start += 1;  
        }
        
        if(isEqual(s1Freq, s2Freq))
                return true;
        
        return false;
    }
}
