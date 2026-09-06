//Matrix Chain Multiplication
//Solved
//Difficulty: HardAccuracy: 49.64%Submissions: 205K+Points: 8
//Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.
//
//Examples:
//
//Input: arr[] = [2, 1, 3, 4]
//Output: 20
//Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let this 3 input matrices be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)), note that the result of (M1 x M2) is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix.
//((M1 x M2) x M3)  requires (2 x 1 x 3) + (2 x 3 x 4) = 30
//(M1 x (M2 x M3))  requires (1 x 3 x 4) + (2 x 1 x 4) = 20.
//The minimum of these two is 20.
//Input: arr[] = [1, 2, 3, 4, 3]
//Output: 30
//Explanation: There are 4 matrices of dimensions 1 × 2, 2 × 3, 3 × 4, 4 × 3. Let this 4 input matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1 x M2) x M3) x M4). The minimum number is (1 x 2 x 3) + (1 x 3 x 4) + (1 x 4 x 3) = 30.
//Input: arr[] = [3, 4]
//Output: 0
//Explanation: As there is only one matrix so, there is no cost of multiplication.
//Constraints:
//2 ≤ arr.size() ≤ 100
//1 ≤ arr[i] ≤ 200
package DynamicProgramming;

public class MatrixChainMultiplication_GFG {
//    approch :
//    time complexity : O(m*n*k)
//    space complexity : O(m*n*k)
    public static int matrixMultiplication(int arr[]) {
        Integer [][] memo= new Integer[arr.length+1][arr.length+1];
        return solve(arr,1,arr.length-1,memo);
    }

    public static int solve(int [] arr, int i , int j,Integer [][] memo){
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(i>=j){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tempRes = arr[i-1]*arr[k]*arr[j] + solve(arr,i,k,memo)+ solve(arr,k+1,j,memo);
            res=Math.min(res,tempRes);
        }
        memo[i][j]= res;
        return res;
    }
    public static void main(String[] args) {
        // Example 1:
        int [] arr1= {2,1,3,4};
        int output1= 20;

        // Example 2:
        int [] arr2= {1,2,3,4,3};
        int output2= 30;

        // Example 3:
        int [] arr3= {3,4};
        int output3= 0;

        int ans1=   matrixMultiplication(arr1);
        int ans2=   matrixMultiplication(arr2);
        int ans3=   matrixMultiplication(arr3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
