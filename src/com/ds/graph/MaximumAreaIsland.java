package com.ds.graph;

public class MaximumAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<row; i++) {
            for(int j=0;j<col; j++) {
                if(grid[i][j] ==1)
                    maxArea = Math.max(maxArea, getArea(i, j, grid));
            }
        }
        return maxArea;
    }

    public int getArea(int i, int j, int[][] grid) {
        if(i<0 || j <0 || i >= grid.length || j>= grid[0].length || grid[i][j] <=0) {
            return 0;
        }
        grid[i][j] = -1; //mark it visited
        int left = getArea(i, j-1, grid);
        int right = getArea(i, j+1, grid);
        int up = getArea(i-1, j, grid);
        int down = getArea(i+1, j, grid);
        int total = 1 + left + right + up +down;
        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{
        0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},{
        0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},{
        0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        MaximumAreaIsland maximumAreaIsland = new MaximumAreaIsland();
        int area = maximumAreaIsland.maxAreaOfIsland(grid);
        System.out.println(area);
    }
}
