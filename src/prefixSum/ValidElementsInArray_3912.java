//3912. Valid Elements in an Array
//Solved
//Easy
//premium lock icon
//Companies
//You are given an integer array nums.
//
//An element nums[i] is considered valid if it satisfies at least one of the following conditions:
//
//It is strictly greater than every element to its left.
//It is strictly greater than every element to its right.
//The first and last elements are always valid.
//
//Return an array of all valid elements in the same order as they appear in nums.
//
//Example 1:
//
//Input: nums = [1,2,4,2,3,2]
//Output: [1,2,4,3,2]
//
//Example 2:
//
//Input: nums = [5,5,5,5]
//Output: [5,5]
//
//Example 3:
//
//Input: nums = [1]
//Output: [1]
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

package prefixSum;

import java.util.*;

public class ValidElementsInArray_3912 {

    public static List<Integer> findValidElements(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];

        int lmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lmax = Math.max(nums[i - 1], lmax);
            leftMax[i] = lmax;
        }

        int rmax = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            rmax = Math.max(nums[i + 1], rmax);
            rightMax[i] = rmax;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == nums.length - 1 || leftMax[i] < nums[i] || rightMax[i] < nums[i]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {1, 2, 4, 2, 3, 2};
        List<Integer> output1 = Arrays.asList(1, 2, 4, 3, 2);

        // Example 2:
        int[] nums2 = {5, 5, 5, 5};
        List<Integer> output2 = Arrays.asList(5, 5);

        // Example 3:
        int[] nums3 = {1};
        List<Integer> output3 = Arrays.asList(1);

        List<Integer> ans1 = findValidElements(nums1);
        List<Integer> ans2 = findValidElements(nums2);
        List<Integer> ans3 = findValidElements(nums3);

        if (output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }

        if (output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}