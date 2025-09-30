//2221. Find Triangular Sum of an Array
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
//
//The triangular sum of nums is the value of the only element present in nums after the following process terminates:
//
//Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
//For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
//Replace the array nums with newNums.
//Repeat the entire process starting from step 1.
//Return the triangular sum of nums.
//
//
//
//Example 1:
//
//
//Input: nums = [1,2,3,4,5]
//Output: 8
//Explanation:
//The above diagram depicts the process from which we obtain the triangular sum of the array.
//Example 2:
//
//Input: nums = [5]
//Output: 5
//Explanation:
//Since there is only one element in nums, the triangular sum is the value of that element itself.
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//0 <= nums[i] <= 9
package DynamicProgramming;

public class FindTriangularSumOfAnArray_2221 {
//     approch : here we just simulate whats ask but we will use  single temp array which we swap with original array to
//    reuse it
//    time complexity : O(n^2)
//    space complexity : O(n)
    public static int triangularSum(int[] nums) {
        int n = nums.length;
        int [] temp = new int [nums.length];
        while(n!=1){
            for(int i =0;i<n-1;i++){
                temp[i]= (nums[i]+nums[i+1])%10;
            }
            n--;
            // swap references :
            int [] swap=  temp;
            temp=nums;
            nums=swap;
        }
        return nums[0];
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,4,5};
        int output1= 8;

        //Example 2:

        int [] nums2 = {5};
        int output2= 5;

        int ans1= triangularSum(nums1);
        int ans2= triangularSum(nums2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }



    }
}
