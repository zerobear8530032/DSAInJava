//2536. Increment Submatrices by One
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
//
//You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
//
//Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.
//Return the matrix mat after performing every query.
//
//
//
//Example 1:
//
//
//Input: n = 3, queries = [[1,1,2,2],[0,0,1,1]]
//Output: [[1,1,0],[1,2,1],[0,1,1]]
//Explanation: The diagram above shows the initial matrix, the matrix after the first query, and the matrix after the second query.
//- In the first query, we add 1 to every element in the submatrix with the top left corner (1, 1) and bottom right corner (2, 2).
//- In the second query, we add 1 to every element in the submatrix with the top left corner (0, 0) and bottom right corner (1, 1).
//Example 2:
//
//
//Input: n = 2, queries = [[0,0,1,1]]
//Output: [[1,1],[1,1]]
//Explanation: The diagram above shows the initial matrix and the matrix after the first query.
//- In the first query we add 1 to every element in the matrix.
//
//
//Constraints:
//
//1 <= n <= 500
//1 <= queries.length <= 104
//0 <= row1i <= row2i < n
//0 <= col1i <= col2i < n
package Arrays;

import java.util.Arrays;

public class IncrementSubmatricesByOne_2536 {
//  use difference array technique:
//    approch : for every from r1 to r2 we can apply difference array technique in 2 d array
//    and take the prefix sum at the end we have our answer;
//    time complexity : O(q + (n*m))
//    space complexity : O((n*m))
    public static int[][] rangeAddQueries(int n, int[][] queries) {
    int [][] res= new int [n][n];
    for(int [] query:queries) {
        int r1 = query[0];
        int c1 = query[1];
        int r2 = query[2];
        int c2 = query[3];
        for(int r=r1;r<=r2;r++){
            res[r][c1]+=1;
            if(c2+1<n){
                res[r][c2+1]+= -1;
            }
        }
    }
    for(int i=0;i<n;i++){
        int sum =0;
        for(int j=0;j<n;j++){
            sum+= res[i][j];
            res[i][j]=sum;
        }
    }

    return res;
}
    public static boolean check(int [][] m1,int [][] m2){
        if(m1.length!=m2.length){return false;}
        for(int i=0;i<m1.length;i++){
            if(!Arrays.equals(m1[i],m2[i])){
                return  false;
            }
        }
        return true;
    }

    public static String printImage(int [][]img) {

        StringBuilder str = new StringBuilder("[");
        for(int i =0;i<img.length;i++) {
            str.append(Arrays.toString(img[i]));
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        //Example 1:

        int n1 = 3;
        int [][] queries1 = {{1,1,2,2},{0,0,1,1}};
        int [][] output1= {{1,1,0},{1,2,1},{0,1,1}};

        //Example 2:

        int n2 = 2;
        int [][] queries2 = {{0,0,1,1}};
        int [][] output2= {{1,1},{1,1}};

        int [][] ans1=rangeAddQueries(n1,queries1);
        int [][] ans2=rangeAddQueries(n2,queries2);


        if(check(output1, ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ printImage(output1));
            System.out.println("Your Answer :"+ printImage(ans1));
        }
        if(check(output2, ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ printImage(output2));
            System.out.println("Your Answer :"+printImage(ans2) );
        }




    }
}
