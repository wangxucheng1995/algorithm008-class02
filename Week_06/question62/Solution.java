package com.leetcode.question62;

public class Solution {
    public int uniquePaths(int m, int n) {
        if(n==1)return 1;
        if(m==1)return 1;

        int[][] path = new int[n][m];
        //初始化将最后一行设为1
        for(int j=0;j<=m-1;j++){
            path[n-1][j] = 1;
        }
        for (int i=0;i<=n-1;i++){
            path[i][m-1] = 1;
        }
        for(int i=n-2;i>=0;i--){
            for (int j=m-2;j>=0;j--){
                path[i][j] = path[i][j+1]+path[i+1][j];
            }
        }

        return path[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uniquePaths(7,3);
    }
}
