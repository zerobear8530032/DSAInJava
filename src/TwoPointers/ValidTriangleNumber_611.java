//611. Valid Triangle Number
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
//
//
//
//Example 1:
//
//Input: nums = [2,2,3,4]
//Output: 3
//Explanation: Valid combinations are:
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
//Example 2:
//
//Input: nums = [4,2,3,4]
//Output: 4
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//0 <= nums[i] <= 1000
package TwoPointers;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
//    approch : here we can use 2 pointer first we will sort the array \
//    now we can  pointer starting from right hand side taking the largest element
//    and use 2 pointer btw 0 to k-1 to find sum > nums[k]
//    if we found it all the pairs btw nums[i] till nums[j] will be valid
//    because if we increase i  the array is sorted means it will not reduce the sum
//    so we can just use j-i to get distance btw them and add to the counter
//    and reduce j-- because we have to check rest of pairs
//     but if pairs are not valid we cn increase i because it will increase the sum

//     time complexity : O( n log n + n)
//     space complexity : O(1)
        public static int triangleNumber(int[] nums) {
            int n = nums.length;
            //
            Arrays.sort(nums);
            int count = 0;
            for (int k = n - 1; k >= 2; k--) { // largest element after sorting
                int i = 0;
                int j = k - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j];
                    if(sum<=nums[k]){i++;}
                    else if (sum > nums[k]) {
                        count+=j-i;
                        j--;
                    }
                }
            }
            return count;
        }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,2,3,4};
        int output1= 3;

        //Example 2:

        int [] nums2 = {4,2,3,4};
        int output2= 4;


        int ans1 = triangleNumber(nums1);
        int ans2 = triangleNumber(nums2);


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
