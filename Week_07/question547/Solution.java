package com.leetcode.question547;

public class Solution {
    public class Union{
        public int[] parents;
        public int count;

        public Union(int len){
            parents = new int[len];
            count = len;
            for(int i=0;i<len;i++){
                parents[i] = i;
            }
        }

        public int find(int j){
            while (parents[j]!=j){
                parents[j] = parents[parents[j]];
                j = parents[j];
            }
            return j;
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP==rootQ) return;
            parents[rootP] = rootQ;
            count--;
        }
    }

    public int findCircleNum(int[][] M) {
        int numStu = M.length;
        if (numStu==1)return 1;
        Union union = new Union(numStu);

        for(int i=0;i<numStu;i++){
            for(int j=i+1;j<numStu;j++){
                if(M[i][j]==1) union.union(i,j);
            }
        }

        return union.count;
    }
}
