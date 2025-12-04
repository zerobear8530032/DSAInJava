//416. Partition Equal Subset Sum
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
//
//
//
//Example 1:
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//Constraints:
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100
package DynamicProgramming;

public class PartitionEqualSubsetSum_416 {

    public static boolean canPartitionDPMemo(int[] nums) {
        int total =0;
        for(int x:nums){
            total+=x;
        }
        if(total%2!=0){
            return false;
        }
        int target =total/2;
        Boolean [][] memo = new Boolean [nums.length+1][target+1];
        return findSubSetEqualsTarget(0,target,nums, memo);
    }
    public static boolean findSubSetEqualsTarget(int idx, int target, int[] nums,Boolean [][]memo) {

        if(memo[idx][target]!=null){
            return memo[idx][target];
        }
        if(idx==nums.length){
            return target==0;
        }
        if(target==0){
            return true;
        }
        if(target-nums[idx]>=0){
            boolean take= findSubSetEqualsTarget(idx+1,target-nums[idx],nums,memo);
            boolean notTake= findSubSetEqualsTarget(idx+1,target,nums,memo);
            boolean res= take || notTake;
            memo[idx][target]=res;
            return res;
        }

        boolean notTake= findSubSetEqualsTarget(idx+1,target,nums,memo);

        memo[idx][target]=notTake;
        return notTake;
    }

    public static boolean canPartitionTopDown(int[] nums) {
        int total =0;
        for(int x:nums){
            total+=x;
        }
        if(total%2!=0){
            return false;
        }
        boolean [][] table = new boolean [nums.length+1][(total/2)+1];
        table[nums.length][0]=true;
        for(int idx=nums.length-1;idx>=0;idx--){
            for(int target=0;target<=total/2;target++){
                if(target>=nums[idx]){
                    boolean take =table[idx+1][target-nums[idx]];
                    boolean notTake =  table[idx+1][target];
                    table[idx][target]= take || notTake;
                }else{
                    boolean notTake =  table[idx+1][target];
                    table[idx][target] =notTake;
                }
            }
        }
        return table[0][total/2];
    }
    public static void main(String[] args) {
        //
        //Example 1:

        int [] nums1 = {1,5,11,5};
        boolean output1= true;

        //Example 2:

        int [] nums2 = {1,2,3,5};
        boolean output2= false;

        System.out.println("DP Memo :");

        boolean ans1= canPartitionDPMemo(nums1);
        boolean ans2= canPartitionDPMemo(nums2);

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

        System.out.println("Top Down :");

         ans1= canPartitionTopDown(nums1);
         ans2= canPartitionTopDown(nums2);

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

    }
}
