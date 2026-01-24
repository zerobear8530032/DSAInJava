//1877. Minimize Maximum Pair Sum in Array
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
//
//For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
//Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
//
//Each element of nums is in exactly one pair, and
//The maximum pair sum is minimized.
//Return the minimized maximum pair sum after optimally pairing up the elements.
//
//
//
//Example 1:
//
//Input: nums = [3,5,2,3]
//Output: 7
//Explanation: The elements can be paired up into pairs (3,3) and (5,2).
//The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
//Example 2:
//
//Input: nums = [3,5,4,2,4,6]
//Output: 8
//Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
//The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
//
//
//Constraints:
//
//n == nums.length
//2 <= n <= 105
//n is even.
//1 <= nums[i] <= 105
package Sorting;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray_1877 {
//    approch: here once we sort we can combine largest element with smallest and find the max sum among them
//    time complexity : N log n
//    space complexity : 1
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int s=0;
        int e=nums.length-1;
        int res=Integer.MIN_VALUE;
        while(s<e){
            res=Math.max(res,nums[s]+nums[e]);
            s++;
            e--;
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {3,5,2,3};
        int output1= 7;

        //Example 2:

        int [] nums2 = {3,5,4,2,4,6};
        int output2= 8;

        int ans1= minPairSum(nums1);
        int ans2= minPairSum(nums2);
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
