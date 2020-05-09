/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

*/

class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        
        while(l <= r){
            long mid = (l+r)/2;
            
            if(mid * mid == num)
                return true;
            
            if(mid * mid <num)
                l = mid + 1;
            
            else
                r = mid-1;
        }
        
        return false;
    }
}
