package com.leetcode.question279;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int len = queue.size();
        int count = 0;
        int res = 0;
        boolean[] used = new boolean[n+1];
        used[n] = true;
        while (!queue.isEmpty()){
            int temp = queue.remove();
            count++;
            if(temp==0){
                return res;
            }
            for(int i=1;temp-i*i>=0;i++){
                if(!used[temp-i*i]){
                    queue.add(temp-i*i);
                    used[temp-i*i]=true;
                }
            }
            if(count==len){
                len = queue.size();
                count = 0;
                res++;
            }
        }
        return res;
    }
}
