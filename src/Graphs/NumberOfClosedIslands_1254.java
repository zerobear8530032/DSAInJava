//1254. Number of Closed Islands
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//
//Return the number of closed islands.
//
//
//
//Example 1:
//
//
//
//Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//Output: 2
//Explanation:
//Islands in gray are closed because they are completely surrounded by water (group of 1s).
//Example 2:
//
//
//
//Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//Output: 1
//Example 3:
//
//Input: grid = [[1,1,1,1,1,1,1],
//               [1,0,0,0,0,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,1,0,1,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
//Output: 2
//
//
//Constraints:
//
//1 <= grid.length, grid[0].length <= 100
//0 <= grid[i][j] <=1
package Graphs;

public class NumberOfClosedIslands_1254 {

    public  static int closedIsland(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==0){
                    boolean notClosed=isNotClosed(grid,i,j,visited);
                    if(!notClosed){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static boolean isNotClosed(int[] [] grid ,int r , int c , boolean [][] visited){
        if(r<0 || c<0 || r >=grid.length || c>=grid[0].length){
            return true;
        }
        if(grid[r][c]==1){
            return false;
        }
        if(visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        boolean left = isNotClosed(grid,r,c-1,visited);
        boolean right = isNotClosed(grid,r,c+1,visited);
        boolean up = isNotClosed(grid,r-1,c,visited);
        boolean down = isNotClosed(grid,r+1,c,visited);
        return left || right || up || down;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        int output1=2;

        //Example 2:

        int [][] grid2 = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        int output2= 1;

        //Example 3:

        int [][] grid3 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int output3=2;


        int ans1= closedIsland(grid1);
        int ans2= closedIsland(grid2);
        int ans3= closedIsland(grid3);

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
