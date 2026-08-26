//Count Subsets with Sum
//Solved
//Difficulty: MediumAccuracy: 20.58%Submissions: 666K+Points: 4
//Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.
//
//Examples:
//
//Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
//Output: 3
//Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
//Input: arr[] = [2, 5, 1, 4, 3], target = 10
//Output: 3
//Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
//Input: arr[] = [5, 7, 8], target = 3
//Output: 0
//Explanation: There are no subsets of the array that sum up to the target 3.
//Input: arr[] = [35, 2, 8, 22], target = 0
//Output: 1
//Explanation: The empty subset is the only subset with a sum of 0.
//Constraints:
//1 ≤ arr.size() ≤ 103
//0 ≤ arr[i] ≤ 103
//0 ≤ target ≤ 103
package DynamicProgramming;

public class CountSubsetsWithSumEqualToTarget_GFG {
    // use take not take algo and memorize it
    //    time complexity : O (n*m)
    //    space complexity : O (n*m)
    static int perfectSumMemo(int[] arr, int target) {
        Integer [][] dp = new Integer [arr.length+1][target+1];
        return helperMemo(arr,target,arr.length,dp);
    }
    public static int helperMemo(int [] arr , int target , int n, Integer [][] memo){
        if(target==0 && n==0){return 1;}

        if(n==0){return 0;}
        if(memo[n][target]!=null){return memo[n][target];}

        if(arr[n-1]<=target){
            int take = helperMemo(arr,target-arr[n-1],n-1,memo);
            int skip = helperMemo(arr,target,n-1,memo);
            int res= take + skip;
            memo[n][target]= res;
            return res;
        }
        memo[n][target]= helperMemo(arr,target,n-1,memo);
        return memo[n][target];
    }
//    time and space complexity is same
//    just convert it into top down approch
        static int perfectSumTopDown(int[] arr, int target) {
            Integer [][] dp = new Integer [arr.length + 1][target + 1];
            for (int n = 0; n<dp.length; n++) {
                for (int t = 0; t<dp[n].length; t++) {
                    if (t == 0 && n==0 ) {
                        dp[n][t] = 1;
                    } else if(n==0) {
                        dp[n][t] = 0;
                    }
                }
// 			System.out.println(Arrays.toString(dp[n]));
            }
            for (int n = 1; n<dp.length; n++) {
                for (int t = 0; t<dp[0].length; t++) {// t starts with 0 because can present in the subset
                    if (arr[n - 1] <= t) {
                        int take =dp[n-1][t-arr[n-1]];
                        int skip =dp[n-1][t];
                        dp[n][t] = take+skip;
                    }else{
                        dp[n][t] = dp[n-1][t];
                    }
                }
            }
            return dp[arr.length][target];
        }
        public static int helper(int [] arr, int target, int n, Integer [][] memo) {
            if (target == 0 && n == 0) {return 1; }

            if (n == 0) {return 0; }
            if (memo[n][target] != null) {return memo[n][target]; }

            if (arr[n - 1] <= target) {
                int take = helper(arr, target - arr[n - 1], n - 1, memo);
                int skip = helper(arr, target, n - 1, memo);
                int res = take + skip;
                memo[n][target] = res;
                return res;
            }
            memo[n][target] = helper(arr, target, n - 1, memo);
            return memo[n][target];
        }

    public static void main(String[] args) {
        //Examples 1:

        int [] arr1= {5, 2, 3, 10, 6, 8};
        int target1 = 10;
        int output1 =3;        //Examples 1:

       int [] arr2 = {2, 5, 1, 4, 3};
       int target2 = 10;
        int output2= 3;

        int [] arr3 = {5, 7, 8};
        int target3 = 3;
        int output3= 0;

       int [] arr4 = {35, 2, 8, 22};
       int target4 = 0;
       int output4 =1;


        System.out.println("Recusion memorization approch :");

       int ans1 = perfectSumMemo(arr1,target1);
       int ans2 = perfectSumMemo(arr2,target2);
       int ans3 = perfectSumMemo(arr3,target3);
       int ans4 = perfectSumMemo(arr4,target4);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        if(ans4==output4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Expected Ouput :"+ (output4));
            System.out.println("Your Answer :"+ ans4);
        }
        System.out.println("Top Down approch :");
       ans1 = perfectSumTopDown(arr1,target1);

       ans2 = perfectSumTopDown(arr2,target2);
       ans3 = perfectSumTopDown(arr3,target3);
       ans4 = perfectSumTopDown(arr4,target4);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        if(ans4==output4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Expected Ouput :"+ (output4));
            System.out.println("Your Answer :"+ ans4);
        }


    }
}
