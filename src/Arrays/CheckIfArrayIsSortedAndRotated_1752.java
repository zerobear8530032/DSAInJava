//1752. Check if Array Is Sorted and Rotated
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
//
//There may be duplicates in the original array.
//
//Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.
//
//
//
//Example 1:
//
//Input: nums = [3,4,5,1,2]
//Output: true
//Explanation: [1,2,3,4,5] is the original sorted array.
//You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
//Example 2:
//
//Input: nums = [2,1,3,4]
//Output: false
//Explanation: There is no sorted array once rotated that can make nums.
//Example 3:
//
//Input: nums = [1,2,3]
//Output: true
//Explanation: [1,2,3] is the original sorted array.
//You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
package Arrays;

public class CheckIfArrayIsSortedAndRotated_1752 {
//    if its rotated sorted their will be a single drop point where arr[i]<arr[i+1]
//    so we cn check it
//    time complexity : O(n)
//    spac complexity : O(1)
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {3,4,5,1,2};
        boolean output1=true;

        //Example 2:

        int [] nums2 = {2,1,3,4};
        boolean output2= false;

        //Example 3:

        int [] nums3= {1,2,3};
        boolean output3= true;

        boolean ans1= check(nums1);
        boolean ans2= check(nums2);
        boolean ans3= check(nums3);
        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
        if (output3 == ans3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}
