
//3459. Length of Longest V-Shaped Diagonal Segment
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.
//
//A V-shaped diagonal segment is defined as:
//
//The segment starts with 1.
//The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
//The segment:
//Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
//Continues the sequence in the same diagonal direction.
//Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.
//
//
//Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.
//
//
//
//Example 1:
//
//Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
//
//Output: 5
//
//Explanation:
//
//
//
//The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn at (2,4), and continues as (3,3) → (4,2).
//
//Example 2:
//
//Input: grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
//
//Output: 4
//
//Explanation:
//
//
//
//The longest V-shaped diagonal segment has a length of 4 and follows these coordinates: (2,3) → (3,2), takes a 90-degree clockwise turn at (3,2), and continues as (2,1) → (1,0).
//
//Example 3:
//
//Input: grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]
//
//Output: 5
//
//Explanation:
//
//
//
//The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,0) → (1,1) → (2,2) → (3,3) → (4,4).
//
//Example 4:
//
//Input: grid = [[1]]
//
//Output: 1
//
//Explanation:
//
//The longest V-shaped diagonal segment has a length of 1 and follows these coordinates: (0,0).
//
//
//
//Constraints:
//
//n == grid.length
//m == grid[i].length
//1 <= n, m <= 500
//grid[i][j] is either 0, 1 or 2.

package Arrays;

import java.util.HashSet;

public class LengthOfLongestV_ShapedDiagonalSegment_3459 {
        public static int lenOfVDiagonal(int[][] grid) {
            // go through entire array at once
            // get a 1 and just try to check its diagonals
            // if any is present check its directions
            // and get the max of each diagonals
            int maxAns=0;
            HashSet<String> visited = new HashSet<>();
            for(int r=0;r<grid.length;r++){
                for(int c=0;c<grid[r].length;c++){
                    if(grid[r][c]==1){
                        int BL= dfsBL(grid,2,r+1,c-1,true,visited)+1;
                        int BR= dfsBR(grid,2,r+1,c+1,true,visited)+1;
                        int TL= dfsTL(grid,2,r-1,c-1,true,visited)+1;
                        int TR= dfsTR(grid,2,r-1,c+1,true,visited)+1;
                        int max = Math.max(Math.max(BL,BR),Math.max(TL,TR));
                        maxAns = Math.max(max,maxAns);
                    }
                }
            }
            return maxAns;
        }
        // checks bottom left diagonals
        public static int dfsBL(int [][] grid, int nextElement, int r, int c,boolean turn ,HashSet<String> visited ){
            if(r>=grid.length || c <0 || grid[r][c]!=nextElement){
                if(turn){
                    int TL=dfsTL(grid,nextElement,r-2,c,false);
                    int BR=dfsBR(grid,nextElement,r,c+2,false);
                    return Math.max(BR,TL);
                }
                return 0;
            }
            if(nextElement == 2){
                int TL=dfsTL(grid,nextElement,r-2,c,false);
                int BR=dfsBR(grid,nextElement,r,c+2,false);
                int max=Math.max(BR,TL);
                return Math.max(max,dfsBL(grid,0,r+1,c-1,turn))+1;
            }else{
                int TL=dfsTL(grid,nextElement,r-2,c,false);
                int BR=dfsBR(grid,nextElement,r,c+2,false);
                int max=Math.max(BR,TL);
                return Math.max(max,dfsBL(grid,2,r+1,c-1,turn))+1;
            }
        }
        // checks bottom right diagonals
        public static int dfsBR(int [][] grid, int nextElement, int r, int c,boolean turn,HashSet<String> visited ){
            if(r>=grid.length || c>=grid[0].length || grid[r][c]!=nextElement){
                if(turn){
                    int BL = dfsBL(grid,nextElement,r,c-2,false);
                    int TR= dfsTR(grid,nextElement,r-2,c,false);
                    return Math.max(BL,TR);
                }
                return 0;
            }
            if(nextElement == 2){
                int BL = dfsBL(grid,nextElement,r,c-2,false);
                int TR= dfsTR(grid,nextElement,r-2,c,false);
                int max = Math.max(BL,TR);
                return Math.max(max,dfsBR(grid,0,r+1,c+1,turn))+1;
            }else{
                int BL = dfsBL(grid,nextElement,r,c-2,false);
                int TR= dfsTR(grid,nextElement,r-2,c,false);
                int max = Math.max(BL,TR);
                visited.add(r+""+c);
                return Math.max(max,dfsBR(grid,2,r+1,c+1,turn))+1;
            }
        }
        // checks top left diagonals
        public static int dfsTL(int [][] grid, int nextElement, int r, int c,boolean turn,HashSet<String> visited ){
            if(visited.contains(r+""+c)){
                return 0;
            }
            if(r<0 || c<0 || grid[r][c]!=nextElement){
                if(turn){
                    int TR = dfsTR(grid,nextElement,r,c+2,false,visited);
                    int BL = dfsBL(grid,nextElement,r+2,c,false,visited);
                    return Math.max(TR,BL);
                }
                return 0;
            }
            if(nextElement == 2){
                int TR = dfsTR(grid,nextElement,r,c+2,false,visited);
                int BL = dfsBL(grid,nextElement,r+2,c,false,visited);
                int max = Math.max(TR,BL);
                visited.add(r+""+c);
                return Math.max(max,dfsTL(grid,0,r-1,c-1,turn,visited))+1;
            }else{
                int TR = dfsTR(grid,nextElement,r,c+2,false,visited);
                int BL = dfsBL(grid,nextElement,r+2,c,false,visited);
                int max = Math.max(TR,BL);
                visited.add(r+""+c);
                return Math.max(max,dfsTL(grid,2,r-1,c-1,turn,visited))+1;
            }
        }
        // checks top right diagonals
        public static int dfsTR(int [][] grid, int nextElement, int r, int c,boolean turn,HashSet<String> visited ){
            if(visited.contains(r+""+c)){
                return 0;
            }
            if(r<0 || c>=grid[0].length || grid[r][c]!=nextElement){
                if(turn){
                    int TL= dfsTL(grid,nextElement,r,c-2,false,visited);
                    int BR= dfsBR(grid,nextElement,r+2,c,false,visited);
                    return Math.max(TL,BR);
                }
                return 0;
            }
            if(nextElement == 2){
                int TL= dfsTL(grid,nextElement,r,c-2,false,visited);
                int BR= dfsBR(grid,nextElement,r+2,c,false,visited);
                int max= Math.max(TL,BR);
                visited.add(r+""+c);
                return Math.max(max,dfsTR(grid,0,r-1,c+1,turn,visited))+1;
            }else{
                int TL= dfsTL(grid,nextElement,r,c-2,false,visited);
                int BR= dfsBR(grid,nextElement,r+2,c,false,visited);
                int max= Math.max(TL,BR);
                visited.add(r+""+c);
                return Math.max(max,dfsTR(grid,2,r-1,c+1,turn,visited))+1;
            }
        }


    public static void main(String[] args) {

        //Example 1:

        int [][] grid1 ={{2,2,1,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}};
        int output1=5;

        //Example 2:

        int [][] grid2 = {{2,2,2,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}};
        int output2=4;

        //Example 3:

        int [][] grid3= {{1,2,2,2,2},{2,2,2,2,0},{2,0,0,0,0},{0,0,2,2,2},{2,0,0,2,0}};
        int output3=5;

        //Example 4:

        int [][] grid4 = {{1}};
        int output4=1;

        int ans1=lenOfVDiagonal(grid1);
        int ans2=lenOfVDiagonal(grid2);
        int ans3=lenOfVDiagonal(grid3);
        int ans4=lenOfVDiagonal(grid4);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4==ans4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }

    }
}
