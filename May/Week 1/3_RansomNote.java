/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] ransomFrequency = new int[26];
        int[] magazineFrequency = new int[26];
        boolean result=true;
        
        for(int i=0;i<26;i++) ransomFrequency[i]=0;
        
        for(int i=0;i<26;i++) magazineFrequency[i]=0;
        
        for(int i=0;i<ransomNote.length();i++) ransomFrequency[ransomNote.charAt(i)-'a'] += 1; 
        
        for(int i=0;i<magazine.length();i++) magazineFrequency[magazine.charAt(i)-'a'] += 1;  
        
        for(int i=0;i<26;i++){
            if(ransomFrequency[i]!=0 && (ransomFrequency[i] > magazineFrequency[i])){
                result = false;
                break;
            }
        }
        
        return result;
    }
}
