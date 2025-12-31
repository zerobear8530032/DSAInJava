//1970. Last Day Where You Can Still Cross
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
//
//Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
//
//You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
//
//Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
//
//
//
//Example 1:
//
//
//Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
//Output: 2
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 2.
//Example 2:
//
//
//Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
//Output: 1
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 1.
//Example 3:
//
//
//Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
//Output: 3
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 3.
//
//
//Constraints:
//
//2 <= row, col <= 2 * 104
//4 <= row * col <= 2 * 104
//cells.length == row * col
//1 <= ri <= row
//1 <= ci <= col
//All the values of cells are unique.
package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class LastDayWhereYouCanStillCross_1970 {
//     approch :
//     we know each incresing day will remove one cell and s it goes one one day will come when
//    we cannot cross  so we can use binary search here by creting a grid from 0 to mid every time
//    we can check can we cross today if yes we can search is future days other wise past days
//    to check can we cross  here we use multi source BFS from first where the  cell that are  not flooded
//     Time Complexity: O((row * col) * log(row * col))
//     Space Complexity: O(row * col)

    public static int latestDayToCross(int row, int col, int[][] cells) {
        //  2 possible approches rn   
        // boolean[][] visited = new boolean[row][col];
        int res = 0;
        int s = 0;
        int e = cells.length - 1;
        int [][] grid= new int [row][col];
        while (s <= e) {
            int mid = s + (e - s) / 2;
            prepareGrid(grid,mid, cells, row, col);
            if (canCross(grid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    public static void prepareGrid(int [][] grid,int mid, int[][] cells, int row, int col) {
        for (int i = 0; i <cells.length; i++) {
            if(i<=mid){
                grid[cells[i][0]-1][cells[i][1]-1] = 1;
            }else{
                grid[cells[i][0]-1][cells[i][1]-1] = 0;
            }
        }
    }

    public static boolean canCross(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited= new boolean [grid.length][grid[0].length];
        for (int col = 0; col < grid[0].length; col++) {
            if(grid[0][col]==0){
                queue.add(new int [] {0,col});
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i =0;i<size;i++){
                int [] poped= queue.poll();
                int row= poped[0];
                int col= poped[1];
                if(grid[row][col]==1){
                    continue;
                }
                if(visited[row][col]){
                    continue;
                }else{
                    visited[row][col]=true;
                }
                if(row==grid.length-1){
                    return true;
                }
                // go up
                if(row-1>=0 && col>=0 && col<grid[0].length){
                    queue.add(new int [] {row-1,col});
                }
                // go down
                if(row+1<grid.length && col>=0 && col<grid[0].length){
                    queue.add(new int [] {row+1,col});
                }
                // go left
                if(col-1>=0 && row>=0 && row<grid.length){
                    queue.add(new int [] {row,col-1});
                }
                // go right
                if(col+1<grid[0].length && row>=0 && row<grid.length){
                    queue.add(new int [] {row,col+1});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][]  cells1 = {{1,1},{2,1},{1,2},{2,2}};
        int row1= 2,col1=2;
        int output1= 2;

        //Example 2:

        int [][]  cells2 = {{1,1},{1,2},{2,1},{2,2}};
        int row2= 2,col2=2;
        int output2= 1;

        //Example 3:

        int [][] cells3 = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
        int row3= 3, col3=3;
        int output3=3;

        int ans1 = latestDayToCross(row1,col1,cells1);
        int ans2 = latestDayToCross(row2,col2,cells2);
        int ans3 = latestDayToCross(row3,col3,cells3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}