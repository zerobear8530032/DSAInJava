//3354. Make Array Elements Equal to Zero
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//Start by selecting a starting position curr such that nums[curr] == 0, and choose a movement direction of either left or right.
//
//After that, you repeat the following process:
//
//If curr is out of the range [0, n - 1], this process ends.
//If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right, or decrementing curr if you are moving left.
//Else if nums[curr] > 0:
//Decrement nums[curr] by 1.
//Reverse your movement direction (left becomes right and vice versa).
//Take a step in your new direction.
//A selection of the initial position curr and movement direction is considered valid if every element in nums becomes 0 by the end of the process.
//
//Return the number of possible valid selections.
//
//
//
//Example 1:
//
//Input: nums = [1,0,2,0,3]
//
//Output: 2
//
//Explanation:
//
//The only possible valid selections are the following:
//
//Choose curr = 3, and a movement direction to the left.
//[1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,0].
//Choose curr = 3, and a movement direction to the right.
//[1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].
//Example 2:
//
//Input: nums = [2,3,4,0,4,1,0]
//
//Output: 0
//
//Explanation:
//
//There are no possible valid selections.
//
//
//
//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 100
//There is at least one element i where nums[i] == 0.
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeArrayElementsEqualToZero_3354 {
    public static int countValidSelections(int[] nums) {
        List<Integer> starting = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                starting.add(i);
            }
            sum += nums[i];
        }
        int valid = 0;
        for (int start : starting) {
            int[] dummy = Arrays.copyOf(nums, nums.length);
            int reduced = 0;
            while (reduced < sum) {
                boolean left = goLeft(dummy, start);
                if (left) {
                    reduced++;
                } else {
                    break;
                }
                boolean right = goRight(dummy, start);
                if (right) {
                    reduced++;
                } else {
                    break;
                }
            }
            if (reduced == sum) {
                valid++;
            }
            dummy = Arrays.copyOf(nums, nums.length);
            reduced = 0;
            while (reduced < sum) {
                boolean right = goRight(dummy, start);
                if (right) {
                    reduced++;
                } else {
                    break;
                }
                boolean left = goLeft(dummy, start);
                if (left) {
                    reduced++;
                } else {
                    break;
                }
            }
            if (reduced == sum) {
                valid++;
            }
        }
        return valid;
    }

    public static boolean goRight(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i]--;
                return true;
            }
        }
        return false;
    }

    public static boolean goLeft(int[] nums, int start) {
        for (int i = start; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[i]--;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,0,2,0,3};
        int output1= 2;

        //Example 2:

        int [] nums2 = {2,3,4,0,4,1,0};
        int output2= 0;

        int ans1 = countValidSelections(nums1);
        int ans2 = countValidSelections(nums2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }



    }
}
