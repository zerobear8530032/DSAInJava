package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class knapsackProblem {
//   0/1 knap sack :
//   questions include :
//    subset problems where we make choices either take some value or leave it
    public static int findMaxValue(int [] weights,int [] value,int capacity){
        return helper(0,weights,value,capacity);
    }
    public  static int helper(int idx, int [] weights,int [] values,int capacity){
        if(idx==values.length || capacity==0) {
            return 0;
        }
        if(weights[idx]>capacity){
            return helper(idx+1,weights,values,capacity);
        }
        int skip = helper(idx+1,weights,values,capacity);
        int take = values[idx]+helper(idx+1,weights,values,capacity-weights[idx]);
        return Math.max(skip,take);

    }


    public static int findMaxValueMemo(int [] weights,int [] value,int capacity){
        return helper(0,weights,value,capacity, new HashMap<String,Integer> ());
    }
    public  static int helper(int idx, int [] weights, int [] values, int capacity, HashMap<String,Integer> memo){
        String key = idx+","+capacity;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(idx==values.length || capacity==0) {
            return 0;
        }
        if(weights[idx]>capacity){
            int skip= helper(idx+1,weights,values,capacity);
            memo.put(key,skip);
            return skip;
        }
        int skip = helper(idx+1,weights,values,capacity);
        int take = values[idx]+helper(idx+1,weights,values,capacity-weights[idx]);
        int res=Math.max(skip,take);
        memo.put(key,res);

        return res;

    }

    public static int findMaxValueDP(int[] weights, int[] values, int capacity) {
        int n = values.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // dp[n][c] = 0 already by default (no items left)

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int cap = 0; cap <= capacity; cap++) {

                int skip = dp[idx + 1][cap];
                int take = 0;

                // If weight fits
                if (weights[idx] <= cap) {
                    take = values[idx] + dp[idx + 1][cap - weights[idx]];
                }

                dp[idx][cap] = Math.max(skip, take);
            }
        }

        return dp[0][capacity]; // starting at first item with full capacity
    }


    public static void main(String[] args) {
//        Example 1 :

        int []weights1 = {1, 2, 3};
        int [] values1= {6,10,12};
        int capacity1=5;
        int output1= 22;

//        Example 2 :

        int [] weights2 = {2, 2, 4, 5};
        int []values2  = {3, 4, 5, 7};
        int capacity2 = 7;
        int output2= 11;

//        Example 3 :

        int [] weights3 = {3, 4, 6, 5};
        int []values3  = {2, 3, 1, 4};
        int capacity3 = 8;
        int output3= 6;

        System.out.println("Brute Force Approch :");

        int ans1 = findMaxValue(weights1,values1,capacity1);
        int ans2 = findMaxValue(weights2,values2,capacity2);
        int ans3 = findMaxValue(weights3,values3,capacity3);

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

        System.out.println("Memo Approch :");
        ans1 = findMaxValueMemo(weights1,values1,capacity1);
        ans2 = findMaxValueMemo(weights2,values2,capacity2);
        ans3 = findMaxValueMemo(weights3,values3,capacity3);

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

        System.out.println("DP Approch :");
        ans1 = findMaxValueDP(weights1,values1,capacity1);
        ans2 = findMaxValueDP(weights2,values2,capacity2);
        ans3 = findMaxValueDP(weights3,values3,capacity3);

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
    }
}
