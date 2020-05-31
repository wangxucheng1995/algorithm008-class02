package com.leetcode.question120;

import java.util.List;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int end = triangle.size();
        int[][] memo = new int[end][end];
        return findMinPath(triangle,0,0,end,memo);
    }

    private int findMinPath(List<List<Integer>> triangle,int index,int layers, int end,int[][]memo) {
        if(layers==end-1) {
            memo[layers][index] = triangle.get(layers).get(index);
            return memo[layers][index];
        }

        int left,right;
        if(memo[layers+1][index]==0) memo[layers+1][index] = findMinPath(triangle,index,layers+1,end,memo);
        left = memo[layers+1][index];

        if(memo[layers+1][index+1]==0) memo[layers+1][index+1] = findMinPath(triangle,index+1,layers+1,end,memo);
        right = memo[layers+1][index+1];

        return triangle.get(layers).get(index)+Math.min(left,right);
    }
}
