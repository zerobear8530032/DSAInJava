//1582. Special Positions in a Binary Matrix
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an m x n binary matrix mat, return the number of special positions in mat.
//
//A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
//
//
//
//Example 1:
//
//
//Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
//Output: 1
//Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
//Example 2:
//
//
//Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
//Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
//
//
//Constraints:
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 100
//mat[i][j] is either 0 or 1.
package Arrays;

public class SpecialPositionsInABinaryMatrix_1582 {
//    approch : we can find frequency of 1 in each row and col
//    then we can go throught each row and col and find out the row / col having exactly 1 frequency of 1
//    and count such i,j s
//    time complexity : O(m*n)
//    space complexity : O(m+n)
    public static int numSpecial(int[][] mat) {
        int res=0;
        int [] rows= new int [mat.length];
        int [] cols= new int [mat[0].length];
        for(int i =0;i<mat.length;i++){
            int c=0;
            for(int j =0;j<mat[i].length;j++){
                if(mat[i][j]==1){c++;}
            }
            rows[i]=c;
        }

        for(int i =0;i<mat[0].length;i++){
            int c=0;
            for(int j =0;j<mat.length;j++){
                if(mat[j][i]==1){c++;}
            }
            cols[i]=c;
        }
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[i].length;j++){
                if(mat[i][j]==1 && rows[i]==1 && cols[j]==1){res++;}
            }
        }


        return res;
    }
    public static boolean checkRow(int [][] mat, int row , int col){
        int count=0;
        for(int i =0;i<mat.length;i++){
            if(mat[i][col]==1){count++;}
            if(count>1){return false;}
        }
        return count==1;
    }
    public static boolean checkCol(int [][] mat, int row , int col){
        int count=0;
        for(int i =0;i<mat[row].length;i++){
            if(mat[row][i]==1){count++;}
            if(count>1){return false;}
        }
        return count==1;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] mat1 = {{1,0,0},{0,0,1},{1,0,0}};
        int output1= 1;

        //Example 2:

        int [][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
        int output2= 3;

        int ans1 = numSpecial(mat1);
        int ans2 = numSpecial(mat2);

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
    }
}
