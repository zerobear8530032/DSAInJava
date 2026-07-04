//3286. Find a Safe Walk Through a Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an m x n binary matrix grid and an integer health.
//
//You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
//
//You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
//
//Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
//
//Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.
//
//
//
//Example 1:
//
//Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1
//
//Output: true
//
//Explanation:
//
//The final cell can be reached safely by walking along the gray cells below.
//
//
//Example 2:
//
//Input: grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3
//
//Output: false
//
//Explanation:
//
//A minimum of 4 health points is needed to reach the final cell safely.
//
//
//Example 3:
//
//Input: grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5
//
//Output: true
//
//Explanation:
//
//The final cell can be reached safely by walking along the gray cells below.
//
//
//
//Any path that does not go through the cell (1, 1) is unsafe since your health will drop to 0 when reaching the final cell.
//
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 50
//2 <= m * n
//1 <= health <= m + n
//grid[i][j] is either 0 or 1.
package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindASafeWalkThroughAGrid_3286 {
    private static class Entry{
        int row;
        int col;
        int health;
        public Entry(int r, int c , int h){
            this.row=r;
            this.col=c;
            this.health=h;
        }
    }
//    approch : we can use a bfs , dfs where we can go every path and use track the
//    best health at each cell if we find a cell with better health we explore it further otherwise
//    we can stop progressing using that path  this allow us to use best path as visited cells also
//    time complexity : O(n*m)
//    space complexity : O(n*m)
//

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {


        Queue<Entry> queue= new LinkedList<>();
        int n = grid.size();
        int m = grid.get(0).size();
        int [][] best= new int [n][m];
        queue.add(new Entry(0,0,health));
        while(!queue.isEmpty()){
            Entry e= queue.poll();
            int row= e.row;
            int col= e.col;
            int h= e.health;
            if(row<0 || col<0 || row==n || col==m){
                continue;
            }
            int newHealth =h-grid.get(row).get(col);
            if(newHealth<=best[row][col]){
                continue;
            }
            best[row][col]=newHealth;

            queue.add(new Entry(row+1,col,newHealth));
            queue.add(new Entry(row-1,col,newHealth));
            queue.add(new Entry(row,col+1,newHealth));
            queue.add(new Entry(row,col-1,newHealth));

        }
        return best[n-1][m-1]>0;
    }
    public static void main(String[] args) {
        //Example 1:

        List<List<Integer>> grid1 = Arrays.asList(Arrays.asList(0,1,0,0,0),Arrays.asList(0,1,0,1,0),Arrays.asList(0,0,0,1,0));
        int health1 = 1;
        boolean output1= true;

        //Example 2:

        List<List<Integer>> grid2=  Arrays.asList(Arrays.asList(0,1,1,0,0,0),Arrays.asList(1,0,1,0,0,0),Arrays.asList(0,1,1,1,0,1), Arrays.asList(0,0,1,0,1,0));
        int health2 = 3;
        boolean output2= false;

        //Example 3:

        List<List<Integer>> grid3=  Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(1,0,1),Arrays.asList(1,1,1));
        int health3 = 5;
        boolean output3=true;

        boolean ans1=  findSafeWalk(grid1,health1);
        boolean ans2=  findSafeWalk(grid2,health2);
        boolean ans3=  findSafeWalk(grid3,health3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
