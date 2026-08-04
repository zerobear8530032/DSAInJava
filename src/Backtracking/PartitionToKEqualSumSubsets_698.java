//698. Partition to K Equal Sum Subsets
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
//
//
//
//Example 1:
//
//Input: nums = [4,3,2,3,5,2,1], k = 4
//Output: true
//Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//Example 2:
//
//Input: nums = [1,2,3,4], k = 3
//Output: false
//
//
//Constraints:
//
//1 <= k <= nums.length <= 16
//1 <= nums[i] <= 104
//The frequency of each element is in the range [1, 4].
package Backtracking;

public class PartitionToKEqualSumSubsets_698 {
//    approch :
//    we can create a k length array and put element in that and bakc track
//    making sure sum is same accross all if yes return true
//    other wise false;
//    time complexity : O(n · 2^n)
//    space complexity : O(2^n)
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%k!=0){
            return false;
        }
        int [] subsets= new int [k];
        return helper(nums,subsets,0,sum/k);
    }

    public static boolean helper(int [] nums , int [] subsets, int idx,int target){
        if(idx==nums.length){
            return true;
        }
        for(int i =0;i<subsets.length;i++){
            if(subsets[i]+nums[idx]<=target){
                subsets[i]+=nums[idx];
                boolean res= helper(nums,subsets,idx+1,target);
                subsets[i]-=nums[idx];
                if(res){
                    return true;
                }
                if(subsets[i]==0){
                    break;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {4,3,2,3,5,2,1};
        int k1= 4;
        boolean output1= true;

        //Example 2:

        int [] nums2 = {1,2,3,4};
        int k2 = 3;
        boolean output2= false;

        boolean ans1= canPartitionKSubsets(nums1,k1);
        boolean ans2= canPartitionKSubsets(nums2,k2);


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
