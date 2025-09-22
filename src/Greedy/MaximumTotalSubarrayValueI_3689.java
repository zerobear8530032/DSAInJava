//3689. Maximum Total Subarray Value I
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n and an integer k.
//
//You need to choose exactly k non-empty subarrays nums[l..r] of nums. Subarrays may overlap, and the exact same subarray (same l and r) can be chosen more than once.
//
//The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
//
//The total value is the sum of the values of all chosen subarrays.
//
//Return the maximum possible total value you can achieve.
//
//
//
//Example 1:
//
//Input: nums = [1,3,2], k = 2
//
//Output: 4
//
//Explanation:
//
//One optimal approach is:
//
//Choose nums[0..1] = [1, 3]. The maximum is 3 and the minimum is 1, giving a value of 3 - 1 = 2.
//Choose nums[0..2] = [1, 3, 2]. The maximum is still 3 and the minimum is still 1, so the value is also 3 - 1 = 2.
//Adding these gives 2 + 2 = 4.
//
//Example 2:
//
//Input: nums = [4,2,5,1], k = 3
//
//Output: 12
//
//Explanation:
//
//One optimal approach is:
//
//Choose nums[0..3] = [4, 2, 5, 1]. The maximum is 5 and the minimum is 1, giving a value of 5 - 1 = 4.
//Choose nums[0..3] = [4, 2, 5, 1]. The maximum is 5 and the minimum is 1, so the value is also 4.
//Choose nums[2..3] = [5, 1]. The maximum is 5 and the minimum is 1, so the value is again 4.
//Adding these gives 4 + 4 + 4 = 12.
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 5 * 10​​​​​​​4
//0 <= nums[i] <= 109
//1 <= k <= 105
package Greedy;

public class MaximumTotalSubarrayValueI_3689 {
//    approch:  here we know one thing we can take any subarray which should not be empty
//    but can take a single sub array multiple times then  after taking sub array we wana find max  and min of that
//    and take difference of them
//    so we can assume we just need to find max and min of entire sub array because in directly we want that only
//    and we can just keep taking it k time so we can find the difference once and multiple it by k
//    making it similar to taking it k times
//     time complexity : O(n)
//     space complexity : O(1)
    public long maxTotalValue(int[] nums, int k) {
        long max =Integer.MIN_VALUE;
        long min =Integer.MAX_VALUE;
        for(int x:nums){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        long res= (max-min)*k;
        return res;
    }


    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,3,2};
        int k1 = 2;
        int output1= 4;

        //Example 2:

        int [] nums2 = {4,2,5,1};
        int k2 = 3;
        int output2= 12;

        int ans1 =

    }
}
