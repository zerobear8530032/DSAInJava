//3381. Maximum Subarray Sum With Length Divisible by K
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of integers nums and an integer k.
//
//Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.
//
//
//
//Example 1:
//
//Input: nums = [1,2], k = 1
//
//Output: 3
//
//Explanation:
//
//The subarray [1, 2] with sum 3 has length equal to 2 which is divisible by 1.
//
//Example 2:
//
//Input: nums = [-1,-2,-3,-4,-5], k = 4
//
//Output: -10
//
//Explanation:
//
//The maximum sum subarray is [-1, -2, -3, -4] which has length equal to 4 which is divisible by 4.
//
//Example 3:
//
//Input: nums = [-5,1,2,-3,4], k = 2
//
//Output: 4
//
//Explanation:
//
//The maximum sum subarray is [1, 2, -3, 4] which has length equal to 4 which is divisible by 2.
//
//
//
//Constraints:
//
//1 <= k <= nums.length <= 2 * 105
//-109 <= nums[i] <= 109
package prefixSum;

public class MaximumSubarraySumWithLengthDivisibleByK_3381 {
    public  static long maxSubarraySum(int[] nums, int k) {
        long sum=0;
        long [] prefixSum = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            prefixSum[i]=sum;
        }
        long res=Long.MIN_VALUE;
        // System.out.println(Arrays.toString(prefixSum));
        for(int left =0;left<nums.length;left++){
            for(int right=left+k;right<=nums.length;right+=k){
                long leftSum=0;
                if(left-1>=0){
                    leftSum=prefixSum[left-1];
                }
                long rightSum = prefixSum[right-1];
                long rangeSum = rightSum-leftSum;
                res=Math.max(res,rangeSum);
                // System.out.println(leftSum+" "+rightSum+" "+rangeSum);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2};
        int k1 = 1;
        int output1= 3;

        //Example 2:

        int [] nums2 = {-1,-2,-3,-4,-5};
        int k2 = 4;
        int output2= -10;

        //Example 3:


        int [] nums3 = {-5,1,2,-3,4};
        int k3 = 2;
        int output3= 4;

        long ans1 = maxSubarraySum(nums1,k1);
        long ans2 = maxSubarraySum(nums2,k2);
        long ans3 = maxSubarraySum(nums3,k3);


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
