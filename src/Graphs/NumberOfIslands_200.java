//200. Number of Islands
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
//Example 1:
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//Example 2:
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 300
//grid[i][j] is '0' or '1'.
//
package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NumberOfIslands_200 {
    public  static int numIslandsBFS(char[][] grid) {
        int res=0;
        char [][] dummy= copy(grid);
        for(int r =0;r<dummy.length;r++){
            for(int c=0;c<dummy[r].length;c++){
                if(dummy[r][c]=='1'){
                    bfs(dummy,r,c);
                    res++;
                }
            }
        }
        return res;
    }

    public static char [][] copy(char [][] grid){
        char [][] dummy = new char [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dummy[i][j]=grid[i][j];
            }
        }
        return dummy;
    }

    public static void bfs(char[][] grid, int r , int c){
        ArrayDeque<int []> queue = new ArrayDeque<>();
        queue.add(new int [] {r,c});
        while(!queue.isEmpty()){
            int [] poped= queue.remove();
            int row = poped[0];
            int col = poped[1];
            if( row<0 || row==grid.length || col<0 || col == grid[0].length){continue;}
            if( grid[row][col]!='1'){continue;}
            grid[row][col]='E';
            queue.add(new int []{row+1,col});
            queue.add(new int []{row-1,col});
            queue.add(new int []{row,col-1});
            queue.add(new int []{row,col+1});
        }
    }

    public static int numIslandsDFS(char[][] grid) {
        int res=0;
        char [][] dummy= copy(grid);
        for(int r =0;r<dummy.length;r++){
            for(int c=0;c<dummy[r].length;c++){
                if(dummy[r][c]=='1'){
                    dfs(dummy,r,c);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int r , int c){
        if(r<0 || c<0 || r==grid.length || c==grid[0].length){return ;}
        if(grid[r][c]!='1'){return ;}

        grid[r][c]='E';
        // go up :
        dfs(grid,r-1,c);
        // go down :
        dfs(grid,r+1,c);
        // go left :
        dfs(grid,r,c-1);
        // go right :
        dfs(grid,r,c+1);
    }

    public static void main(String[] args) {
        //Example 1:

        char [][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int output1= 1;

        //Example 2:

        char [][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int output2= 3;


        System.out.println("DFS Approch:");
        int ans1 = numIslandsDFS(grid1);
        int ans2 = numIslandsDFS(grid2);
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
        ans1 = numIslandsBFS(grid1);
        ans2 = numIslandsBFS(grid2);
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
