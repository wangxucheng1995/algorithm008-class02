package com.leetcode.question200;

public class Solution {
    public int numIslands(char[][] grid) {
        int x = grid.length;
        if (x == 0) return 0;
        int y = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    islandNum++;
                    DFS(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    private void DFS(char[][] grid, int i, int j) {
        int x = grid.length;
        int y = grid[0].length;
        if(i<0||i>=x) return;
        if(j<0||j>=y) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';
        DFS(grid,i-1,j);
        DFS(grid,i+1,j);
        DFS(grid,i,j-1);
        DFS(grid,i,j+1);
    }
}
