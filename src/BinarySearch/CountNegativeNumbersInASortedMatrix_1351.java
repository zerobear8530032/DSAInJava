//1351. Count Negative Numbers in a Sorted Matrix
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
//
//
//
//Example 1:
//
//Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//Output: 8
//Explanation: There are 8 negatives number in the matrix.
//Example 2:
//
//Input: grid = [[3,2],[1,0]]
//Output: 0
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 100
//-100 <= grid[i][j] <= 100
//
//
//Follow up: Could you find an O(n + m) solution?
//
package BinarySearch;

public class CountNegativeNumbersInASortedMatrix_1351 {

//approch : check every cell
//    time complexity : O(n*m)
//    space complexity : O(1)

    public static int countNegativesBruteForce(int[][] grid) {
        int res=0;
        for(int [] row:grid){
            for(int cell:row){
                if(cell<0){res++;}
            }
        }
        return res;
    }
//  approch Better
//    we can use binary search per row to find first negative number and rest will be negative
//    time complexity : O(n log m)
//    space complexity : O( 1)
    public static int countNegativesBetter(int[][] grid) {
    int res=0;
    for(int [] row:grid){
        int negidx=binarySearch(row);
        res+= row.length-negidx-1;
        // System.out.println(negidx);
    }
    return res;
}

    public static int binarySearch(int [] row){
        int s=0;
        int e = row.length-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(row[mid]<0){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return e;
    }
//  approch Best:
//    we can use a traversal algo where we strt from top right corner
//    if current number is negative we can assum entire cols of brlow rows are
//    also negative and move left side
//    if the current cell is positive we move down wards
//    that all we need to do
//    time complexity : O(n+m)
//    space complexity : O( 1)
    public static int countNegativesBest(int[][] grid) {
        int r=0;
        int c= grid[0].length-1;
        int res=0;
        int trow = grid.length;
        int tcol = grid[0].length;
        while(r<trow && c>=0){
            // System.out.println(r+"   "+c);
            if(grid[r][c]<0){
                res+= trow-r;
                c--;
            }else{
                r++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int output1=8;

        //Example 2:

        int [][] grid2 = {{3,2},{1,0}};
        int output2=0;

        System.out.println("Brute Force Approch :");

        int ans1 = countNegativesBruteForce(grid1);
        int ans2 = countNegativesBruteForce(grid2);

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

        System.out.println("Better Approch :");

        ans1 = countNegativesBetter(grid1);
        ans2 = countNegativesBetter(grid2);

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
        System.out.println("Best Force Approch :");

        ans1 = countNegativesBest(grid1);
        ans2 = countNegativesBest(grid2);

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
