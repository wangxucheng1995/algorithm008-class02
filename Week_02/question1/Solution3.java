package com.leetcode.question1;

import java.util.HashMap;

public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int answer = target - nums[i];
            if(map.containsKey(answer)){
                return new int[]{map.get(answer),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not find");
    }
}
