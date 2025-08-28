//3446. Sort Matrix by Diagonals
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an n x n square matrix of integers grid. Return the matrix such that:
//
//The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
//The diagonals in the top-right triangle are sorted in non-decreasing order.
//
//
//Example 1:
//
//Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
//
//Output: [[8,2,3],[9,6,7],[4,5,1]]
//
//Explanation:
//
//
//
//The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:
//
//[1, 8, 6] becomes [8, 6, 1].
//[9, 5] and [4] remain unchanged.
//The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:
//
//[7, 2] becomes [2, 7].
//[3] remains unchanged.
//Example 2:
//
//Input: grid = [[0,1],[1,2]]
//
//Output: [[2,1],[1,0]]
//
//Explanation:
//
//
//
//The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.
//
//Example 3:
//
//Input: grid = [[1]]
//
//Output: [[1]]
//
//Explanation:
//
//Diagonals with exactly one element are already in order, so no changes are needed.
//
//
//
//Constraints:
//
//grid.length == grid[i].length == n
//1 <= n <= 10
//-105 <= grid[i][j] <= 105

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixByDiagonals_3446 {
    //  implement brute force
//     approch :
//    get all diagonals and sort them and fill the diagonal with sorted elements
//    time complexity : (n+n-1)* n log n
//    space complexity : (n+n)
    public static  int[][] sortMatrix(int[][] grid) {
        int row =grid.length-1;
        int col =0;
        while(row>=0){
            List<Integer> diagonal=getDiagonal(grid,row,col);
            Collections.sort(diagonal, Collections.reverseOrder());
            // System.out.println(diagonal);
            setDiagonal(grid,diagonal,row,col);
            row--;
        }
        row=0;
        col=1;
        while(col<grid[row].length){
            List<Integer> diagonal=getDiagonal(grid,row,col);
            Collections.sort(diagonal);
            // System.out.println(diagonal);
            setDiagonal(grid,diagonal,row,col);
            col++;
        }
        return grid;
    }


    public static void setDiagonal(int [][] matrix, List<Integer> elements, int r, int c){
        int i =0;
        while(r<matrix.length && c < matrix[0].length){
            matrix[r][c] = elements.get(i);
            r++;
            c++;
            i++;
        }
    }
    public static List<Integer> getDiagonal(int [][] matrix, int r, int c){
        List<Integer> res = new ArrayList<>();
        while(r<matrix.length && c < matrix[0].length){
            res.add(matrix[r][c]);
            r++;
            c++;
        }
        return res;
    }


    public static  boolean check(int [][] ans, int [][] output){
        if(ans.length!=output.length){
            return false;
        }
        for(int i =0;i<ans.length;i++){
            if(ans[i].length!=output.length){
                return false;
            }
            for(int j =0;j<ans[i].length;j++){
                if(ans[i][j]!=output[i][j]){return false;}
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] grid1= {{1,7,3},{9,8,2},{4,5,6}};
        int [][]output1= {{8,2,3},{9,6,7},{4,5,1}};

        //Example 2:

        int [][] grid2= {{0,1},{1,2}};
        int [][]output2= {{2,1},{1,0}};

        //Example 3:

        int [][] grid3= {{1}};
        int [][]output3= {{1}};

        int [][]ans1=sortMatrix(grid1);
        int [][]ans2=sortMatrix(grid2);
        int [][]ans3=sortMatrix(grid3);

        if(check(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(check(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(check(output3,ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }



    }
}
