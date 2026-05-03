//1559. Detect Cycles in 2D Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
//
//A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
//
//Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
//
//Return true if any cycle of the same value exists in grid, otherwise, return false.
//
// 
//
//Example 1:
//
//
//
//Input: grid = [['a','a','a','a'],['a','b','b','a'],['a','b','b','a'],['a','a','a','a']]
//Output: true
//Explanation: There are two valid cycles shown in different colors in the image below:
//
//Example 2:
//
//
//
//Input: grid = [['c','c','c','a'],['c','d','c','c'],['c','c','e','c'],['f','c','c','c']]
//Output: true
//Explanation: There is only one valid cycle highlighted in the image below:
//
//Example 3:
//
//
//
//Input: grid = [['a','b','b'],['b','z','b'],['b','b','a']]
//Output: false
package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCyclesIn2DGrid_1559 {
//    simple bfs :
//    time complexity : O(n)
//    space complexity : O(n)
    public  static boolean containsCycle(char[][] grid) {
        boolean [][] visited  = new boolean [grid.length][grid[0].length];

        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(hasCycle(grid,visited,grid[i][j], i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasCycle(char [][] grid, boolean [][] visited, char ch, int r, int c){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{r,c,-1,-1});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int prow = cur[2];
            int pcol = cur[3];

            // UP
            if(row-1 >=0 && grid[row-1][col]==ch){
                if(!visited[row-1][col]){
                    visited[row-1][col] = true;
                    queue.add(new int[]{row-1,col,row,col});
                } else if(row-1 != prow || col != pcol){
                    return true;
                }
            }

            // DOWN
            if(row+1 < grid.length && grid[row+1][col]==ch){
                if(!visited[row+1][col]){
                    visited[row+1][col] = true;
                    queue.add(new int[]{row+1,col,row,col});
                } else if(row+1 != prow || col != pcol){
                    return true;
                }
            }

            // LEFT
            if(col-1 >=0 && grid[row][col-1]==ch){
                if(!visited[row][col-1]){
                    visited[row][col-1] = true;
                    queue.add(new int[]{row,col-1,row,col});
                } else if(row != prow || col-1 != pcol){
                    return true;
                }
            }

            // RIGHT
            if(col+1 < grid[0].length && grid[row][col+1]==ch){
                if(!visited[row][col+1]){
                    visited[row][col+1] = true;
                    queue.add(new int[]{row,col+1,row,col});
                } else if(row != prow || col+1 != pcol){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        char [][] grid1 = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        boolean output1= true;
        
        //Example 2:

        char [][] grid2 = {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
        boolean output2= true;

        //Example 3:

        char [][] grid3 = {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
        boolean output3=false;

        boolean ans1= containsCycle(grid1);
        boolean ans2= containsCycle(grid2);
        boolean ans3= containsCycle(grid3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }


    }
}
