package com.leetcode.question120;

import java.util.List;

public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] memo = new int[len][len];
        int layer = len-1; //最后一层
        for(int i=0;i<len;i++){
            memo[layer][i] = triangle.get(layer).get(i);
        }
        layer--;
        len--;

        while(layer>=0){
            for(int j=0;j<len;j++){
                memo[layer][j] = Math.min(memo[layer+1][j],memo[layer+1][j+1])+triangle.get(layer).get(j);
            }
            len--;
            layer--;
        }
        return memo[0][0];
    }
}
