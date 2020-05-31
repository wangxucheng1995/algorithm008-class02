package com.leetcode.question120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int end = triangle.size();
        int res = findMinPath(triangle,0,0,end);
        return res;
    }

    private int findMinPath(List<List<Integer>> triangle,int index,int layers, int end) {
        if(layers==end) return 0;

        int left = findMinPath(triangle,index,layers+1,end);
        int right = findMinPath(triangle,index+1,layers+1,end);
        return triangle.get(layers).get(index)+Math.min(left,right);
    }
}
