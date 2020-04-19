package com.leetcode.question1;

import java.util.HashMap;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int j=0;j<nums.length;j++){
            int side = target-nums[j];
            if(map.containsKey(side)&&map.get(side)!=j){
                return new int[]{j,map.get(side)};
            }
        }
        throw new IllegalArgumentException("not find");
    }
}
