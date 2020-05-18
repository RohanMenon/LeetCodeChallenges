/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/


class Solution {
    public boolean isEqual(int[] a, int[] b){
        for(int i=0;i<26;i++) if(a[i] != b[i]) return false;
        
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        int start = 0;
        
        if(sLen < pLen)
            return new ArrayList();
        
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        
        for(int i=0;i < pLen;i++){
            pFreq[p.charAt(i) - 'a'] += 1;
            sFreq[s.charAt(i) - 'a'] += 1;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = pLen;i < sLen;i++){
            if(isEqual(pFreq, sFreq))
                result.add(start);
        
            sFreq[s.charAt(start) - 'a'] -= 1;
            sFreq[s.charAt(i) - 'a'] += 1;
            start += 1;  
        }
        
        if(isEqual(pFreq, sFreq))
            result.add(start);
                
        return result;
    }
}
