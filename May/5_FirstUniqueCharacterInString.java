/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        if(s.length() == 1)
            return 0;
        
        if(s.length() == 0)
            return -1;
        
        int[] count = new int[26];
        
        for(int i=0;i<26;i++) count[i] = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count[c - 'a'] += 1; 
        }
        
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i) - 'a'] == 1){
                index = i;
                break;
            }
        }
        
        return index;
    }
}
