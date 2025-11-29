// subset sum equals k
package DynamicProgramming;

import java.util.HashMap;

public class SubsetSum {
    public static boolean subsetSumEqualsTargetBruteForce(int [] nums , int k){
        return helper(nums,k,nums.length);
    }
    public static boolean helper( int [] nums , int k , int idx){
        if(k==0){
            return true;
        }
        if(idx==0) {
            return false;
        }

        if(nums[idx-1]<=k){
            boolean take = helper(nums,k-nums[idx-1],idx-1);
            boolean notTake = helper(nums,k,idx-1);
            return take || notTake;
        }
        return helper(nums,k,idx-1);
    }

    public static boolean subsetSumEqualsTargetMemo(int [] nums , int k){
        return helperMemo(nums,k,nums.length, new HashMap<>());
    }
    public static boolean helperMemo( int [] nums , int k , int idx, HashMap<String,Boolean> memo){
        String key = idx+","+k;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(k==0){
            return true;
        }
        if(idx==0) {
            return false;
        }

        if(nums[idx-1]<=k){
            boolean take = helperMemo(nums,k-nums[idx-1],idx-1,memo);
            boolean notTake = helperMemo(nums,k,idx-1,memo);
            boolean res= take || notTake;
            memo.put(key,res);
            return res;
        }
        boolean res= helperMemo(nums,k,idx-1,memo);
        memo.put(key,res);
        return res;

    }

    public static boolean subsetSumEqualsTargetDPMemo(int [] nums , int k){
        Boolean [][] memo = new Boolean [nums.length+1][k+1];
        return helperDPMemo(nums,k,nums.length,memo );
    }
    public static boolean helperDPMemo( int [] nums , int k , int idx, Boolean [][] memo){
        if(memo[idx][k]!=null){
            return memo[idx][k];
        }
        if(k==0){
            return true;
        }
        if(idx==0) {
            return false;
        }

        if(nums[idx-1]<=k){
            boolean take = helperDPMemo(nums,k-nums[idx-1],idx-1,memo);
            boolean notTake = helperDPMemo(nums,k,idx-1,memo);
            boolean res= take || notTake;
            memo[idx][k]= res;
            return res;
        }
        boolean res= helperDPMemo(nums,k,idx-1,memo);
        memo[idx][k]= res;
        return res;
    }


    public static boolean subsetSumEqualsTargetDPTopDown(int [] nums , int k){
        Boolean [][] table = new Boolean [nums.length+1][k+1];
        for(int i=0;i<table.length;i++){
            for(int s =0;s<table[0].length;s++){
                if(s==0){
                    table[i][s]= true;
                    continue;
                }else if(i==0){
                    table[i][s]= false;
                    continue;
                }
                if(i-1>=0 && nums[i-1]<=s){
                    int currentVal = nums[i-1];
                    boolean take = table[i-1][s-currentVal];
                    boolean notTake = table[i-1][s];
                    table[i][s]= take || notTake;
                }else if(i-1>=0){
                    table[i][s]=table[i-1][s];
                }
            }
        }
        return table[nums.length][k];
    }
    public static void main(String[] args) {
        int [] nums1={3, 34, 4, 12, 5, 2};
        int k1= 9;
        boolean output1=true;  // subset {4,5}

        int [] nums2={1, 2, 7, 1, 5};
        int k2=10;
        boolean output2=true;  // subset {4,5}

        int [] nums3={2, 4, 6, 8};
        int k3=5;
        boolean output3=false;  // subset {4,5}

        System.out.println("Brute Force Approch :");

        boolean ans1= subsetSumEqualsTargetBruteForce(nums1,k1);
        boolean ans2= subsetSumEqualsTargetBruteForce(nums2,k2);
        boolean ans3= subsetSumEqualsTargetBruteForce(nums3,k3);

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

        System.out.println("Memorize Approch :");
        ans1= subsetSumEqualsTargetMemo(nums1,k1);
        ans2= subsetSumEqualsTargetMemo(nums2,k2);
        ans3= subsetSumEqualsTargetMemo(nums3,k3);

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


        System.out.println("DP Memorize Approch :");
        ans1= subsetSumEqualsTargetDPMemo(nums1,k1);
        ans2= subsetSumEqualsTargetDPMemo(nums2,k2);
        ans3= subsetSumEqualsTargetDPMemo(nums3,k3);

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


        System.out.println("DP Top Down  Approch :");
        ans1= subsetSumEqualsTargetDPTopDown(nums1,k1);
        ans2= subsetSumEqualsTargetDPTopDown(nums2,k2);
        ans3= subsetSumEqualsTargetDPTopDown(nums3,k3);

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
