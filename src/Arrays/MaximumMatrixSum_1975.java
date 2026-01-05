//1975. Maximum Matrix Sum
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an n x n integer matrix. You can do the following operation any number of times:
//
//Choose any two adjacent elements of matrix and multiply each of them by -1.
//Two elements are considered adjacent if and only if they share a border.
//
//Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,-1],[-1,1]]
//Output: 4
//Explanation: We can follow the following steps to reach sum equals 4:
//- Multiply the 2 elements in the first row by -1.
//- Multiply the 2 elements in the first column by -1.
//Example 2:
//
//
//Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
//Output: 16
//Explanation: We can follow the following step to reach sum equals 16:
//- Multiply the 2 last elements in the second row by -1.
//
//
//Constraints:
//
//n == matrix.length == matrix[i].length
//2 <= n <= 250
//-105 <= matrix[i][j] <= 105
package Arrays;

public class MaximumMatrixSum_1975 {
    public static long maxMatrixSum(int[][] matrix) {
        long sum =0;
        int negCount=0;
        long negative=0;
        long posMin=Integer.MAX_VALUE;
        boolean containsZero=false;
        long greatestNeg=Integer.MIN_VALUE;
        for(int [] row : matrix){
            for(int x:row){
                if(x==0){
                    containsZero=true;
                }else if(x<0){
                    negCount++;
                    negative+=x;
                    greatestNeg= Math.max(x,greatestNeg);
                }else{
                    sum+=x;
                    posMin = Math.min(posMin,x);
                }
            }
        }

        if(negCount%2==0 || containsZero){
            return sum + Math.abs(negative);
        }else{
            if(posMin<Math.abs(greatestNeg)){
                return (sum + Math.abs(negative)-(posMin*2));
            }else{
                return (sum + Math.abs(negative))+(greatestNeg*2);
            }
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] matrix1 = {{1,-1},{-1,1}};
        int output1=4;

        //Example 2:

        int [][] matrix2 = {{1,2,3},{-1,-2,-3},{1,2,3}};
        int output2=16;

        //Example 3:

        int [][] matrix3 = {{-1,0,-1},{-2,1,3},{3,2,2}};
        int output3=15;

        long ans1= maxMatrixSum(matrix1);
        long ans2= maxMatrixSum(matrix2);
        long ans3= maxMatrixSum(matrix3);


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
