//3788. Maximum Score of a Split
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n.
//
//Choose an index i such that 0 <= i < n - 1.
//
//For a chosen split index i:
//
//Let prefixSum(i) be the sum of nums[0] + nums[1] + ... + nums[i].
//Let suffixMin(i) be the minimum value among nums[i + 1], nums[i + 2], ..., nums[n - 1].
//The score of a split at index i is defined as:
//
//score(i) = prefixSum(i) - suffixMin(i)
//
//Return an integer denoting the maximum score over all valid split indices.
//
//
//
//Example 1:
//
//Input: nums = [10,-1,3,-4,-5]
//
//Output: 17
//
//Explanation:
//
//The optimal split is at i = 2, score(2) = prefixSum(2) - suffixMin(2) = (10 + (-1) + 3) - (-5) = 17.
//
//Example 2:
//
//Input: nums = [-7,-5,3]
//
//Output: -2
//
//Explanation:
//
//The optimal split is at i = 0, score(0) = prefixSum(0) - suffixMin(0) = (-7) - (-5) = -2.
//
//Example 3:
//
//Input: nums = [1,1]
//
//Output: 0
//
//Explanation:
//
//The only valid split is at i = 0, score(0) = prefixSum(0) - suffixMin(0) = 1 - 1 = 0.
//
//
//
//Constraints:
//
//2 <= nums.length <= 105
//-109​​​​​​​ <= nums[i] <= 109
package prefixSum;

public class MaximumScoreOfASplit_3788 {
//    approch : here we just simiulate what is said
//    by creating prefix sum array amd suffix min array
//    note the suffix min array have 1 number off set
//    time complexity : O(n)
//    space complexity : O(n)
    public static long maximumScore(int[] nums) {
        int n= nums.length;
        long [] prefixSum = new long [n];
        long [] suffixMin = new long [n];
        long sum=0;
        for(int i =0;i<n;i++){
            sum+= nums[i];
            prefixSum[i]=sum;
        }
        long min = Integer.MAX_VALUE;
        for(int i =n-1;i>=0;i--){
            min = Math.min(min,nums[i]);
            suffixMin[i]=min;
        };
        // System.out.println(Arrays.toString(prefixSum));
        // System.out.println(Arrays.toString(suffixMin));
        long res= Long.MIN_VALUE;
        for(int i =0;i<=n-2;i++){
            long curr_res= prefixSum[i]-suffixMin[i+1];
            res=Math.max(curr_res,res);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {10,-1,3,-4,-5};
        int output1= 17;

        //Example 2:

        int [] nums2 = {-7,-5,3};
        int output2= -2;

        //Example 3:

        int [] nums3 = {1,1};
        int output3= 0;

        long ans1= maximumScore(nums1);
        long ans2= maximumScore(nums2);
        long ans3= maximumScore(nums3);

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
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}
