package DynamicProgramming;

import java.util.HashMap;

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
        return helpermemo(0,weights,value,capacity, new HashMap<String,Integer> ());
    }
    public  static int helpermemo(int idx, int [] weights, int [] values, int capacity, HashMap<String,Integer> memo){
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


    public static int findMaxValueReverse(int[] weights, int[] values, int capacity) {
        return helperRev(weights,values,capacity,weights.length);
    }

    public static int helperRev(int [] weights, int [] values , int capacity, int idx){
        if(capacity==0 || idx==0) {
            return 0;
        }
        int weight= weights[idx-1];
        int res=0;
        if(weight<=capacity){
            int take = values[idx-1]+helperRev(weights,values,capacity-weight,idx-1);
            int notTake = helperRev(weights,values,capacity,idx-1);
            return Math.max(take,notTake);
        }
        return helperRev(weights,values,capacity,idx-1);
    }
    public static int findMaxValueMemoReverse(int[] weights, int[] values, int capacity) {
        int [][] memo = new int [weights.length+1][capacity+1];
        return helperMemoRev(weights,values,capacity,weights.length,memo);
    }

    public static int helperMemoRev(int [] weights, int [] values , int capacity, int idx, int [][] memo){
        if(capacity==0 || idx==0) {
            return 0;
        }
        int weight= weights[idx-1];
        int res=0;
        if(weight<=capacity){
            int take = values[idx-1]+helperMemoRev(weights,values,capacity-weight,idx-1,memo);
            int notTake = helperMemoRev(weights,values,capacity,idx-1,memo);
            memo[idx][capacity]= Math.max(notTake,take);
            return memo[idx][capacity];
        }
        memo[idx][capacity]= helperMemoRev(weights,values,capacity,idx-1,memo);
        return memo[idx][capacity];
    }

    public static int findMaxValueReveseTopDown(int[] weights, int[] values, int capacity) {
        int [][] table = new int [weights.length+1][capacity+1];
        for(int i =0;i<table.length;i++){
            for(int c=0;c<table[0].length;c++){
                if(i==0 || c==0){// initalize base cases
                    table[i][c]=0;
                }else{
                    if(i-1>=0 && weights[i-1]<=c){
                        int take =  values[i-1]+table[i-1][c-weights[i-1]];
                        int notTake =  table[i-1][c];
                        table[i][c]= Math.max(take,notTake);
                    }else{
                        table[i][c]= table[i-1][c];
                    }
                }
            }
        }
        return table[weights.length][capacity];
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

        System.out.println("Reverse Brute Force  Approch :");
        ans1 = findMaxValueReverse(weights1,values1,capacity1);
        ans2 = findMaxValueReverse(weights2,values2,capacity2);
        ans3 = findMaxValueReverse(weights3,values3,capacity3);

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

        System.out.println("Reverse Memo  Approch :");
        ans1 = findMaxValueMemoReverse(weights1,values1,capacity1);
        ans2 = findMaxValueMemoReverse(weights2,values2,capacity2);
        ans3 = findMaxValueMemoReverse(weights3,values3,capacity3);

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

        System.out.println("Top Down DP Approch :");
        ans1 = findMaxValueReveseTopDown(weights1,values1,capacity1);
        ans2 = findMaxValueReveseTopDown(weights2,values2,capacity2);
        ans3 = findMaxValueReveseTopDown(weights3,values3,capacity3);

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
