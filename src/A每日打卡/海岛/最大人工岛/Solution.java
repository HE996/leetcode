package A每日打卡.海岛.最大人工岛;

import java.util.ArrayList;

class Solution {
    int flag = 1;
    int res = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    public int largestIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    dfsLand(grid,i,j,flag++);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    dfsSea(grid,i,j,flag++);
                }
            }
        }
        return res;
    }

    public void dfsLand(int[][] grid,int i,int j,int p){
        if(i<0||j<0||grid.length<=i||grid[0].length<=j||grid[i][j]!=1) return;
        arr.set(p,arr.get(p)+1);
        grid[i][j]=p;
        dfsLand(grid,i-1,j,p);
        dfsLand(grid,i+1,j,p);
        dfsLand(grid,i,j-1,p);
        dfsLand(grid,i,j+1,p);
    }

    public void dfsSea(int[][] grid,int i,int j,int p){
        if(i<0||j<0||grid.length<=i||grid[0].length<=j||grid[i][j]!=0) return;
        int[] ints = new int[flag + 1];
        int area = 0;
        if(ints[grid[i-1][j]]++==0)area+=arr.get(grid[i-1][j]);
        if(ints[grid[i+1][j]]++==0)area+=arr.get(grid[i+1][j]);
        if(ints[grid[i][j-1]]++==0)area+=arr.get(grid[i][j-1]);
        if(ints[grid[i][j+1]]++==0)area+=arr.get(grid[i][j+1]);
        res = Math.max(res,area);
    }
}
