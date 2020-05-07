/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/


class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum  = 0, max_intermediate = 0;
        int size = nums.length;
        boolean flag = false;
        
        for(int i=0;i<size;i++){    //additional check for all negative input        
            if(nums[i]>0){
                flag = true;
                break;
            }
        }
        
        if(flag){
            for(int i=0;i<size;i++){
                max_intermediate += nums[i];
                if(max_intermediate < 0)
                    max_intermediate = 0;

                else if(max_sum < max_intermediate)
                    max_sum = max_intermediate;
              }
        }
        
        else{
            max_sum = nums[0];
            for(int i=1;i<size;i++){
                if(max_sum < nums[i])
                    max_sum = nums[i];
            }
        }
        
        return max_sum;
    }
}
