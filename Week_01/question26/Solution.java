package com.leetcode.question26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null)return 0;
        if(nums.length==1)return 1;
        int i = 0;
        int j;
        for (j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
