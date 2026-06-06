//2574. Left and Right Sum Differences
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed integer array nums of size n.
//
//Define two arrays leftSum and rightSum where:
//
//leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
//rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
//Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
//
//
//
//Example 1:
//
//Input: nums = [10,4,8,3]
//Output: [15,1,11,22]
//Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
//The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
//Example 2:
//
//Input: nums = [1]
//Output: [0]
//Explanation: The array leftSum is [0] and the array rightSum is [0].
//The array answer is [|0 - 0|] = [0].
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= nums[i] <= 105
package prefixSum;

import java.util.Arrays;

public class LeftAndRightSumDifferences_2574 {
//   computer prefix sum of with 1 offset from left to right and right to left
//   then just take difference absolute value of their index vlaues
//   time complexity : O(n)
//   space complexity : O(n)
    public static int[] leftRightDifference(int[] nums) {
        int [] left = new int [nums.length];
        int [] right = new int [nums.length];
        int [] res= new int [nums.length];
        int lsum=0;
        for(int i =1;i<nums.length;i++){
            lsum+=nums[i-1];
            left[i]=lsum;
        }
        int rsum=0;
        for(int i =nums.length-2;i>=0;i--){
            rsum+=nums[i+1];
            right[i]=rsum;
        }
        for(int i =0;i<nums.length;i++){
            res[i]=Math.abs(left[i]-right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {10,4,8,3};
        int [] output1= {15,1,11,22};

        //Example 2:

        int [] nums2 = {1};
        int [] output2= {0};

        int [] ans1= leftRightDifference(nums1);
        int [] ans2= leftRightDifference(nums2);

        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }

    }

}
