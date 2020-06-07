package com.leetcode.question433;

import java.util.*;

public class Solution {
    int minStepCount  = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        DFS(new HashSet<String>(),0,start,end,bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void DFS(HashSet<String> path, int stepCount, String current, String end, String[] bank){
        if (current.equals(end))
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str:bank){
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i)) {
                    diff += 1;
                    if (diff > 1) break;
                }
            }
            if(diff==1&&!path.contains(str)){
                path.add(str);
                DFS(path,stepCount+1,str,end,bank);
                path.remove(str);
            }
        }
    }
}
