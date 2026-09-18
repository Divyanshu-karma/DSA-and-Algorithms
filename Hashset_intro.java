// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

// Example 1:

// Input: nums = [1,2,3,1]

// Output: true

// Explanation:

// The element 1 occurs at the indices 0 and 3.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        // for (int i=0;i<nums.length;i++){
        int i=0;
        while(i<nums.length){
            if(hs.add(nums[i])){
                i++;
            }
            else{
                return true;
            }
        }
        return false;}}
