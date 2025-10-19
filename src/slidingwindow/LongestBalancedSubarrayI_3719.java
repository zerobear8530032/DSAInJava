//3719. Longest Balanced Subarray I
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.
//
//Return the length of the longest balanced subarray.
//
//
//
//Example 1:
//
//Input: nums = [2,5,4,3]
//
//Output: 4
//
//Explanation:
//
//The longest balanced subarray is [2, 5, 4, 3].
//It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [5, 3]. Thus, the answer is 4.
//Example 2:
//
//Input: nums = [3,2,2,5,4]
//
//Output: 5
//
//Explanation:
//
//The longest balanced subarray is [3, 2, 2, 5, 4].
//It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [3, 5]. Thus, the answer is 5.
//Example 3:
//
//Input: nums = [1,2,3,2]
//
//Output: 3
//
//Explanation:
//
//The longest balanced subarray is [2, 3, 2].
//It has 1 distinct even number [2] and 1 distinct odd number [3]. Thus, the answer is 3.
//
//
//Constraints:
//
//1 <= nums.length <= 1500
//1 <= nums[i] <= 105

package slidingwindow;

import java.util.HashSet;

public class LongestBalancedSubarrayI_3719 {
//    approch :
//    here we use brute force way where we use 2 hashset and try every single sub array
//    and track max
//    time complexity : O(n*n)
//    space complexity : O(n*n)
    public static int longestBalanced(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> even = new HashSet();
            HashSet<Integer> odd = new HashSet();
            int j = i;
            for (; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if (even.size() == odd.size()) {
                    int size = j - i+1;
                    max = Math.max(size, max);
                }
            }

        }
        return max;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,5,4,3};
        int output1=4;

        //Example 2:


        int [] nums2 = {3,2,2,5,4};
        int output2=5;

        //Example 3:

        int [] nums3 = {1,2,3,2};
        int output3=3;

        int ans1 = longestBalanced(nums1);
        int ans2 = longestBalanced(nums2);
        int ans3 = longestBalanced(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }


    }
}
