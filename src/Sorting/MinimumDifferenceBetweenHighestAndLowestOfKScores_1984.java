//1984. Minimum Difference Between Highest and Lowest of K Scores
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
//
//Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
//
//Return the minimum possible difference.
//
//
//
//Example 1:
//
//Input: nums = [90], k = 1
//Output: 0
//Explanation: There is one way to pick score(s) of one student:
//- [90]. The difference between the highest and lowest score is 90 - 90 = 0.
//The minimum possible difference is 0.
//Example 2:
//
//Input: nums = [9,4,1,7], k = 2
//Output: 2
//Explanation: There are six ways to pick score(s) of two students:
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
//- [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
//- [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
//- [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
//The minimum possible difference is 2.
//
//
//Constraints:
//
//1 <= k <= nums.length <= 1000
//0 <= nums[i] <= 105
package Sorting;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores_1984 {
// time complexity : O( N log N)
// space complexity : O(1)
//    approch : we can sort the array and use a fixed k size sliding window to find difference
//    btw upper , lower limit of window
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int r=k-1;
        if(k==1){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        while(r<nums.length){
            res=Math.min(res, nums[r]-nums[l]);
            l++;
            r++;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {90};
        int k1 = 1;
        int output1 = 0;

        //Example 2:

        int [] nums2 = {9,4,1,7};
        int k2 = 2;
        int output2 = 2;

        int ans1 = minimumDifference(nums1,k1);
        int ans2 = minimumDifference(nums2,k2);
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
