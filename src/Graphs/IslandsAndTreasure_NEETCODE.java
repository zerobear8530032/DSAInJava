//Islands and Treasure
//Solved
//You are given a
//m
//×
//n
//m×n 2D grid initialized with these three possible values:
//
//-1 - A water cell that can not be traversed.
//0 - A treasure chest.
//INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
//Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.
//
//Assume the grid can only be traversed up, down, left, or right.
//
//Modify the grid in-place.
//
//Example 1:
//
//Input: [
//  [2147483647,-1,0,2147483647],
//  [2147483647,2147483647,2147483647,-1],
//  [2147483647,-1,2147483647,-1],
//  [0,-1,2147483647,2147483647]
//]
//
//Output: [
//  [3,-1,0,1],
//  [2,2,1,-1],
//  [1,-1,2,-1],
//  [0,-1,3,4]
//]
//Example 2:
//
//Input: [
//  [0,-1],
//  [2147483647,2147483647]
//]
//
//Output: [
//  [0,-1],
//  [1,2]
//]
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 100
//grid[i][j] is one of {-1, 0, 2147483647}
package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure_NEETCODE {
//    approch :
//     use a dfs where we start from every treasure chest and go ahead  in every direction
//  if there is a block which is greater then our current steps we can update it and go ahead
//    other wise we will return because its closer to other chest or its a obstacle
//    time complexity : O(t*(n*m))
//    space complexity : O(n*m)
    public static void islandsAndTreasureDFS(int[][] grid) {
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==0){
                    dfsFill(grid,0,row,col);
                }
            }
        }
    }

    public static void dfsFill(int [][] grid,int distance, int row , int col){
        if(row<0 || col<0 || row==grid.length || col == grid[0].length){
            return ;
        }
        if(grid[row][col] ==-1 || grid[row][col]<distance){
            return ;
        }
        //  update the step:
        grid[row][col]= Math.min(grid[row][col],distance);
        // go up
        dfsFill(grid,distance+1,row-1,col);
        // go down
        dfsFill(grid,distance+1,row+1,col);
        // go left
        dfsFill(grid,distance+1,row,col-1);
        // go right
        dfsFill(grid,distance+1,row,col+1);
    }


    public static void islandsAndTreasureBFS(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c]==0){
                    queue.add(new int [] {r,c,0});
                }
            }
        }
        while(!queue.isEmpty()){
            int [] poped = queue.remove();
            int row = poped[0];
            int col = poped[1];
            int step = poped[2];
            if(row<0 || col<0 || row==grid.length || col==grid[0].length){continue;}
            if(grid[row][col]==-1 || (grid[row][col]<step)){continue;}
            grid[row][col]= Math.min(grid[row][col],step);
            // go up
            queue.add(new int [] {row-1,col,step+1});
            // go down
            queue.add(new int [] {row+1,col,step+1});
            // go left
            queue.add(new int [] {row,col-1,step+1});
            // go right
            queue.add(new int [] {row,col+1,step+1});

        }
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1= {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        int [][] output1=  {
                {3,-1,0,1},
                {2,2,1,-1},
                {1,-1,2,-1},
                {0,-1,3,4}
        };

        //Example 2:

        int [][] grid2 = {
                {0,-1},
                {2147483647,2147483647}
        };

        int [][] output2 = {
                {0,-1},
                {1,2}
        };

        islandsAndTreasureBFS(grid1);

    }
}
