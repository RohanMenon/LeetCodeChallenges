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
    public boolean isAnagram(String a, String b){
        int[] a_frequency = new int[26];
        int[] b_frequency = new int[26];
        boolean flag = true;
        
        for(int i=0;i<26;i++) a_frequency[i] = 0;
        for(int i=0;i<26;i++) b_frequency[i] = 0;
        
        for(int i=0;i<a.length();i++) a_frequency[a.charAt(i) - 'a'] += 1;
        for(int i=0;i<b.length();i++) b_frequency[b.charAt(i) - 'a'] += 1;
        
        for(int i=0;i<26;i++)
            if(a_frequency[i] != b_frequency[i]){
                flag = false;
                break;
            }
        
        return flag;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i+pLength<=s.length();i++){
            if(isAnagram(s.substring(i, i + pLength), p))
                result.add(i);
        }
        
        return result;
    }
}
