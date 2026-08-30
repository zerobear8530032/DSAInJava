//2091. Removing Minimum and Maximum From Array
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given a 0-indexed array of distinct integers nums.
//
//There is an element in nums that has the lowest value and an element that has
//the highest value. We call them the minimum and maximum respectively.
//
//Your goal is to remove both these elements from the array.
//
//A deletion is defined as either removing an element from the front of the
//array or removing an element from the back of the array.
//
//Return the minimum number of deletions it would take to remove both the
//minimum and maximum element from the array.
//
//
//Example 1:
//
//Input: nums = [2,10,7,5,4,1,8,6]
//
//Output: 5
//
//Explanation:
//The minimum element in the array is nums[5], which is 1.
//The maximum element in the array is nums[1], which is 10.
//
//We can remove both the minimum and maximum by removing 2 elements from the
//front and 3 elements from the back.
//
//This results in 2 + 3 = 5 deletions, which is the minimum number possible.
//
//
//Example 2:
//
//Input: nums = [0,-4,19,1,8,-2,-3,5]
//
//Output: 3
//
//Explanation:
//The minimum element in the array is nums[1], which is -4.
//The maximum element in the array is nums[2], which is 19.
//
//We can remove both the minimum and maximum by removing 3 elements from the
//front.
//
//This results in only 3 deletions, which is the minimum number possible.
//
//
//Example 3:
//
//Input: nums = [101]
//
//Output: 1
//
//Explanation:
//There is only one element in the array, which makes it both the minimum and
//maximum element. We can remove it with 1 deletion.
//
//
//Constraints:
//
//1 <= nums.length <= 10^5
//-10^5 <= nums[i] <= 10^5
//The integers in nums are distinct.

package Greedy;

public class RemovingMinimumAndMaximumFromArray_2091 {

    //  greedy approach
    //
    //  First find the indices of the minimum and maximum elements.
    //
    //  There are only three possible ways to remove both elements:
    //
    //  1. Remove everything from the left.
    //     We need to remove elements until we reach the element that is
    //     farther from the left.
    //
    //  2. Remove everything from the right.
    //     We need to remove elements until we reach the element that is
    //     closer to the left.
    //
    //  3. Remove from both sides.
    //     Remove from the left until reaching the element closer to the left,
    //     and remove from the right until reaching the element farther to
    //     the right.
    //
    //  Calculate the number of deletions for all three possibilities and
    //  return the minimum.
    //
    //  Time Complexity: O(n)
    //  Space Complexity: O(1)

    public static int minimumDeletions(int[] nums) {

        int minIdx = 0;
        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        // Find minimum and maximum elements and their indices.
        for (int i = 0; i < nums.length; i++) {

            if (min > nums[i]) {
                min = nums[i];
                minIdx = i;
            }

            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }

        // Remove both elements from the left.
        int leftToRight = Math.max(minIdx, maxIdx) + 1;

        // Remove both elements from the right.
        int rightToLeft = nums.length - Math.min(minIdx, maxIdx);

        // Remove one element from the left and the other from the right.
        int leftRemove = Math.min(minIdx, maxIdx) + 1;
        int rightRemove = nums.length - Math.max(minIdx, maxIdx);

        return Math.min(
                leftToRight,
                Math.min(rightToLeft, leftRemove + rightRemove)
        );
    }

    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {2, 10, 7, 5, 4, 1, 8, 6};
        int output1 = 5;

        // Example 2
        int[] nums2 = {0, -4, 19, 1, 8, -2, -3, 5};
        int output2 = 3;

        // Example 3
        int[] nums3 = {101};
        int output3 = 1;

        int ans1 = minimumDeletions(nums1);
        int ans2 = minimumDeletions(nums2);
        int ans3 = minimumDeletions(nums3);

        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output : " + output1);
            System.out.println("Your Output   : " + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output : " + output2);
            System.out.println("Your Output   : " + ans2);
        }

        if (output3 == ans3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output : " + output3);
            System.out.println("Your Output   : " + ans3);
        }
    }
}