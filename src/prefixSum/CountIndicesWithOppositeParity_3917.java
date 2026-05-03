//3917. Count Indices With Opposite Parity
//Solved
//Easy
//premium lock icon
//Companies
//You are given an integer array nums of length n.
//
//The score of an index i is defined as the number of indices j such that:
//
//i < j < n, and
//nums[i] and nums[j] have different parity (one is even and the other is odd).
//
//Return an integer array answer of length n, where answer[i] is the score of index i.
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [2,1,1,0]
//
//Example 2:
//
//Input: nums = [1]
//Output: [0]
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

package prefixSum;

import java.util.Arrays;

public class CountIndicesWithOppositeParity_3917 {

    // Time Complexity: O(n)
    // single backward pass + single forward pass

    // Space Complexity: O(n)
    // using evenCount, oddCount, and result arrays

    public static int[] countOppositeParity(int[] nums) {

        int[] evenCount = new int[nums.length];
        int[] oddCount = new int[nums.length];

        int even = 0;
        int odd = 0;

        int[] res = new int[nums.length];

        // Step 1: count suffix even/odd
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            evenCount[i] = even;
            oddCount[i] = odd;
        }

        // Step 2: compute result
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[i] = oddCount[i];
            } else {
                res[i] = evenCount[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {1, 2, 3, 4};
        int[] output1 = {2, 1, 1, 0};

        // Example 2:
        int[] nums2 = {1};
        int[] output2 = {0};

        int[] ans1 = countOppositeParity(nums1);
        int[] ans2 = countOppositeParity(nums2);

        if (Arrays.equals(output1, ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output1));
            System.out.println("Your Output :" + Arrays.toString(ans1));
        }

        if (Arrays.equals(output2, ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output2));
            System.out.println("Your Output :" + Arrays.toString(ans2));
        }
    }
}