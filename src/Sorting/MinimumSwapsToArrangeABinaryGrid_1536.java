//1536. Minimum Swaps to Arrange a Binary Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
//
//A grid is said to be valid if all the cells above the main diagonal are zeros.
//
//Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
//
//The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).
//
//
//
//Example 1:
//
//
//Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
//Output: 3
//Example 2:
//
//
//Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
//Output: -1
//Explanation: All rows are similar, swaps have no effect on the grid.
//Example 3:
//
//
//Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
//Output: 0
//
//
//Constraints:
//
//n == grid.length == grid[i].length
//1 <= n <= 200
//grid[i][j] is either 0 or 1
package Sorting;

public class MinimumSwapsToArrangeABinaryGrid_1536 {

    public static int minSwaps(int[][] grid) {
        int [] rowcount= new int [grid.length];
        int n = grid.length;
        for(int i=0;i<grid.length;i++){
            rowcount[i]=countConsecutiveZeroes(grid[i]);
        }
        int count =0;
        for(int i =0;i<n;i++){
            int required = n-i-1;
            int j =i;
            while(j<n && rowcount[j]<required){
                j++;
            }
            if(j==n){return -1;}
            while(j>i ){
                int temp = rowcount[j];
                rowcount[j] = rowcount[j - 1];
                rowcount[j - 1] = temp;
                j--;
                count++;
            }
        }
        return count;
    }


    public static int countConsecutiveZeroes(int [] arr){
        int count =0;
        for(int i =arr.length-1;i>=0;i--){
            if(arr[i]!=0){
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {

        //Example 1:

        int [][] grid1 = {{0,0,1},{1,1,0},{1,0,0}};
        int output1= 3;

        //Example 2:

        int [][] grid2 = {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};
        int output2= -1;

        //Example 3:

        int [][] grid3 = {{1,0,0},{1,1,0},{1,1,1}};
        int output3= 0;

        int ans1= minSwaps(grid1);
        int ans2= minSwaps(grid2);
        int ans3= minSwaps(grid3);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}
