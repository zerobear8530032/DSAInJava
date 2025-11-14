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

public class IncrementSubmatricesByOne_2536 {
//  use difference array technique;
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] res= new int [n][n];
        for(int [] query:queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            int row = r1;
            int col = c1;
            while (row <= r2 && col <= c2) {
                res[row][col] += 1;
                if (r2 + 1 < n) {
                    res[r2 + 1][col] += -1;
                }
                if (c2 + 1 < n) {
                    res[row][c2 + 1] += -1;
                }
                row++;
                col++;
            }
        }
        int row=0;
        int col=0;
        while(row<n && col<n){
            int rowSum=0;
            for(int r=row;r<n;r++){
                rowSum+= res[r][col];
                res[r][col]=rowSum;
            }
            int colSum=0;
            for(int c=col;c<n;c++){
                colSum+= res[row][c];
                res[row][c]=colSum;
            }
            row++;
            col++;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 3;
        int [][] queries1 = {{1,1,2,2},{0,0,1,1},{0,0,1,2}};
        int [][] output1= {{1,1,0},{1,2,1},{0,1,1}};

        //Example 2:

        int n2 = 2;
        int [][] queries2 = {{0,0,1,1}};
        int [][] output2= {{1,1},{1,1}};

        int [][] ans1=rangeAddQueries(n1,queries1);
        int [][] ans2=rangeAddQueries(n2,queries2);

    }
}
