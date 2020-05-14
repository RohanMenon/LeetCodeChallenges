/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/


class Solution {
    public int majorityElement(int[] nums) {
        int frequency = nums.length/2;
        int max = 0;
        TreeMap<Integer, Integer> frequency_map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(frequency_map.get(nums[i]) == null)
                frequency_map.put(nums[i], 1);
            else
                frequency_map.put(nums[i], frequency_map.get(nums[i])+1);               
        }
        
        for(Map.Entry<Integer, Integer> entry : frequency_map.entrySet()){
            if(entry.getValue() > frequency)
                max = entry.getKey();
        }
        
        return max;
    }
}
