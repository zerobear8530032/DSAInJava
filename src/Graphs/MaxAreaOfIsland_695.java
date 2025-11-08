//695. Max Area of Island
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//The area of an island is the number of cells with a value 1 in the island.
//
//Return the maximum area of an island in grid. If there is no island, return 0.
//
//
//
//Example 1:
//
//
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-directionally.
//Example 2:
//
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 50
//grid[i][j] is either 0 or 1.
package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_695 {
    public static int maxAreaOfIslandDFS(int[][] grid) {
        int maxArea=0;
        int [][] dummy= copy(grid);
        for(int r =0;r<dummy.length;r++){
            for(int c=0;c<dummy[r].length;c++){
                if(dummy[r][c]==1){
                    int area= dfs(dummy,r,c);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    public static int [][] copy(int [][] grid){
        int [][] dummy = new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dummy[i][j]=grid[i][j];
            }
        }
        return dummy;
    }
    public static int dfs(int[][] grid, int r , int c){
        if(r<0 || c<0 || r==grid.length || c==grid[0].length){return 0;}
        if(grid[r][c]!=1){return 0;}
        grid[r][c]=0;
        // go up :
        int up=dfs(grid,r-1,c);
        // go down :
        int down=dfs(grid,r+1,c);
        // go left :
        int left=dfs(grid,r,c-1);
        // go right :
        int right=dfs(grid,r,c+1);
        return up+down+left+right+1;
    }
    public static int maxAreaOfIslandBFS(int[][] grid) {
        int maxArea=0;
        int [][] dummy = copy(grid);
        for(int r =0;r<dummy.length;r++){
            for(int c=0;c<dummy[r].length;c++){
                if(dummy[r][c]==1){
                    int area= bfs(dummy,r,c);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    public static int bfs(int[][] grid, int r , int c){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        int area=0;
        while(!queue.isEmpty()){
            int []poped= queue.remove();
            int row= poped[0];
            int col= poped[1];
            if(row<0 || col<0 || row==grid.length || col==grid[0].length){
                continue;
            }
            if(grid[row][col]!=1){continue;}
            grid[row][col]=0;
            area++;
            queue.add(new int []{row-1,col});
            queue.add(new int []{row+1,col});
            queue.add(new int []{row,col-1});
            queue.add(new int []{row,col+1});
        }
        return area;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int output1= 6;

        //Example 2:

        int [][] grid2 = {{0,0,0,0,0,0,0,0}};
        int output2= 0;

        int ans1 = maxAreaOfIslandDFS(grid1);
        int ans2 = maxAreaOfIslandDFS(grid2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }

        System.out.println("BFS Approch:");
        ans1 = maxAreaOfIslandBFS(grid1);
        ans2 = maxAreaOfIslandBFS(grid2);
        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
