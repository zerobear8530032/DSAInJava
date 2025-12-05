// we are giving a array and we hve to find
//2 subset from array which are non empty and should have minimum difference
//retunr the minimum difference btw subsets
package DynamicProgramming;

import java.util.HashMap;

public class MinimumSubSetDifference {
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static int findMinDifferenceBruteForce(int [] nums){
        return helperBruteForce(0,nums,0,0);
    }

    public static int helperBruteForce(int idx, int [] nums , int s1, int s2){
        if(idx== nums.length) {
            return Math.abs(s1-s2);
        }

        int take= helperBruteForce(idx+1,nums,s1+nums[idx],s2);
        int notTake= helperBruteForce(idx+1,nums,s1,s2+nums[idx]);
        return Math.min(take,notTake);
    }

    //    time complexity : O(n*m)
    //    space complexity : O(n*m)
    public static int findMinDifferenceBetter(int [] nums){
        return helperBetter(0,nums,0,0,new HashMap<>());
    }
    public static int helperBetter(int idx, int [] nums , int s1, int s2,HashMap<String,Integer> memo){
        String key = s1+","+s2+","+idx;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(idx== nums.length) {
            return Math.abs(s1-s2);
        }

        int take= helperBetter(idx+1,nums,s1+nums[idx],s2,memo);
        int notTake= helperBetter(idx+1,nums,s1,s2+nums[idx],memo);
        int res=Math.min(take,notTake);
        memo.put(key,res);
        return res;
    }

    // by changing approch we can reduce time and space a little
    // instead of sending both subset sum we can find total sum
    // and find subset sum2 by total - s1
    //  here we reduce the number of state form s1*s2*idx to s1*idx
//    this approch will be mich faster because array are really fast look up
    //    time complexity : O(n*m)
    //    space complexity : O(n*m)

    public static int findMinDifferenceOptimizeMemo(int [] nums) {
        int total= 0;
        for(int x:nums){
            total+=x;
        }
        Integer [][] memo= new Integer [nums.length+1][total+1];
        return helperOptimizeMemo(0,nums,0,total,memo);
    }
    public static int helperOptimizeMemo(int idx, int [] nums , int s1, int total,Integer [][] memo){
       if(memo[idx][s1]!=null){
           return memo[idx][s1];
       }
        if(idx== nums.length) {
            int s2= total-s1;
            return Math.abs(s1- s2);
        }

        int take= helperOptimizeMemo(idx+1,nums,s1+nums[idx],total,memo);
        int notTake= helperOptimizeMemo(idx+1,nums,s1,total,memo);
        int res=Math.min(take,notTake);
        memo[idx][s1]= res;
        return res;
    }
    // by changing approch we can reduce time and space a little
    // instead of sending both subset sum we can find total sum
    // and find subset sum2 by total - s1
    //  here we reduce the number of state form s1*s2*idx to s1*idx
    //    time complexity : O(n*m)
    //    space complexity : O(n*m)
    public static int findMinDifferenceOptimize(int [] nums){
        int total= 0;
        for(int x:nums){
            total+=x;
        }
        return helper(0,nums,0,total,new HashMap<>());
    }
    public static int helper(int idx, int [] nums , int s1, int total,HashMap<String,Integer> memo){
        String key = s1+","+idx;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(idx== nums.length) {
            int s2= total-s1;
            return Math.abs(s1- s2);
        }

        int take= helper(idx+1,nums,s1+nums[idx],total,memo);
        int notTake= helper(idx+1,nums,s1,total,memo);
        int res=Math.min(take,notTake);
        memo.put(key,res);
        return res;
    }

    // TOP Down approch will remove the need of recursion
    //  here we reduce the number of state form s1*s2*idx to s1*idx
    //    time complexity : O(n*m)
    //    space complexity : O(n*m)
    public static int findMinDifferenceTopDown(int [] nums){
        int n = nums.length;
        int total = 0;
        for(int x : nums) total += x;

        int [][] table = new int[n+1][total+1];

        // BASE CASE: idx == n
        for(int s1 = 0; s1 <= total; s1++){
            int s2 = total - s1;
            table[n][s1] = Math.abs(s1 - s2);
        }

        // Fill the table bottom-up
        for(int idx = n-1; idx >= 0; idx--){
            for(int s1 = 0; s1 <= total; s1++){
                int notTake = table[idx+1][s1];

                int take = Integer.MAX_VALUE;
                if(s1 + nums[idx] <= total){
                    take = table[idx+1][s1 + nums[idx]];
                }

                table[idx][s1] = Math.min(take, notTake);
            }
        }

        return table[0][0];
    }



    public static void main(String[] args) {
//        Example 1 :
        int [] nums1 = {1,6,11,5};
        int output1= 1;

//        Example 2 :
        int [] nums2 = {1};
        int output2= 1;

//        Example 3 :
        int [] nums3 = {1,2,3};
        int output3=0;

        System.out.println("Brute Force :");

        int ans1 = findMinDifferenceBruteForce(nums1);
        int ans2 = findMinDifferenceBruteForce(nums2);
        int ans3 = findMinDifferenceBruteForce(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

        System.out.println("Better Force :");

        ans1 = findMinDifferenceBetter(nums1);
        ans2 = findMinDifferenceBetter(nums2);
        ans3 = findMinDifferenceBetter(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

        System.out.println("Different Approch   :");

        ans1 = findMinDifferenceOptimize(nums1);
        ans2 = findMinDifferenceOptimize(nums2);
        ans3 = findMinDifferenceOptimize(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }


        System.out.println("Optimize Memo Approch   :");

        ans1 = findMinDifferenceOptimizeMemo(nums1);
        ans2 = findMinDifferenceOptimizeMemo(nums2);
        ans3 = findMinDifferenceOptimizeMemo(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

        System.out.println("Top Down Approch   :");

        ans1 = findMinDifferenceTopDown(nums1);
        ans2 = findMinDifferenceTopDown(nums2);
        ans3 = findMinDifferenceTopDown(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
