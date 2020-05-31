package com.leetcode.question64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = 0;
        int col = 0;
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                memo[i][j] = -1;
            }
        }
        return findMinPath(grid,row,col,memo);
    }

    private int findMinPath(int[][] grid, int row, int col,int[][] memo) {
        if(col==grid[0].length-1&&row==grid.length-1) {
            memo[row][col] = grid[row][col];
            return memo[row][col];
        }

        if(col==grid[0].length-1){
            if(memo[row+1][col]==-1) memo[row+1][col]=findMinPath(grid,row+1,col,memo);
            memo[row][col] = memo[row+1][col] + grid[row][col];
            return memo[row][col];
        }

        if(row==grid.length-1){
            if(memo[row][col+1]==-1) memo[row][col+1]=findMinPath(grid,row,col+1,memo);
            memo[row][col] = memo[row][col+1] + grid[row][col];
            return memo[row][col];
        }

        if(memo[row][col]==-1) memo[row][col] = Math.min(findMinPath(grid,row+1,col,memo), findMinPath(grid,row,col+1,memo))+grid[row][col];
        return memo[row][col];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
