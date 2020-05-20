/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.

*/


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length, mid = 0;
        int l = 0, r = length-1;
        
        while(l < r){
            mid = l + (r-l)/2;
            
            if((mid%2 == 0 && nums[mid+1] == nums[mid]) || (mid%2 == 1 && nums[mid-1] == nums[mid]))
                l = mid + 1;
            else
                r = mid;
        }
        
        return nums[l];
    }
}
