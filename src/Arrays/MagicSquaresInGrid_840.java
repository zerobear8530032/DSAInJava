//840. Magic Squares In Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//
//Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
//
//Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
//
//
//
//Example 1:
//
//
//Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
//Output: 1
//Explanation:
//The following subgrid is a 3 x 3 magic square:
//
//while this one is not:
//
//In total, there is only one magic square inside the given grid.
//Example 2:
//
//Input: grid = [[8]]
//Output: 0
//
//
//Constraints:
//
//row == grid.length
//col == grid[i].length
//1 <= row, col <= 10
//0 <= grid[i][j] <= 15
package Arrays;

public class MagicSquaresInGrid_840 {
//    approch :
//    we can go from each grid and check 3 * 3 size grid for sum == 15
//    row col , and diagonal wise the operation will remain constant time
//    we also check the numbers are unique using a bit mask where each bit 1 indicate it exists
//    other wise not making the bitmask equla 1022 if 1 to 9 number are present
//    time complexity : O(n*m)
//    space complexity : O(1)

//    note using prefix sum here will just increase space without providing any fsat processing
//
    public static int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicGrid(grid, i, j)) {
                    // System.out.println(i+"  "+j);
                    res++;
                }
            }
        }
        return res;
    }

    public static boolean isMagicGrid(int[][] grid, int row, int col) {
        int bitmask=0;
        //  every row :
        int sum = 15;
        for (int r = row; r < row + 3; r++) {
            int rowSum = 0;
            for (int c = col; c < col + 3; c++) {
                if (grid[r][c] > 9 || grid[r][c] <=0 ) {
                    // System.out.println("only 1 to 9 allowed  row" + r + "  col " + col);
                    return false;
                }
                int bit = 1<< grid[r][c];
                bitmask= bitmask | bit;
                rowSum += grid[r][c];
            }
            if (rowSum != sum) {
                // System.out.println("Rows sum is not eequal :");
                return false;
            }
        }
        // check cols
        for (int c = col; c < col + 3; c++) {
            int colSum = 0;
            for (int r = row; r < row + 3; r++) {
                if (grid[r][c] > 9 || grid[r][c] <=0) {
                    // System.out.println("only 1 to 9 allowed  row" + row + "  col " + col);
                    return false;
                }
                int bit = 1<< grid[r][c];
                bitmask= bitmask | bit;
                colSum += grid[r][c];
            }
            if (colSum != sum) {
                // System.out.println("col sum is not equal :" + row + "  " + col);

                return false;
            }
        }
        // check left Diagonal
        int ldigsum=0;
        for (int r = row, c = col; r < row + 3 && c < col + 3; r += 1, c += 1) {
            if (grid[r][c] > 9 || grid[r][c] <=0) {
                // System.out.println("only 1 to 9 allowed  row" + row + "  col " + col);
                return false;
            }else{
                int bit = 1<< grid[r][c];
                bitmask= bitmask | bit;
                ldigsum+= grid[r][c];
            }
            // System.out.println(r + "  " + c);
        }
        if(ldigsum!=sum){return false;}
        // check right Diagonal
        int rdigsum=0;
        for (int r = row+2, c = col; r >= row && c < col + 3; r -= 1, c += 1) {
            if (grid[r][c] > 9 || grid[r][c] <=0) {
                // System.out.println("only 1 to 9 allowed  row" + row + "  col " + col);
                return false;
            }else{
                int bit = 1<< grid[r][c];
                bitmask= bitmask | bit;
                rdigsum+= grid[r][c];
            }
            // System.out.println(r + "  " + c);
        }
        if(rdigsum!=sum){return false;}
        // System.out.println(Integer.toBinaryString(bitmask));
        // System.out.println(bitmask);
        return bitmask ==1022;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int output1=1;

        //Example 2:

        int [][] grid2 = {{0}};
        int output2=0;


        int ans1= numMagicSquaresInside(grid1);
        int ans2= numMagicSquaresInside(grid2);

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

    }
}
