package com.leetcode.question283;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int i = 0;

        for (; j <nums.length;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        for(;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
