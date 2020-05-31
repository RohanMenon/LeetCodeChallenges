/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

*/

/* Intuition: https://www.geeksforgeeks.org/edit-distance-dp-5/

A very interesting implementation of dynamic programming and memoization for time and space optimization. 
This, again, is completely new to me so lots to here. The first implementation I submitted is pure DP, 
which runs for O(3^n), where n is the number of sub problems. Evidently enough, this is a really bad solution 
due to the exponential run time. But its a good first effort*/


class Solution {    
    public int getMinValue(int a, int b, int c){
        if(a <= b && a <= c)
            return a;
        else if(b <= a && b <= c)
            return b;
        
        return c;
    }
    
     public int minimize(String word1, String word2, int len1, int len2){        
         if(len1 == 0)
             return len2;
        
         if(len2 == 0)
             return len1;
        
         if(word1.charAt(len1 - 1) == word2.charAt(len2 - 1))
             return minimize(word1, word2, len1 - 1, len2 - 1);
        
         return 1 + returnMinValue(minimize(word1, word2, len1, len2 - 1), 
                                   minimize(word1, word2, len1 - 1, len2),
                                   minimize(word1, word2, len1 - 1, len2 - 1));
     }
   
    public int minDistance(String word1, String word2) {
      return minimize(word1, word2, word1.length(), word2.length());
    }
}


/* Okay so hopefully the above solution was understandable. It's an intuitive approach. 
So following the previous comment, the optimized solution is as follows:-

We make use of memoization[][] to store answers to subproblems, keep solving them untill
we reach our problem i.e. start from index 0 of both strings and work our way till len1 and len2. 
Unlike the pure DP solution, here we avoid the additional overhead of recomputing each subproblem. 
This brings us to the time and space complexity. Both are O(len1 * len2)[since we are using the 2D array
to store solutions to the subproblems. */


class Solution {    
    public int getMinValue(int a, int b, int c){
        if(a <= b && a <= c)
            return a;
        else if(b <= a && b <= c)
            return b;
        
        return c;
    }
    
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] memoization = new int[len1 + 1][len2 + 1];
        
        for(int i=0;i<=len1;i++)
            for(int j=0;j<=len2;j++){
                if(i == 0)
                    memoization[i][j] = j;

                else if(j == 0)
                    memoization[i][j] = i;
                
                else if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    memoization[i][j] = memoization[i - 1][j - 1];
                
                else
                    memoization[i][j] = 1 + getMinValue(memoization[i][j-1],
                                                        memoization[i - 1][j], 
                                                        memoization[i - 1][j - 1]);
            }
        
        return memoization[len1][len2];
    }
}
