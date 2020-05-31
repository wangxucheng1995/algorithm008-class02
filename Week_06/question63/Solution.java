package com.leetcode.question63;

import java.util.LinkedList;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1) return 0;
        int[][] path = new int[length][width];
        if(width==1||length==1){
            for(int x=0;x<=length-1;x++){
                for (int y=0;y<=width-1;y++){
                    if(obstacleGrid[x][y]==1) return 0;
                }
            }
            return 1;
        }

        for(int j=0;j<=width-1;j++) {
            if(obstacleGrid[0][j]==0) path[0][j] = 1;
            else {
                path[0][j] = 0;
                break;
            }
        }
        for (int i=0;i<=length-1;i++){
            if(obstacleGrid[i][0]==0) path[i][0] = 1;
            else {
                path[i][0] = 0;
                break;
            }
        }
        for(int i=1;i<=length-1;i++){
            for (int j=1;j<=width-1;j++){
                if (obstacleGrid[i][j]==0) path[i][j] = path[i][j-1]+path[i-1][j];
                else path[i][j] = 0;
            }
        }
        return path[length-1][width-1];
    }
}
